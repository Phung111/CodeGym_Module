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
                    <h1 style="text-align: center;">Lịch Sử Đơn Hàng</h1>
                    <div id="user-info-list">
                        <table class="table" style="margin: 20px;text-align: center;margin-left: 20%;">
                            <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Ngày Tạo</th>
                                <th scope="col">Tổng Tiền</th>
                                <th scope="col">Tình Trạng</th>
                                <th scope="col">Khách Hàng</th>
                                <th scope="col">Chi Tiết</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.orders}" var="order">
                                <tr class="odd gradeX">
                                    <td class="text-center" style="padding: 20px;">${order.getId()}</td>
                                    <td class="text-center">
                                            ${order.getCreatedTime()}
                                    </td>
                                    <td class="text-start">${order.getGrandTotal()}</td>

                                    <td><c:forEach items="${requestScope.statuss}" var="status">
                                        <c:if test="${status.getId() == order.getStatusId()}">
                                            ${status.getType()}
                                        </c:if>
                                    </c:forEach>
                                    </td>

                                    <td><c:forEach items="${requestScope.customers}" var="customer">
                                        <c:if test="${order.getCustomerId() == customer.getId()}">
                                            ${customer.getFullName()}
                                        </c:if>
                                    </c:forEach>
                                    </td>
                                    <td>
                                        <a href="/manager-oder?action=vieworderItemFromUser&id=${order.getId()}">Xem</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
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