<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <c:import url="${contextPath}/WEB-INF/jsp/tableStyle.jsp"/>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/jsp/navigation.jsp"/>
        <form action="/developers/salaryOnProject">
            <label for="projectId"> project id: </label><br>
            <select input class="form-select" id="projectId" name="projectId" required aria-label="select example">
            <option value="">Id</option>
            <c:forEach var = "projectId" items="${projectIds}">
                    <option value="${projectId}">${projectId}</option>
            </c:forEach><br>
            </select><br>
            <button type="submit">Find</button>
        </form>
    </body>
</html>