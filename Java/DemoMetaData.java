import java.sql.*;

public class DemoMetaData {
    public static void main(String[] args) { 
        try {
            //LoadDriver
            Class.forName("oracle.jdbc.OracleDriver");
            
            //createConnection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","pass");
            
            //DatabaseMetaData
            DatabaseMetaData dmd = conn.getMetaData();
            
            System.out.println("Driver Name: " + dmd.getDriverName());
            System.out.println("User Name: " + dmd.getUserName());
            
            
            //ResultSetMetaData
            PreparedStatement ps = conn.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            System.out.println("Columns: "+rsmd.getColumnCount());
            System.out.println("3rd Column Name: "+rsmd.getColumnName(3));
            
            //close
            conn.close();
		}
		catch (Exception e) {
            System.out.println(e.getMessage());
		}
    }
}
