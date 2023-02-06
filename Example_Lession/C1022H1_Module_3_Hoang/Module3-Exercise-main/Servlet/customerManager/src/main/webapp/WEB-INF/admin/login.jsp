<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>GARO ESTATE | Home page</title>
  <jsp:include page="/WEB-INF/admin/layout/headcss.jsp"></jsp:include>
  <style>
    .chinhsuathem {
      margin-left: 25%;
    }
  </style>
</head>
<body>
<!-- Body content -->
<jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
<!-- End of nav bar -->
<div class="register-area" style="background-color: rgb(249, 249, 249);">
  <div class="container">
    <div class="col-md-6 chinhsuathem">
      <div class="box-for overflow">
        <div class="col-md-12 col-xs-12 login-blocks">
          <h2>Login : </h2>
          <form action="" method="post">
            <c:if test="${requestScope.message != null}">
              <div class="alert alert-danger" role="alert">
                <h3>${requestScope.message}</h3>
              </div>
            </c:if>
            <div class="form-group">
              <label for="username">username</label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Username">
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="text-center">
              <button type="submit" class="btn btn-default"> Log in</button>
            </div>
          </form>
          <br>
          <h2>Social login :  </h2>
          <p>
            <a class="login-social" href="#"><i class="fa fa-facebook"></i>&nbsp;Facebook</a>
            <a class="login-social" href="#"><i class="fa fa-google-plus"></i>&nbsp;Gmail</a>
            <a class="login-social" href="#"><i class="fa fa-twitter"></i>&nbsp;Twitter</a>
          </p>
        </div>

      </div>
    </div>

  </div>
</div>

<jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>

</body>
</html>