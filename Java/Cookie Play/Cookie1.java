import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns ={"/Cookie1"})
public class Cookie1 extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try{
            String uName = request.getParameter("uName");
            out.println("Hey hi there, "+uName);
            
            Cookie cook = new Cookie("username",uName);
            response.addCookie(cook);
            
            out.print("<form action='Cookie2' method='post'>");
            out.print("<input type='submit' value='go' />");
            out.print("</form>");
            
            
        } catch(Exception e){}
    }
    
}