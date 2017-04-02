package mco364;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryPoint {
//https://docs.oracle.com/javase/tutorial/jdbc/
    // add gradle dependency
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Successfully Loaded!");
            String driver = "jdbc:sqlserver:";
            String url = "//lcmdb.cbjmpwcdjfmq.us-east-1.rds.amazonaws.com:";
            String port = "1433";
            String username = "DS";
            String password = "";
            String database = "DS";
            String connection = driver + url + port + 
   ";databaseName=" + database +";user=" + username + ";password=" + password + ";";  
            try (Connection connect = DriverManager.getConnection(connection)) {
                System.out.println("Connected to Database!");
                PreparedStatement state = connect.prepareStatement("Select * from mytable");
                System.out.println("Query Executed Successfully!");
                ResultSet rs = state.executeQuery();
while (rs.next()) {
        System.out.println(rs.getString("id"));
        System.out.println(rs.getString("name"));
    }
            }
            System.out.println("Database Closed!");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Error: Driver Class not found.");
            ex.printStackTrace();
        }
        catch(SQLException sqlex){
            System.out.println("Error: SQL Error");
            sqlex.printStackTrace();

        }
    }
}
