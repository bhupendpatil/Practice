import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/Qualification"})
public class Qualification extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        try{
            String name = request.getParameter("name");
            String qualification = request.getParameter("quali");
            
            if(qualification.toLowerCase().equals("bsc")){
                response.sendRedirect("graduate.html");
            } else if(qualification.toLowerCase().equals("msc")){
                response.sendRedirect("postgraduate.html");
            } else {
                out.println("Invalid Qualification");
            }
            
            
        }catch(Exception e){}
    }
    
}