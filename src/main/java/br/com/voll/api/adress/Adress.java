package br.com.voll.api.adress;

import br.com.voll.api.doctors.DoctorUpdateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Adress(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String uf,
        String complements,
        String number) {


}
