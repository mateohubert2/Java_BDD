public class PolySportsDatabase extends MYSQLDatabase{
    private static PolySportsDatabase instance;
    private PolySportsDatabase(){
        super("localhost", 3307, "poly_sports", "mateo", "esirem");
        instance = null;
    }
    public static PolySportsDatabase getInstance(){
        if(instance == null){
            instance = new PolySportsDatabase();
        }
        return instance;
    }
}
