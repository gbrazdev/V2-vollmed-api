package br.com.voll.api.doctors;




import br.com.voll.api.adress.Adress;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDTO(
        @NotNull
        Long id,
        String name,
        String email,
        String phone,
        Integer status,
        Adress adress
) {
}
