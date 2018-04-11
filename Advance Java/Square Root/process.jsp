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
            
            double d = Math.sqrt(num);
            
            if(num<=0){
                out.println("<h1>It is negative number</h1>");
            } else {
                out.println("Square root of "+nummm+" is "+d);
            }
        %>
    </body>
</html>
