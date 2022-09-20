<%-- 
    Document   : city
    Created on : 19-Sep-2022, 8:52:03 PM
    Author     : amith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New City page</title>
    </head>
    <body>
        <h1>Create a new city</h1>
        
        <form method="post" action="/asatyanarayan1-fp/city">
            <div>
                <label> City ID</label>
                <input type="text" id="cityId" name="cityId"/>
            </div>
            <div>
                <label> City</label>
                <input type="text" id="city" name="city"/>
            </div>
            <div>
                <label> Country ID</label>
                <input type="text" id="countryId" name="countryId"/>
            </div>
            
            <button type="submit">Create</button>
            
        </form>
    </body>
</html>
