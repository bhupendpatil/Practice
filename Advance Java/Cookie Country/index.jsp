<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie cookies[] = request.getCookies();
            
            if(cookies != null){
                String a = cookies[1].getValue();
                if (a.equals("India")) {
                    response.sendRedirect("india.jsp");
                }
                else if(a.equals("USA")) {
                    response.sendRedirect("usa.jsp");
                }
            }
            else {
                %>
                <form action="cookie23.jsp" method="POST">
                    username<input type="text" name="name" value="" /> <br/>
                    country <input type="text" name="country" value="" /> <br/>
                    <input type="submit" value="OK" />
                </form>
                <%
            }
            
        %>
    </body>
</html>
