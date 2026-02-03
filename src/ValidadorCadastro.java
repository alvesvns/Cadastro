/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ValidadorCadastro {

    public static List<String> validar(DadosCadastro d) {
        List<String> erros = new ArrayList<>();

        String nome = d.getNome() == null ? "" : d.getNome().trim();
        if (nome.isEmpty()) {
            erros.add("- Nome é obrigatório");
        } else {
            if (nome.matches(".*\\d.*")){
                erros.add("- Nome inválido");
            }
        
            String[] partes = nome.split("\\s+");
            if (partes.length < 2) {
                erros.add("- Informe nome e sobrenome");
            } else {
                for (String parte : partes) {
                    if (parte.length() < 2) {
                        erros.add("- Nome inválido");
                        break;
                    }
                }
            }
        }

        LocalDate nasc = d.getNascimento();
        if (nasc == null) {
            erros.add("- Data de nascimento inválida");
        } else {
            int idade = Period.between(nasc, LocalDate.now()).getYears();
            d.setIdade(idade);
            if (idade < 16) {
                erros.add("- É necessário ter no mínimo 16 anos");
            }
        }

        if (!cpfValido(d.getCpf())) {
            erros.add("- CPF inválido");
        }

        return erros;
    }

    private static boolean cpfValido(String cpf) {
        if (cpf == null) return false;

        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11) return false;
        if (cpf.matches("(\\d)\\1{10}")) return false;

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int dig1 = 11 - (soma % 11);
        if (dig1 >= 10) dig1 = 0;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int dig2 = 11 - (soma % 11);
        if (dig2 >= 10) dig2 = 0;

        return dig1 == Character.getNumericValue(cpf.charAt(9))
            && dig2 == Character.getNumericValue(cpf.charAt(10));
    }
}
