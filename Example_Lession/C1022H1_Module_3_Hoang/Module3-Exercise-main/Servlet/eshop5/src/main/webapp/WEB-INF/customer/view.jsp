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
    #main{
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
                            <img src="https://dulichvietnam.com.vn/kinh-nghiem/wp-content/uploads/2018/07/du-lich-canada-mua-he.jpeg" alt="picture" style="width: 100%; height: 175px;">
                        </div>
                        <div id="background-bottom" style="position: relative;">
                            <div id="background-bottom-avatar"><img src="${sessionScope.user.getImage()}" alt="avatar" style="margin-top: -48px; height: 100px; width: 100px; border-radius: 79px; border: 3px solid #fff;     position: absolute;"></div>
                            <div id="background-bottom-info" style="padding: 10px 0px 0px 114px;font-size: 30px;">${sessionScope.user.getFullName()}</div>
                        </div>
                    </div>
                    <div id="user-info-list">
                        <table style="padding: 30px 0px 0px 300px;">
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Họ Và Tên: </td>
                                <td>${sessionScope.user.getFullName()}</td>
                            </tr>
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Ngày Sinh: </td>
                                <td>${sessionScope.user.getBirthDay()}</td>
                            </tr>
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Số Điện Thoại: </td>
                                <td>${sessionScope.user.getPhoneNumber()}</td>
                            </tr>
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Email: </td>
                                <td>${sessionScope.user.getEmail()}</td>
                            </tr>
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Địa Chỉ: </td>
                                <td>${sessionScope.user.getAddress()}</td>
                            </tr>
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Quyền Hạn: </td>
                                <td><c:forEach items="${requestScope.listRole}" var="role">
                                    <c:if test="${sessionScope.user.getRole() == role.getId()}">
                                        ${role.getType()}
                                    </c:if>
                                </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding-right: 60px; padding-bottom: 10px;">Ngày Tạo: </td>
                                <td>${sessionScope.user.getCreatedTime()}</td>
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