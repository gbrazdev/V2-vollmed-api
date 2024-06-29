package br.com.voll.api.adress;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AdressModel {


    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String complements;
    private String number;


    public AdressModel(Adress adress) {
        this.street = adress.street();
        this.number = adress.number();
        this.neighborhood = adress.neighborhood();
        this.city = adress.city();
        this.uf = adress.uf();
        this.cep = adress.cep();
        this.complements = adress.complements();
    }


    public void updateAdress(Adress adress) {
        if (adress.street() != null) {
            this.street = adress.street();
        }
        if (adress.number() != null) {
            this.number = adress.number();
        }
        if (adress.neighborhood() != null) {
            this.neighborhood = adress.neighborhood();
        }
        if (adress.complements() != null) {
            this.complements = adress.complements();
        }
        if (adress.city() != null) {
            this.city = adress.city();
        }
        if (adress.uf() != null) {
            this.uf = adress.uf();
        }
        if (adress.cep() != null) {
            this.cep = adress.cep();
        }
    }
}
