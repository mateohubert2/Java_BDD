import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SportsDAO {
    private MYSQLDatabase database;
    
    public SportsDAO(MYSQLDatabase database){
        this.database = database;
    }
    public ArrayList<Sport> findAll(){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        Statement myStatement = database.createStatement();
        try {
            ResultSet myResults = myStatement.executeQuery("SELECT `name`, `id`, `required_participants` FROM `sport`;");
            while(myResults.next()){
                int id = myResults.getInt("id");
                String name = myResults.getString("name");
                int required_participants = myResults.getInt("required_participants");
                Sport sport = new Sport(id, name, required_participants);
                sports.add(sport);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return sports;
    }
    public Sport findById(int sport){
        //Statement myStatement = database.createStatement();
        String commande = "SELECT `name`, `id`, `required_participants` FROM `sport` WHERE `id` = ?;";
        PreparedStatement mypreparedStatement = database.prepareStatement(commande);
        try {
            mypreparedStatement.setInt(1, sport);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Sport sport_voulu = null;
        try {
            //ResultSet myResults = myStatement.executeQuery("SELECT `name`, `id`, `required_participants` FROM `sport` WHERE `id` = "+sport+";");
            ResultSet myResults = mypreparedStatement.executeQuery();
            while(myResults.next()){
                int id = myResults.getInt("id");
                String name = myResults.getString("name");
                int required_participants = myResults.getInt("required_participants");
                sport_voulu = new Sport(id, name, required_participants);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return sport_voulu;
    }
    public ArrayList<Sport> findByName(String nom){
        //Statement myStatement = database.createStatement();
        String commande = "SELECT * FROM `sport` WHERE `name` LIKE ? ORDER BY `name`;";
        PreparedStatement mypreparedStatement = database.prepareStatement(commande);
        try {
            mypreparedStatement.setString(1, "%"+nom+"%");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        ArrayList<Sport> sports = new ArrayList<Sport>();
        try {
            //ResultSet myResults = myStatement.executeQuery("SELECT * FROM `sport` WHERE `name` LIKE '%"+nom+"%';");
            ResultSet myResults = mypreparedStatement.executeQuery();
            while(myResults.next()){
                int id = myResults.getInt("id");
                String name = myResults.getString("name");
                int required_participants = myResults.getInt("required_participants");
                Sport temp_sport = new Sport(id, name, required_participants);
                sports.add(temp_sport);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return sports;
    }
}
