package dbconnector;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String URL    = "jdbc:mysql://138.68.64.38:3306/db_cupcakes";
    private static String DATABASE = "db_cupcakes";
    private static String ID = "testuser"; 
    private static String PW = "password123";
     public static Connection getCon()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, ID, PW);
        }
        catch (SQLException ex)  
        {
            System.out.println(ex+" :Error; SQLException kun ikke for getConnection i DBC getCon");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println(ex + " :Error: ClassNotFoundExection i DBC getCon");
        }
        return con;
    }
    private static Connection con;
  
}
