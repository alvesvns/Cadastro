import java.sql.Connection;

public class ConnectionTest {
    public static void main(String[] args) {
        
        try {
            Connection conn = Connect.getConnection();
            System.out.println("Conectado com sucesso!");
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
