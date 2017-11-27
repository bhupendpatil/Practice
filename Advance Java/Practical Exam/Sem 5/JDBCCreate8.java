/*
A Write a JDBC program that will create a Author Table
 */

import java.sql.*;

public class JDBCCreate8 {
    public static void main(String[] args) {
        try{
           //Load Driver
           Class.forName("oracle.jdbc.OracleDriver");
           
           //Make Connection
           Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
           System.out.println("Connected successfully");
           
           //Create Statement
           Statement st = conn.createStatement();
           
           //Fire Query
           st.execute("create table author(id int,name varchar2(10),phone number(10))");
           System.out.println("Table named Author created");
           
           //Close
           st.close();
           conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
