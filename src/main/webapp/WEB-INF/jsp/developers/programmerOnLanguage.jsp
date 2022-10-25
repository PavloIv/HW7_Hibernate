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
        <form action="/developers/programmerOnLanguage" method="post">
            <label for="language"> developer id: </label><br>
            <input type="text" id="language" name="language"><br>

            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                    <tr>
                        <th > Id:</th>
                        <th > Name:</th>
                        <th > Age:</th>
                        <th > Sex:</th>
                        <th > Salary:</th>
                    </tr>
            <c:forEach var = "developer" items="${developers}">
                    <tr>
                        <td>
                            <c:out value="${developer.id}"/>
                        </td>
                        <td>
                            <c:out value="${developer.name}"/>
                        </td>
                        <td>
                            <c:out value="${developer.age}"/>
                        </td>
                        <td>
                            <c:out value="${developer.sex}"/>
                        </td>
                        <td>
                            <c:out value="${developer.salary}"/>
                        </td>
                    </tr>
            </c:forEach>
        </table>
    </body>
</html>

