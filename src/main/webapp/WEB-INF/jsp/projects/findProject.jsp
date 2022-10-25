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
        <form action="/projects/findProject">
            <label for="projectId"> project id: </label><br>
            <input type="text" id="projectId" name="projectId"><br>

            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                    <tr>
                        <th >id:</th>
                        <th >name:</th>
                        <th >description:</th>
                        <th >cost:</th>
                        <th >company_id:</th>
                        <th >customer_id:</th>
                    </tr>
                    <tr>
                        <td >
                            <c:out value="${project.id}"/>
                        </td>
                        <td >
                            <c:out value="${project.name}"/>
                        </td>
                        <td >
                            <c:out value="${project.description}"/>
                        </td>
                        <td >
                            <c:out value="${project.cost}"/>
                        </td>
                        <td >
                            <c:out value="${project.company_id}"/>
                        </td>
                        <td >
                            <c:out value="${project.customer_id}"/>
                        </td>

                    </tr>
        </table>
    </body>
</html>