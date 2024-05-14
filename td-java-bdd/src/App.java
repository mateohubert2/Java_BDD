import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        PolySportsDatabase poly_sport = PolySportsDatabase.getInstance();
        poly_sport.connect();
    }
}
