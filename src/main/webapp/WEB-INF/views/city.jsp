<%-- 
    Document   : city
    Created on : 19-Sep-2022, 8:52:03 PM
    Author     : amith
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New City page</title>
    </head>
    <body>
        <h1>Create a new city</h1>
        <c:if test="${not empty requestScope.errors}">
            <p> Please fix these errors before proceeding</p>
            <ol>
                <c:forEach items="${requestScope.errors}" var="error">
                    <li>${error.propertyPath} has an issue. Please fix: ${error.message} </li>
                </c:forEach>
            </ol>
        </c:if>
            
        <form method="post" action="/asatyanarayan1-fp/city">
            <div>
                <label> City ID</label>
                <input type="text" id="cityId" name="cityId" value="${requestScope.city.cityId}"/>
            </div>
            <div>
                <label> City</label>
                <input type="text" id="city" name="city" value="${requestScope.city.city}"/>
            </div>
            <div>
                <label> Country ID</label>
                <input type="text" id="countryId" name="countryId" value="${requestScope.city.countryId}"/>
            </div>
            
            <button type="submit">Create</button>
            
        </form>
    </body>
</html>
