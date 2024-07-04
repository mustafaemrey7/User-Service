import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/peoples";  // Veritabanı URL'si
    private static final String USER = "postgres";  // Veritabanı kullanıcı adı
    private static final String PASSWORD = "1";  // Veritabanı şifresi

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}