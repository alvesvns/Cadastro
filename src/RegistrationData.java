
import java.time.LocalDate;

public class RegistrationData {
 
    private String nome;
    private String cpf;
    private String nascFormatada;
    private int idade;
    private LocalDate nascimento;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf;}
    
    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }
    
    public String getNascFormatada() { return nascFormatada; }
    public void setNascFormatada(String nascFormatada) { this.nascFormatada = nascFormatada; }
    
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    
    
}

