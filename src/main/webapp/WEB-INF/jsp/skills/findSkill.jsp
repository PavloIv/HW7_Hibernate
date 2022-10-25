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
        <form action="/skills/findSkill">
            <label for="skillId"> skill id: </label><br>
            <input type="text" id="skillId" name="skillId"><br>

            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                    <tr>
                        <th > id:</th>
                        <td > language:</th>
                        <th > level:</th>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${skill.id}"/>
                        </td>
                        <td>
                            <c:out value="${skill.language}"/>
                        </td>
                        <td>
                            <c:out value="${skill.level}"/>
                        </td>
                    </tr>
        </table>
    </body>
</html>