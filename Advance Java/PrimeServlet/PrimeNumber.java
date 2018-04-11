import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/PrimeNumber"})
public class PrimeNumber extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        try{
            String number = request.getParameter("aNumber");
            
            int num = Integer.parseInt(number);
            
            if(num==0 || num==1){
                out.println("<h1>"+num+" is Not Prime</h1>");
            }            
            else if(num==2){
                out.println("<h1>"+num+" is Prime</h1>");
            }
            else if(num%2==0){
                out.println("<h1>"+num+" is Not Prime</h1>");
            }
            else{
                out.println("<h1>"+num+" is Prime</h1>");
            }
        }
        catch(Exception e){}
    }
  
}