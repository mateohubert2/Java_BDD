import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLDatabase {
    private String host;
    private int port;
    private String databaseName;
    private String user;
    private String password;
    private Connection connection;
    private static boolean driverLoaded;
    MYSQLDatabase(String host, int port, String databaseName, String user, String password){
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
        connection = null;
        driverLoaded = false;
        loadDriver();
    }
    public void connect(){
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://"+host+":"+port+"/" + databaseName+"?allowMultiQueries=true",
                user ,
                password
                );
            //connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public Statement createStatement(){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return statement;
    }
    private static void loadDriver(){
        if(driverLoaded != true){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
            driverLoaded = true;
        }
    }
}
