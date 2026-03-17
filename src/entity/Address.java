package entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Address {
    private Integer id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    
    public Address() {
    }

    public Address(Integer id) {
        setId(id);
    }
    
    public boolean isInsert() {
        return id == null;
    }

    public boolean isEdit() {
        return id != null;
    }
    
    public List<String> validate() {
        List<String> erros = new ArrayList<>();

        erros.addAll(validateCep());
        erros.addAll(validateRua());
        erros.addAll(validateBairro());
        erros.addAll(validateCidade());
        erros.addAll(validateUf());
        
        return erros;
    }
    
    public List<String> validateCep() {
        List<String> erros = new ArrayList<>();

        if (cep == null || cep.isBlank()) {
            erros.add("- CEP é obrigatório.");
        } else if (!isCepValid(cep)) {
            erros.add("- CEP deve conter 8 números.");
        }
        return erros;
    }

    public List<String> validateRua() {
        List<String> erros = new ArrayList<>();

        String ruaTrim = rua == null ? "" : rua.trim();

        if (ruaTrim.isEmpty()) {
            erros.add("- Rua é obrigatória.");
        } 
        else if (ruaTrim.length() < 3) {
            erros.add("- Rua deve ter no mínimo 3 letras.");
        } 
        else if (!ruaTrim.matches("^[A-Za-zÀ-ÿ0-9\\s.]+$")) {
            erros.add("- Rua contém caracteres inválidos.");
        }

        return erros;
    }

    public List<String> validateBairro() {
        List<String> erros = new ArrayList<>();

        String bairroTrim = bairro == null ? "" : bairro.trim();

        if (bairroTrim.isEmpty()) {
            erros.add("- Bairro é obrigatório.");
        } 
        else if (bairroTrim.length() < 3) {
            erros.add("- Bairro deve ter no mínimo 3 letras.");
        } 
        else if (!bairroTrim.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
            erros.add("- Bairro inválido.");
        }

        return erros;
    }

    public List<String> validateCidade() {
        List<String> erros = new ArrayList<>();

        String cidadeTrim = cidade == null ? "" : cidade.trim();

        if (cidadeTrim.isEmpty()) {
            erros.add("- Cidade é obrigatória.");
        } 
        else if (cidadeTrim.length() < 2) {
            erros.add("- Cidade deve ter no mínimo 2 letras.");
        } 
        else if (!cidadeTrim.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
            erros.add("- Cidade inválida.");
        }

        return erros;
    }

    public List<String> validateUf() {
        List<String> erros = new ArrayList<>();

        if (uf == null || uf.isBlank()) {
            erros.add("- UF é obrigatória.");
        } 
        else if (!uf.matches("^[A-Z]{2}$")) {
            erros.add("- UF inválida.");
        }

        return erros;
    }
    
    private boolean isCepValid(String cep) {
        if (cep == null) return false;

        String cepNumeros = cep.replaceAll("[^0-9]", "");

        return cepNumeros.length() == 8;
    }

    public String getAddressText() {
        return rua + ", " + bairro + ", " + cidade + " - " + uf + " - " + cep;
    }
}
