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
        <form action="/companies/findCompany">
            <label for="companyId"> company id: </label><br>
            <input type="text" id="companyId" name="companyId"><br>

            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                    <tr>
                        <th >id:</th>
                        <th >name:</th>
                        <th >Year of foundation:</th>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${company.id}"/>
                        </td>
                        <td>
                            <c:out value="${company.name}"/>
                        </td>
                        <td>
                            <c:out value="${company.year_of_foundation}"/>
                        </td>
                    </tr>
        </table>
    </body>
</html>