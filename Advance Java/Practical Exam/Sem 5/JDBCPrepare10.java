/*
A JDBC program using prepared Statement
 */

import java.sql.*;

public class JDBCPrepare10 {
    public static void main(String[] args){
        try{
            //Load Driver
            Class.forName("oracle.jdbc.OracleDriver");
            
            //Make Connection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
            
            //query
            String query = "insert into author values(?,?,?)";
            
            // Prepared Statement
            PreparedStatement pst = conn.prepareStatement(query);
            
            //Fire Query
            pst.setInt(1,5);
            pst.setString(2, "MNO");
            pst.setInt(3,933847628);
            pst.execute();
            //pst.execute("update author set Phone = 9382736453 where id=5");
            
            //Close
            pst.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
