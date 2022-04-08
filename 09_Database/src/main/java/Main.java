import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
            Statement statement = con.createStatement();
            statement.execute("INSERT INTO food SET name = '" + foodList.get(i).getmName() + "', id = '" +
                    foodList.get(i).getmId() + "', food_group = '" +
                    foodList.get(i).getmFoodGroup() + "';");
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
