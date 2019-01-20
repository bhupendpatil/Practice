<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String a = request.getParameter("country");
            
            Cookie cookie = new Cookie("country",a);
            
            response.addCookie(cookie);
            
            
            response.sendRedirect("index.jsp");
            
        %>
    </body>
</html>
