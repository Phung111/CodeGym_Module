<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>

<!DOCTYPE html>
<html>

<head>
    <title>Case Study - Quản Lí Sản Phẩm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css  ">
    <link rel="stylesheet" href="/admin1/css/menu.css">
</head>
<style>
    #main {
        width: 100%;
    }
</style>

<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/customer/topnav.jsp"></jsp:include>
    <div id="content">
        <div id="main">
            <div>
                <div>
                    <div id="background">
                        <div id="background-top">
                            <img src="https://dulichvietnam.com.vn/kinh-nghiem/wp-content/uploads/2018/07/du-lich-canada-mua-he.jpeg"
                                 alt="picture" style="width: 100%; height: 175px;">
                        </div>
                        <div id="background-bottom" style="position: relative;">
                            <div id="background-bottom-avatar"><img src="${sessionScope.user.getImage()}" alt="avatar"
                                                                    style="margin-top: -48px; height: 100px; width: 100px; border-radius: 79px; border: 3px solid #fff;     position: absolute;">
                            </div>
                            <div id="background-bottom-info"
                                 style="padding: 10px 0px 0px 114px;font-size: 30px;">${sessionScope.user.getFullName()}</div>
                        </div>
                    </div>
                    <h1 style="text-align: center;">Chi Tiết Đơn Hàng</h1>
                    <div id="user-info-list">
                        <table border="1" class="table"
                               style="margin: 30px;text-align: center;border-collapse: collapse;margin-left: 35%;">
                            <thead>
                            <tr>
                                <th class="text-center" style="padding: 10px;">Sản phẩm</th>
                                <th class="text-center">Giá (VNĐ)</th>
                                <th class="text-center">Số lượng</th>
                                <th class="text-center">Thành tiền (VNĐ)</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.orderItems}" var="orderItem">
                                <tr class="odd gradeX">
                                    <td style="padding: 10px;">
                                        <c:forEach items="${requestScope.products}" var="product">
                                            <c:if test="${orderItem.getProductId() == product.getId()}">
                                                ${product.getName()}
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td class="text-center">${orderItem.getPrice()}</td>
                                    <td class="text-center">
                                            ${orderItem.getQuantity()}
                                    </td>
                                    <td class="text-center">
                                            ${orderItem.getQuantity()*orderItem.getPrice()}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tr>
                                <td colspan="4">
                                    <a href="/user?action=viewHistoryOrder"><button  style="margin-top: 0px;">Quay Lại</button></a>
                                </td>
                            </tr>
                        </table>

                    </div>

                </div>
            </div>
        </div>
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