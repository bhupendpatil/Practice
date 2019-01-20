import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/EvenNumber"})
public class EvenNumber extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        try{
            String number = request.getParameter("aNumber");
            
            int num = Integer.parseInt(number);
            
            if(num%2==0){
                out.println("<h1>Even</h1>");
            }
            else{
                out.println("<h1>Odd</h1>");
            }
        }
        catch(Exception e){}
    }
  
}