<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nummmm = request.getParameter("numm");
            
            int num = Integer.parseInt(nummmm);
            
            int i,f=1;
            
            for(i=1;i<=num;i++){
                f = f*i;
            }
            out.println("<h1>Factorial is of "+nummmm+" is "+f+"</h1>");
        %>
    </body>
</html>
