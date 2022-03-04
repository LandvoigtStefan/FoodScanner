import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
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
    }
}
