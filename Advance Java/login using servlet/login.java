import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("uname");
            String userpass = request.getParameter("upass");
            
            if (username.equals("admin") && userpass.equals("admin")){
                out.println("<h1>Success</h1>");
            }
            else {
                out.println("<h1>Error</h1>");            
            }
        }
    }

}
