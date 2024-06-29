package br.com.voll.api.doctors;


import br.com.voll.api.adress.AdressModel;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "doctors")
@Entity(name = "Doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String crm;

    private Integer status;

    @Enumerated(EnumType.STRING)
    private Specialties escpecialites;

    @Embedded
    private AdressModel adress;

    public Doctor(DoctorsDTO doctor) {
        this.status = 1;
        this.name = doctor.name();
        this.crm = doctor.crm();
        this.email = doctor.email();
        this.phone = doctor.phone();
        this.escpecialites = doctor.specialties();
        this.adress = new AdressModel(doctor.adress());
    }

    public void updateRegister(DoctorUpdateDTO doctorUpdateDTO) {
        if (doctorUpdateDTO.name() != null) {
            this.name = doctorUpdateDTO.name();
        }
        if (doctorUpdateDTO.phone() != null) {
            this.phone = doctorUpdateDTO.phone();
        }
        if (doctorUpdateDTO.email() != null) {
            this.email = doctorUpdateDTO.email();
        }
        if (doctorUpdateDTO.status() != null) {
            this.status = doctorUpdateDTO.status();
        }
        if (doctorUpdateDTO.adress() != null) {
            this.adress.updateAdress(doctorUpdateDTO.adress());
        }
    }


}
