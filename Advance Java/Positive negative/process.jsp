<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>done</title>
    </head>
    <body>
        <% 
            String nummm = request.getParameter("numm"); 
            int num = Integer.parseInt(nummm);
            
            
            if(num<=0){
                out.println("<h1>It is negative number</h1>");
            } else {
                out.println("<h1>It is positive number</h1> ");
            }
        %>
    </body>
</html>
