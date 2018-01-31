<%-- Current date and time using JSP --%>

<%@page import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Current Date and time:</h3>
        <% 
            java.util.Date d = new java.util.Date();
            out.println(d.toString());
        %>        
    </body>
</html>
