import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/Cookie2"})
public class Cookie2 extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try{
            Cookie cooki[] = request.getCookies();
            
            out.println("Value is "+cooki[0].getValue());
        
        }catch(Exception e){}
    }
    
}