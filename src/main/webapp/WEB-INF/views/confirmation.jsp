<%-- 
    Document   : confirmation
    Created on : 19-Sep-2022, 10:54:04 PM
    Author     : amith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>City was Created</title>
    </head>
    <body>
        <h1>City ${requestScope.city.city} was Created</h1>
        
        <ul>
            <li> City id ${requestScope.city.cityId}</li>
            <li> Country Id ${requestScope.city.countryId}</li>
    </body>
</html>
