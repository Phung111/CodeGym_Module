<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form action="/tudien1" method="post">
    <label>Key </label>
    <input type="text" name="keyword">
    <label>Result: ${requestScope.kq}</label>
    <button type="submit"> Translate</button>

    <c:if test="${requestScope.keys != null}">
        <ul>
            <c:forEach items="${requestScope.keys}" var="item">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:if>
</form>

</body>
</html>
