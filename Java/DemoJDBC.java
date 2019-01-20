
import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) {
		try {
			//load driver
			Class.forName("oracle.jdbc.OracleDriver"); 

			//make connecion
			Connection c1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","password");

			//create statement
			Statement st = c1.createStatement();

			//fire query
			st.execute("select * from help;");

			System.out.println("Query Fired");

			//close
			st.close(); //statement closed
			c1.close(); //connection closed

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
