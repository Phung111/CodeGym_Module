<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<style>
    #main-menu>li.has-child>a::after {
        font-family: "Font Awesome 5 Free";
        font-weight: 900;
        content: "";
        position: absolute;
        top: 0;
        right: 0;
        margin-top: 16px;
        color: #898282;
    }

</style>
<div id="header">
    <nav class="container">
        <a href="" id="logo"><img src="https://cdn.codegym.vn/wp-content/uploads/2021/08/CodeGym-Logo.webp"
                                  alt=""></a>
        <ul id="main-menu">
            <li><a href="/trangchu">Trang Chủ</a></li>
            <li><a href="">Sản Phẩm</a>
                <ul class="sub-menu">
                    <li><a href="">Sản Phẩm Mới</a>
                    </li>
                    <li><a href="">Sản Phẩm Cũ</a>
                    </li>
                </ul>
            </li>
            <li><a href="">Liên Hệ</a>
            </li>
            <li><a href="">Giới Thiệu</a>
            </li>
            <li>
                <div class="search">
                    <form action="/trangchu?action=search" style="padding-top: 5px;" method="post">
                        <div>
                            <input name="inputSearch" value="${requestScope.searchStr}" type="search" style="padding: 10px;" placeholder="Search...">
                            <button type="submit" style=""><i
                                    class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                    </form>
                </div>
            </li>
            <li>
                <div class="cart">
                    <a href="/cart"><i class="fa-solid fa-cart-shopping" style="    color: red;
                            font-size: 30px;
                            margin-top: -5px;"></i></a>
                </div>
            </li>
            <c:choose>
                <c:when test="${sessionScope.user!=null}">
                    <li>
                            <a style="color: black">
                            </a>${sessionScope.user.getFullName()}
                        <img src="${sessionScope.user.getImage()}"
                             alt=""
                             style="width: 30px;height: 30px; border-radius: 20px; margin: -5px 5px 0px 5px;">
                        <ul class="sub-menu" style="margin-top: -5px;">
                            <li><a href="/user?action=view">Thông Tin Tài Khoản</a>
                            </li>
                            <li><a href="/user?action=editInfo">Thay Đổi Thông Tin</a>
                            </li>
                            <li><a href="/user?action=viewHistoryOrder">Lịch Sử Đơn Hàng</a>
                            </li>
                            <li><a href="/logout">log out
                            </a>
                            </li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <div class="btn">
                        <button><a href="/login" style="text-decoration: none;color: black;">Đăng Nhập</a></button>
                        <button><a href="/signup" style="text-decoration: none;color: black;">Đăng Ký</a></button>
                    </div>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</div>

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $(document).ready(function () {
        $('.sub-menu').parent('li').addClass('has-child');
    })
</script>