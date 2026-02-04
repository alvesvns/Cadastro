import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ValidatorAge {
    
    public List<String> validate(RegistrationData registrationData) {
        List<String> erros = new ArrayList<>();

        LocalDate nasc = registrationData.getNascimento();
        if (nasc == null) {
            erros.add("- Data de nascimento inválida");
        } else {
            int idade = Period.between(nasc, LocalDate.now()).getYears();
            registrationData.setIdade(idade);
            if (idade < 16) {
                erros.add("- É necessário ter no mínimo 16 anos");
            }
        }

        return erros;
    }
}

