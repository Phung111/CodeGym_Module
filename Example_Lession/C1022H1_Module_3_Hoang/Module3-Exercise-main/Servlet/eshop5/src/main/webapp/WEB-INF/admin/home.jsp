<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Case Study - Quản Lí Sản Phẩm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css  ">
    <link rel="stylesheet" href="/admin1/css/menu.css">
    <style>
        img {
            width: 50px;
            height: 50px;
        }
    </style>
</head>

<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
    <div id="content">
        <div id="main">
            <div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/admin/layout/rightbar.jsp">
            <jsp:param name="totalUser" value="${applicationScope.listUser.size()}"/>
            <jsp:param name="totalCustomer" value="${applicationScope.listCustomer.size()}"/>
            <jsp:param name="totalProduct" value="${applicationScope.listProduct.size()}"/>
            <jsp:param name="totalOrder" value="${applicationScope.listOrder.size()}"/>
        </jsp:include>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $(document).ready(function () {
        $('.sub-menu').parent('li').addClass('has-child');
    })
</script>
</body>


</html>