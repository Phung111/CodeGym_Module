<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .form{
      border: 1px solid blue;
      width: 300px;
      padding: 10px;
      margin: 10px;
      padding-top: 0px;
      padding-bottom: 15px;
    }
    form input{
      width: 80%;
    }
  </style>
</head>

<body>
<div class="form">
  <h1>Login</h1>
  <form  action="/dangnhap" method="post">
    <input type="text" name="username"> <br><br>
    <input type="password" name="password"><br><br>
    <button>Sign in</button>
  </form>
</div>
</body>

</html>