<%@page import="java.sql.*,java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Process</title>
    </head>
    <body>
        <%
            String name = request.getParameter("uName");
            String email = request.getParameter("uEmail");
            
            try{
                //load driver
                Class.forName("oracle.jdbc.OracleDriver");
                
                //make connection
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
                
                //create statement
                Statement st = conn.createStatement();
                
                //firequery
                st.execute("insert into student(name,email) values('"+name+"','"+email+"')");
                
                //close
                st.close();
                conn.close();
                
            } catch(Exception e){}
        %>
    </body>
</html>
