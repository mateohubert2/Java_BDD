import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        PolySportsDatabase poly_sport = PolySportsDatabase.getInstance();
        poly_sport.connect();
        SportsDAO dao = new SportsDAO(poly_sport);
        ArrayList<Sport> sports = dao.findAll();
        Sport sport = dao.findById(1);
        for(int i = 0; i < sports.size(); i++){
            System.out.println("Pour le sport: " + sports.get(i).getName() + " il faut: " + sports.get(i).getRequiredParticipants() + " participants et c'est le sport ayant pour id: " + sports.get(i).getId());
        }
        System.out.println("Pour le sport: " + sport.getName() + " il faut: " + sport.getRequiredParticipants() + " participants et c'est le sport ayant pour id: " + sport.getId());
    }
}
