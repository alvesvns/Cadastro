import java.util.ArrayList;
import java.util.List;

public class ValidatorCpf {
    
    public List<String> validate(RegistrationData registrationData) {
        List<String> erros = new ArrayList<>();

        if (!isCpfValid(registrationData.getCpf())) {
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


