import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        PolySportsDatabase poly_sport = PolySportsDatabase.getInstance();
        poly_sport.connect();
        Sport sport = new Sport(2, "natation", 1);
        System.out.println("Pour faire le sport: " + sport.getName()+ ", il faut: " + sport.getRequiredParticipants() + " participant et c'est le sport: " + sport.getId());
    }
}
