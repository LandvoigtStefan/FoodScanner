import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<String> file = null;
    public static List<Food> foodList = null;
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "";

        try{
            Connection con = DriverManager.getConnection(url,user,pass);
            System.out.println("Verbindung geht oida!");
        }catch (Exception e){
            System.out.println("Fuck");
        };
        file = readFromFile();
        splitFile();
    }
    public static List<String> readFromFile(){
        try{
            return Files.readAllLines(Paths.get("data/DatabaseFoodReal.xlsx"));
        }
        catch (Exception e){
            System.out.println("Couldnt read from file!");
        }
        return new LinkedList<>();
    }
    public static void splitFile(){
        for (int i = 1; i < file.size(); i++){
            String[] splitted = file.get(i).split(";");
            foodList.add(new Food(Integer.parseInt(splitted[0]), splitted[1], splitted[2], Integer.valueOf(splitted[3]),
                    Integer.valueOf(splitted[4]), Integer.valueOf(splitted[5]), Integer.valueOf(splitted[6]),
                    Integer.valueOf(splitted[7]), Integer.valueOf(splitted[8]), Integer.valueOf(splitted[9]),
                    Integer.valueOf(10)));
        }
    }
}
