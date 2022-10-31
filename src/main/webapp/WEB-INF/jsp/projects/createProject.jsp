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
        <form action="/projects/createProject" method="post">
            <label for="projectName"> project name: </label><br>
            <input type="text" id="projectName" name="projectName" required><br>
            <label for="projectDescription"> project description: </label><br>
            <input type="text" id="projectDescription" name="projectDescription" required><br>
            <label for="companyId"> company id: </label><br>
            <input type="text" id="companyId" name="companyId" required><br>
            <label for="customerId"> company id: </label><br>
            <input type="text" id="customerId" name="customerId" required><br>

            <button type="submit">Create</button>
        </form>

        <h2>Project add</h2>

    </body>
</html>