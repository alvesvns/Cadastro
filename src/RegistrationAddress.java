import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationAddress {
                
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
}
