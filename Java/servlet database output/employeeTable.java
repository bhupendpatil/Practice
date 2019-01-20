import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class employeeTable extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        try {
            
            Connection conn;
            Statement smnt;
            ResultSet rs;
           
            Class.forName("oracle.jdbc.OracleDriver");
            
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","pasword");
            
            smnt = conn.createStatement();
            
            rs = smnt.executeQuery("select * from employee");
            out.println("<head><style> td { text-align: center; } </style></head>");
            out.println("<h1>Employee Chart: </h1>");
            out.println("<table border='1'>");
            out.println("<tr> <th>ID</th> <th>First</th> <th>Last</th> <th>Salary</th> <th>Department NO</th></>");
            
            while(rs.next()){
                out.println("<tr><td>"+rs.getString(1)+"</td> <td>"+rs.getString(2)+"</td> <td>"+rs.getString(3)+"</td> <td>"+rs.getString(4)+"</td> <td>" +rs.getString(5)+"</td> </tr>");
            }
            out.println("</table>");
        }
        catch (Exception e){}
    }

}
