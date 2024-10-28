import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // URL подключения к вашей базе данных PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/hltvdb";  // Ваш URL
    private static final String USER = "postgres";  // Ваше имя пользователя
    private static final String PASSWORD = "zazazin61";  // Ваш пароль

    // Метод для подключения к базе данных
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Успешное подключение к базе данных PostgreSQL.");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();  // Подключаемся к базе данных
    }
}
