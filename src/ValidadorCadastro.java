/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author karan
 */
public class ValidadorCadastro {
    public static List<String> validar(DadosCadastro d){
        List<String> erros = new ArrayList<>();
        
        String nome = d.getNome() == null ? "" : d.getNome().trim();
        if (nome.length() < 3) {
            erros.add("- Nome inválido");
        }
        if (nome.matches(".*\\d.*")) {
            erros.add("- Nome inválido");
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
        String cpf = d.getCpf() == null ? "" : d.getCpf();
        String cpfNumeros = cpf.replaceAll("\\D", "");
        if (cpfNumeros.length() != 11) {
            erros.add("- CPF incompleto");
        }
        return erros;
    }
}
