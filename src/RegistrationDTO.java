import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private Integer id;
    private RegistrationData registrationData;
    private RegistrationAddress registrationAddress;
}
