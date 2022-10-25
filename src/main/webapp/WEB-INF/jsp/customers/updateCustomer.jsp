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
        <form action="/customers/updateCustomer" method="post">
            <label for="customerId"> customer id: </label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <label for="customerName"> customer name: </label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="customerWebsite"> customer website: </label><br>
            <input type="text" id="customerWebsite" name="customerWebsite"><br>

            <button type="submit">Update</button>
        </form>
        <h2>Customer update</h2>
    </body>
</html>