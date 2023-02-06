<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/21/2022
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Sign in</title>
    <link rel="stylesheet" href="/admin/assets/css/login.css">

</head>

<body>
<div class="main">
    <p class="sign" align="center">Sign in</p>
    <form class="form1" method="post">
        <c:if test="${requestScope.message != null}">
            <div class="alert alert-danger" role="alert">
                <h3>${requestScope.message}</h3>
            </div>
        </c:if>
        <input class="un " type="text" align="center" name="username" placeholder="Username">
        <input class="pass" type="password" align="center" name="password" placeholder="Password">
        <button class="submit" align="center">Sign up</button>
        <p class="forgot" align="center"><a href="#">Forgot Password?</a></p>
    </form>
</div>

</body>

</html>
