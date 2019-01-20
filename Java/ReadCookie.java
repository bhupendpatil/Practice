import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

class ReadCookie extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = "COokie Reading";

		if(cookies != null){
			out.println("Cookies Found");
			for(int i=0; i<cookies.length();i++){
				cookie = cookies[i];
				out.println("Name : " +cookie.getName()+" ,");
				out.println("Value : " +cookie.getValue()+ "</br>" );
			}
		}
		else {
			out.println("Cookies not found");
		}
	}
}