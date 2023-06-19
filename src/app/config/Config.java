package app.config;
import java.sql.Connection;
import java.sql.DriverManager;

public class Config {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_mipa";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    private static Connection connect;

    public static Connection connection(){
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection: Gagal");
        }
        return connect;
    }
}
