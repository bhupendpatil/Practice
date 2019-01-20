import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.*;


@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("userpass");
            
            if(validate(username,password)){
                RequestDispatcher rd = request.getRequestDispatcher("welcomePage");
                rd.forward(request,response);
            }
            else{
                out.print("Sorry username or password error");  
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request,response);
            }
        }
    }
    
    public boolean validate(String user,String pass){
        boolean status = false;
        
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
            
            PreparedStatement ps = conn.prepareStatement("select * from useridpass where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
            status = rs.next();
        }
        catch(Exception e){}
        
        return status;
    }


}
