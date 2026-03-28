package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class Connect {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try {
            Properties props = new Properties();

            InputStream input = Connect.class
                    .getClassLoader()
                    .getResourceAsStream("infra/db.properties");

            if (input == null) {
                throw new RuntimeException("Arquivo db.properties não encontrado!");
            }

            props.load(input);

            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");

        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
