import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class RegistrationData {
 
    private String nome;
    private String cpf;
    private String nascFormatada;
    private int idade;
    private LocalDate nascimento;
}

