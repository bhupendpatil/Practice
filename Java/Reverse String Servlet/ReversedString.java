import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ReversedString"})
public class ReversedString extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()){
            String saral = request.getParameter("aString");
            
            //this is logic
            String ulta = new StringBuffer(saral).reverse().toString();
            
            out.println("<h1>Reverse of '"+ saral +"' is '"+ ulta +"'</h1>");
        }
    }
}


//if INPUT is efsef fs fsef
//OUTPUT
//Reverse of 'efsef fs fsef' is 'fesf sf fesfe'