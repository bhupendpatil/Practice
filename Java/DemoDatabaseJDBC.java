
import java.sql.*;

public class DemoDatabaseJDBC {
    public static void main(String[] args) {
		try {
			//load driver
			Class.forName("oracle.jdbc.OracleDriver"); 

			//make connecion
                        System.out.println("Driver Registered");
			Connection c1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");

			//create statement
                        System.out.println("Driver Loaded");
			Statement st = c1.createStatement();

			//fire query
			st.execute("select * from help");

			System.out.println("Statement Executed");

			//close
			st.close(); //statement closed
			c1.close(); //connection closed

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
