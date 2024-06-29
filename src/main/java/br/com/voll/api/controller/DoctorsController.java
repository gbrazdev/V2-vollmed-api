package br.com.voll.api.controller;

import br.com.voll.api.doctors.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping
    public ResponseEntity<Page<DoctorListDTO>> getDcotrs(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var doctors = doctorRepository.findAll(paginacao).map(DoctorListDTO::new);
        return ResponseEntity.ok(doctors);
    }

    @PostMapping
    @Transactional
    public void registerDoctor(@RequestBody @Valid DoctorsDTO doctor) {
        doctorRepository.save(new Doctor(doctor));
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody DoctorUpdateDTO doctorUpdateDTO) {
        var doctor = doctorRepository.getReferenceById(doctorUpdateDTO.id());
        doctor.updateRegister(doctorUpdateDTO);
    }


    @GetMapping("/{id}")
    public Doctor getDcotrById(@PathVariable Long id) {
        var doctor = doctorRepository.findById(id);
        if (doctor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return doctor.get();

    }

    @DeleteMapping("/{id}")
    public void deleteDcotrById(@PathVariable Long id) {
        var doctor = doctorRepository.findById(id);
        if (doctor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        doctorRepository.deleteById(id);
    }

    @PutMapping("/status/{id}")
    @Transactional
    public void updateStatusDoctor(@PathVariable Long id, @RequestBody DoctorUpdateDTO doctorUpdateDTO) {
        try {
            var doctor = doctorRepository.getReferenceById(id);
            doctor.updateRegister(doctorUpdateDTO);
            
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
