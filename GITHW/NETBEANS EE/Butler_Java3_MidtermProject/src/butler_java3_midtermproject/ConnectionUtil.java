
package butler_java3_midtermproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tfran
 */
public class ConnectionUtil {
    
    //Fields Set with JDBC Connection requirements
    private static String url = "jdbc:ucanaccess://C:/Data/Northwind.mdb";
    private static String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static Connection con;
    
    
    public static Connection getConnection(){
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                // log an exception
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception
            System.out.println("Driver not found."); 
        }
        
        return con;
    };
}

