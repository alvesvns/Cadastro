import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ValidatorAll {
    public static List<String> validateAll(RegistrationData registrationData) {
    List<String> erros = new ArrayList<>();
    
    // Adiciona erros de validação de nome
    erros.addAll(new ValidatorName().validate(registrationData));
    
    // Adiciona erros de validação de idade
    erros.addAll(new ValidatorAge().validate(registrationData));
    
    // Adiciona erros de validação de CPF
    erros.addAll(new ValidatorCpf().validate(registrationData));

    return erros;
}

}
