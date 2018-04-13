/*
Write a JDBC program for insertion and display of records
 */

import java.sql.*;

public class JDBCIncDis9 {
    public static void main(String[] args){
        try {
            
            //Load Driver
            Class.forName("oracle.jdbc.OracleDriver");
            
            //Make Connection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
            
            //Create Statement
            Statement st = conn.createStatement();
            
            //Fire Query
            //st.execute("create table author(id int,name varchar2(10),phone int(10))");
            //st.execute("insert into author values(1, 'ABC',9382736253)");
            //st.execute("insert into author values(2, 'DEF',3298309100)");
            //st.execute("insert into author values(3, 'GHI',7362823922)");
            //st.execute("insert into author values(4, 'JKL',8236456354)");
            
            //Result
            ResultSet result = st.executeQuery("select * from author");
            
            System.out.println("| ID  |  Name   |  Phone No  |");
            System.out.println("------------------------------");
            while(result.next())
                System.out.println("|  "+result.getString(1) + "  |   " + result.getString(2) + "   | " + result.getString(3)+" |");
            
            
            
            //Close
            st.close();
            conn.close();
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
