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

    form {
        display: flex;
        justify-content: center;
        padding-top: 10px;
    }
    #imageProduct{
        width: 400px;
        height: 400px;
    }

    .left-table{
        padding-right: 50px;
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
                            <div id="background-bottom-avatar"><img
                                    src="${sessionScope.user.getImage()}"
                                    alt="avatar"
                                    style="margin-top: -48px; height: 100px; width: 100px; border-radius: 79px; border: 3px solid #fff;     position: absolute;">
                            </div>
                            <div id="background-bottom-info"
                                 style="padding: 10px 0px 0px 114px;font-size: 30px;">${sessionScope.user.getFullName()}</div>
                        </div>
                    </div>
                    <div id="user-info-list">
                        <div>
                            <h1 style="text-align: center;">Edit User</h1>
                        </div>
                        <form method="post">
                            <div class="left-table">
                                <table>
                                    <td><input type="hidden" name="id" value="${sessionScope.user.getId()}"></td>
                                    <tr>
                                        <td>Họ Tên:</td>
                                        <td><input value="${sessionScope.user.getFullName()}" type="text"
                                                   name="fullName" placeholder="Nhập Họ Tên"></td>
                                    </tr>
                                    <tr>
                                        <td>Ngày Sinh:</td>
                                        <td><input value="${sessionScope.user.getBirthDay()}" type="date"
                                                   name="birthDay"></td>
                                    </tr>
                                    <tr>
                                        <td>Số Điện Thoại:</td>
                                        <td><input value="${sessionScope.user.getPhoneNumber()}" type="number"
                                                   name="phoneNumber" placeholder="Nhập Số Điện Thoại"></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><input value="${sessionScope.user.getEmail()}" type="email" name="email"
                                                   value="" placeholder="Nhập Email"></td>
                                    </tr>
                                    <tr>
                                        <td>Địa Chỉ:</td>
                                        <td><input value="${sessionScope.user.getAddress()}" type="text" name="address"
                                                   value="" placeholder="Nhập Địa Chỉ"></input></td>
                                    </tr>
                                    <tr>
                                        <td>Hình Ảnh:</td>
                                        <td><input id="image" onchange="chooseFile()" value="${sessionScope.user.getImage()}" type="text" name="image"
                                                   placeholder="Nhập Link Ảnh"></td>
                                    </tr>
                                    <tr>
                                        <td><input value="${sessionScope.user.getRole()}" type="hidden" name="role"
                                                   placeholder="Nhập Link Ảnh"></td>
                                    </tr>
                                    <tr>
                                        <td>Mật Khẩu:</td>
                                        <td><input value="${sessionScope.user.getPassword()}" type="text"
                                                   name="password" placeholder="Nhập Mật Khẩu"></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td style="padding-top: 10px;">
                                            <button>Lưu</button>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="form-group row">
                                <img id="imageProduct" src="${sessionScope.user.getImage()}" alt="image">
                            </div>
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function chooseFile() {
        let image_src = document.querySelector("#image").value;
        let image = document.querySelector("#imageProduct");
        image.setAttribute("src", image_src);
    }
</script>


<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $(document).ready(function () {
        $('.sub-menu').parent('li').addClass('has-child');
    })
</script>
</body>


</html>