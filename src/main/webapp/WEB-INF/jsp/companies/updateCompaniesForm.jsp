<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/jsp/navigation.jsp"/>
        <form action="/companies/updateCompany" method="post">
            <label for="companyId"> company id: </label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="companyName"> company name: </label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="companyYearFoundation"> company year of foundation: </label><br>
            <input type="text" id="companyYearFoundation" name="companyYearFoundation"><br>

            <button type="submit">Update</button>
        </form>
    </body>
</html>