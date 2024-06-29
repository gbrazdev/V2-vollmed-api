package br.com.voll.api.doctors;

import br.com.voll.api.adress.Adress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorsDTO(

        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Specialties specialties,
        @NotNull
        Integer status,
        @NotNull
        @Valid
        Adress adress) {
}
