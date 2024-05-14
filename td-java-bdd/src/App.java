import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        MYSQLDatabase mysql = new MYSQLDatabase("localhost", 3307, "poly_sports", "mateo", "esirem");
        mysql.connect();
        //mysql.createStatement();
    }
}
