
import java.sql.*;

public class DatabaseTableOutput {
    public static void main(String[] args) {
		
        Connection conn;
        Statement smnt;
        ResultSet rs;
        
        try {
            //LoadDriver
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver Loaded");
            
            //createConnection
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
            System.out.println("Connection created");
            
            //createStatement
            smnt = conn.createStatement();
            System.out.println("Statement created");
            
            //executeSQLStatement
            rs = smnt.executeQuery("select * from employee");
            System.out.println("Employee Chart: ");
            while(rs.next()){
                System.out.println(" | "+rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | ");
            }
            System.out.println("Done");
	}
	catch (Exception e) {
            System.out.println(e.getMessage());
	}
    }
}
