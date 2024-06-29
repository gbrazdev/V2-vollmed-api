package br.com.voll.api.doctors;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorListDTO(
        Long id,
        String name,
        String email,
        String crm,
        Specialties specialties
) {

    public DoctorListDTO(Doctor doctor){
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getEscpecialites()
                );
    }
}
