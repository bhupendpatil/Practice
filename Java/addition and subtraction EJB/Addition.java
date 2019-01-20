import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EJB.AdditionLogic;


@WebServlet(urlPatterns = {"/Addition"})
public class Addition extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            AdditionLogic ob = new AdditionLogic();            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Addition</title>");            
            out.println("</head>");
            out.println("<body>");
            int a = Integer.parseInt(request.getParameter("firstNumber"));
            int b = Integer.parseInt(request.getParameter("secondNumber"));
            
            out.println("<h1>Addition is "+ ob.Addition(a, b) +"</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
