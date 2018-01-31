<%-- Current date and time using JSP --%>

<%@page import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
