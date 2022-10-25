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
        <form action="/project/updateProject" method="post">
            <label for="projectId"> project id: </label><br>
            <input type="text" id="projectId" name="projectId"><br>
            <label for="projectName"> project name: </label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <label for="projectDescription"> project description: </label><br>
            <input type="text" id="projectDescription" name="projectDescription"><br>
            <label for="companyId"> company id: </label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="customerId"> company id: </label><br>
            <input type="text" id="customerId" name="customerId"><br>

            <button type="submit">Update</button>
        </form>

        <h2>Project update</h2>

    </body>
</html>