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
        <form action="/developers/updateDevelopers" method="post">
            <label for="developerId"> developer id: </label><br>
            <input type="text" id="developerId" name="developerId"><br>
            <label for="developerName"> developer name: </label><br>
            <input type="text" id="developerName" name="developerName"><br>
            <label for="developerAge"> developer age: </label><br>
            <input type="text" id="developerAge" name="developerAge"><br>
            <label for="developerSex"> developer sex: </label><br>
            <input type="text" id="developerSex" name="developerSex"><br>
            <label for="developerSalary"> developer salary: </label><br>
            <input type="text" id="developerSalary" name="developerSalary"><br>

            <button type="submit">Update</button>
        </form>
    </body>
</html>