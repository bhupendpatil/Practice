import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/cal"})

public class cal extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int a = Integer.parseInt(request.getParameter("firstNum"));
            int b = Integer.parseInt(request.getParameter("secondNum"));
            String oper = request.getParameter("operation");
            
            int c = 0;
            
            if(oper.equals("+")){
                c = a + b;
            } else if(oper.equals("-")){
                c = a - b;
            } else if(oper.equals("*")){
                c = a * b;
            } else if(oper.equals("/")){
                c = a / b;
            }

            out.println("<h1>Result is: " + c +"</h1>");
            
        }
    }
}
