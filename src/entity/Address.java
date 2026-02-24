package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private Integer id;

    public String getAddressText() {
        return rua + ", " + bairro + ", " + cidade + " - " + uf + " - " + cep;
    }
}
