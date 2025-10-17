import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbccon {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = "root"; // your MySQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}



