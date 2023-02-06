<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 12/12/2022--%>
<%--  Time: 8:36 AM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%--<html>--%>
<%--<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->--%>
<%--<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->--%>
<%--<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->--%>
<%--<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->--%>
<%--<head>--%>
<%--  <meta charset="utf-8">--%>
<%--  <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--  <title>Title</title>--%>
<%--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">--%>
<%--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />--%>
<%--  <jsp:include page="/WEB-INF/admin/layout/headcss.jsp"></jsp:include>--%>

<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>--%>
<%--<div class="container">--%>
<%--  <h1>Create customer</h1>--%>
<%--  <form method="post">--%>
<%--    <c:if test="${requestScope.message != null}">--%>
<%--      <div class="alert alert-success">--%>
<%--        <h3>${requestScope.message}</h3>--%>
<%--      </div>--%>
<%--    </c:if>--%>

<%--    <label for="idName">Name: </label>--%>
<%--    <input type="text" id="idName" name="name" class="form-control">--%>

<%--    <label for="idAdress">Address: </label>--%>
<%--    <input type="text" id="idAdress" name="address" class="form-control">--%>

<%--    <label for="idCountry">Country: </label>--%>
<%--    <select id="idCountry" name="idCountry">--%>
<%--      <c:forEach items="${applicationScope.countries}" var="country">--%>
<%--        <option value="${country.getId()}"--%>
<%--                <c:if test="${country.getId() == customer.getIdCountry() }"> selected</c:if>--%>
<%--        >${country.getName()}</option>--%>
<%--      </c:forEach>--%>
<%--    </select> <br>--%>
<%--    <label for="idPicture">Picture: </label>--%>
<%--    <input type="text" id="idPicture" name="picture" class="form-control">--%>

<%--    <button >Create</button>--%>
<%--    <button><a href="/customers">back</a></button>--%>
<%--  </form>--%>

<%--</div>--%>
<%--<jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>--%>
<%--</body>--%>
<%--</html>--%>


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
        button {
            background: red;
            color: white;
            border: 2px solid black;
            margin: 10px 0px;
        }
    </style>
</head>
<body>
<!-- Body content -->
<jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
<!-- End of nav bar -->
<div class="container">
    <h1>Create customer</h1>
    <form method="post">
        <c:if test="${requestScope.message != null}">
            <div class="alert alert-success">
                <h3>${requestScope.message}</h3>
            </div>
        </c:if>

        <label for="idName">Name: </label>
        <input type="text" id="idName" name="name" readonly class="form-control" value="${requestScope.customer.getName()}">

        <label for="idAdress">Address: </label>
        <input type="text" id="idAdress" name="address" readonly class="form-control" value="${requestScope.customer.getAddress()}">

        <label for="idCountry">Country: </label>
        <select name="idCountry" id="idCountry" class="form-control" disabled>
            <c:forEach items="${applicationScope.countries}" var="country">
                <option value="${country.getId()}"
                        <c:if test="${customer.getId().equals(country.getId())}">selected</c:if>
                >${country.getName()}</option>
            </c:forEach>
        </select>
        <label for="idPicture">Picture: </label>
        <input type="text" id="idPicture" readonly name="picture" class="form-control" value="${requestScope.customer.getPicture()}">

        <button >Confirm Delete</button>
    </form>

</div>

<jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>


</body>

</html>