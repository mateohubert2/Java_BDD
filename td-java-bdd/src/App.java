import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection myConnection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3307/poly_sports",
              "mateo" ,
              "esirem"
            );
            Statement myStatement = myConnection.createStatement();
            ResultSet results = myStatement.executeQuery("SELECT `name`, `required_participants` FROM `sport`;");
            while(results.next()){
                final String name = results.getString("name");
                final int number = results.getInt("required_participants");
                System.out.println("Pour le sport: " + name + ", il faut: " + number + " participants");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
