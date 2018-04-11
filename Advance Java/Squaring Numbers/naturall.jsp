<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String numm = request.getParameter("numm");
            
            int num = Integer.parseInt(numm);
            
            for(int i=1;i<=num;i++){
                out.println(i*i);
                out.println("<br/>");
            }
        %>
    </body>
</html>
