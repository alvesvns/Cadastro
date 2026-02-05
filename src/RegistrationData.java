import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistrationData {
 
    private String name;
    private String cpf;
    private String formattedBirth;
    private int age;
    private LocalDate birth;
    
    public List<String> validate() {
        List<String> erros = new ArrayList<>();

        erros.addAll(validateName());
        erros.addAll(validateAge());
        erros.addAll(validateCpf());
        
        return erros;
    }

    private List<String> validateName() {
        List<String> erros = new ArrayList<>();
        String name = this.getName() == null ? "" : this.getName().trim();
        
        if (name.isEmpty()) {
            erros.add("- Nome é obrigatório");
        } else {
            if (name.matches(".*\\d.*")) {
                erros.add("- Nome inválido");
            }

            String[] partes = name.split("\\s+");
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
        
        return erros;
    }

    private List<String> validateAge() {
        List<String> erros = new ArrayList<>();
        LocalDate birth = this.getBirth();

        if (birth == null) {
            erros.add("- Data de nascimento inválida");
        } else {
            int age = Period.between(birth, LocalDate.now()).getYears();
            this.setAge(age);
            if (age < 16) {
                erros.add("- É necessário ter no mínimo 16 anos");
            }
        }

        return erros;
    }

    private List<String> validateCpf() {
        List<String> erros = new ArrayList<>();

        if (!isCpfValid(this.getCpf())) { // o "!" Antes vai servir para negação, então fica isCpfInvalid
            erros.add("- CPF inválido");
        }

        return erros;
    }

    private boolean isCpfValid(String cpf) {
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

        return dig1 == Character.getNumericValue(cpf.charAt(9)) && dig2 == Character.getNumericValue(cpf.charAt(10));
    }
}

