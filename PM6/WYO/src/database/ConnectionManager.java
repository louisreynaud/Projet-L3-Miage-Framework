package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public static Connection DbConnector()
    {
   
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:cisdatabase.sqlite");
            return conn;
            
            }catch(Exception e){
                System.out.println(e);
              return null;
                } 
        
    }
   
}
