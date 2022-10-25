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
        <form action="/developers/findDevelopers">
            <label for="developerId"> developer id: </label><br>
            <input type="text" id="developerId" name="developerId"><br>

            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                    <tr>
                        <th > Developer id:</th>
                        <th > Developer name:</th>
                        <th >Developer age:</th>
                        <th >Developer sex:</th>
                        <th >Developer salary:</th>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${developers.id}"/>
                        </td>
                        <td>
                            <c:out value="${developers.name}"/>
                        </td>
                        <td>
                            <c:out value="${developers.age}"/>
                        </td>
                        <td>
                            <c:out value="${developers.sex}"/>
                        </td>
                        <td>
                            <c:out value="${developers.salary}"/>
                        </td>
                    </tr>
        </table>
    </body>
</html>