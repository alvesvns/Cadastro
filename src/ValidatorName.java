import java.util.ArrayList;
import java.util.List;

public class ValidatorName {

    public List<String> validate(RegistrationData registrationData) {
        List<String> erros = new ArrayList<>();

        String nome = registrationData.getNome() == null ? "" : registrationData.getNome().trim();
        if (nome.isEmpty()) {
            erros.add("- Nome é obrigatório");
        } else {
            if (nome.matches(".*\\d.*")) {
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

        return erros;
    }
}


