import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<String> file = null;
    public static List<Food> foodList = new LinkedList<>();
    private static Connection con;
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/food_list";
        String user = "root";
        String pass = "";
        try{
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Verbindung geht oida!");
        }catch (Exception e){
            System.out.println("Fuck");
        }
        file = readFromFile();
        splitFile();
        addToTable();
    }
    public static void addToTable() throws SQLException {
        //Statement statement2 = con.createStatement();
        //statement2.execute("INSERT INTO food SET name = 'John', id = '1';");

        for (int i = 0; i < foodList.size(); i++){
            HashMap<String, String> nutrition = foodList.get(i).getmNutritions();
            if (nutrition.get("Kalorien") == null){
                nutrition.replace("Kalorien", null, "");
            }
            if (nutrition.get("Fett") == null){
                nutrition.replace("Fett", null, "");
            }
            if (nutrition.get("Proteine") == null){
                nutrition.replace("Proteine", null, "");
            }
            if (nutrition.get("Kohlenhydrate") == null){
                nutrition.replace("Kohlenhydrate", null, "");
            }
            if (nutrition.get("Zucker") == null){
                nutrition.replace("Zucker", null, "");
            }
            if (nutrition.get("Ballaststoffe") == null){
                nutrition.replace("Ballaststoffe", null, "");
            }
            if (nutrition.get("Cholesterin") == null){
                nutrition.replace("Cholesterin", null, "");
            }
            if (nutrition.get("Zucker") == null){
                nutrition.replace("Zucker", null, "");
            }
            if (nutrition.get("GesätigteFettsäuren") == null){
                nutrition.replace("GesätigteFettsäuren", null, "");
            }
            try{
                Statement statement = con.createStatement();
                statement.execute("INSERT INTO food SET name = '" + foodList.get(i).getmName() + "', id = " +
                        foodList.get(i).getmId() +
                        ", food_group = '" + foodList.get(i).getmFoodGroup() +
                        "', CALORIES = '" + nutrition.get("Kalorien") +
                        "', FAT = '" + nutrition.get("Fett") +
                        "', PROTEINS = '" + nutrition.get("Proteine") +
                        "', CARBOHYDRATES = '" + nutrition.get("Kohlenhydrate") +
                        "', SUAGAR = '" + nutrition.get("Zucker") +
                        "', FIBER = '" + nutrition.get("Ballaststoffe") +
                        "', CHOLESTEROL = '" + nutrition.get("Cholesterin") +
                        "', SATURATED_FATS = '" + nutrition.get("GesätigteFettsäuren") + "';");
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
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
