package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/trabalho2";

    private static final String USER = "postgres";
    private static final String PASSWORD = "@Garrafa123";

    public static Connection getConnection() throws SQLException {
        try {
            // ESSA LINHA É A QUE FALTAVA PARA O DRIVER SER RECONHECIDO:
            Class.forName("org.postgresql.Driver");
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do PostgreSQL não encontrado: " + e.getMessage());
        }
    }
}