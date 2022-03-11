import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<String> file = null;
    public static List<Food> foodList = new LinkedList<>();
    private static Connection con;
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "";

        try{
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Verbindung geht oida!");
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE FOOD (ID INT(6), NAME VARCHAR(30), FOOD_GROUP VARCHAR(30), CALORIES INT(6), FAT INT(6), PROTEINS INT(6), CARBOHYDRATES INT(6), SUAGAR INT(6), FIBER INT(6), CHOLESTEROL INT(6), SATURATED_FATS INT(6)");
        }catch (Exception e){
            System.out.println("Fuck");
        };
        file = readFromFile();
        splitFile();
    }
    public static List<String> readFromFile(){
        try{
            return Files.readAllLines(Paths.get("data/DatabaseFoodReal.csv"));
        }
        catch (Exception e){
            System.out.println("Couldnt read from file!");
        }
        return new LinkedList<>();
    }
    public static void splitFile(){
        for (int i = 1; i < file.size(); i++){
            String[] splitted = file.get(i).split(",");
            foodList.add(new Food(Integer.parseInt(splitted[0]), splitted[1], splitted[2], splitted[3],
                    splitted[4], splitted[5], splitted[6], splitted[7], splitted[8], splitted[9], splitted[10]));
        }
    }
}
