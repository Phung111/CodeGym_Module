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
        <div class="col-md-12 col-xs-12 register-blocks">
          <h2>New account : </h2>
          <form  method="post">
            <c:if test="${requestScope.errors!=null}">
              <div class="alert alert-danger" role="alert">
                <ul>
                  <c:forEach items="${requestScope.errors}" var="error">
                    <li>${error}</li>
                  </c:forEach>
                </ul>
              </div>
            </c:if>
            <div class="form-group">
              <label>Fullname</label>
              <input  type="text" name="fullname" placeholder="Fullname" class="form-control" required="">
            </div>
            <div class="form-group">
              <label>Username</label>
              <input  type="text" name="username" placeholder="Username" class="form-control" required="">
            </div>
            <div class="form-group">
              <label>Email</label>
              <input  type="email" name="email" placeholder="Email" class="form-control"  required="">
            </div>
            <div class="form-group">
              <label>Password</label>
              <input  type="password" name="password1" placeholder="Password" class="form-control" required="">
            </div>
            <div class="form-group">
              <label>Confirm Password</label>
              <input type="password" name="password2" placeholder="Confirm Password" class="form-control" required="">
            </div>
            <div class="text-center">
              <button type="submit" class="btn btn-default">Register</button>
            </div>
            <c:if test="${requestScope.message != null}">
              <div class="alert alert-success">
                <h3>${requestScope.message}</h3>
              </div>
            </c:if>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>

</body>
</html>