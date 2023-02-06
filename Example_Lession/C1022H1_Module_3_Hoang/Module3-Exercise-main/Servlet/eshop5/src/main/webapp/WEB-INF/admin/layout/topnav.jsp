<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<div id="header">
    <nav class="container">
        <a href="" id="logo"><img src="https://cdn.codegym.vn/wp-content/uploads/2021/08/CodeGym-Logo.webp"
                                  alt=""></a>
        <ul id="main-menu">
            <li><a href="#">Trang Chủ</a></li>
                        <li><a href="">Quản Lí User</a>
                            <ul class="sub-menu">
                                <li><a href="/user">Danh Sách User</a>
                                </li>
                                <li><a href="/user?action=create">Thêm Mới User</a>
                                </li>
                            </ul>
                        </li>
            <li><a style="cursor: pointer">Quản Lí Khách Hàng</a>
                <ul class="sub-menu">
                    <li><a href="/manager-customer?action=listNewcustomer">Danh Sách Khách Hàng Mới</a>
                    </li>
                    <li><a href="/manager-customer?action=listcustomer">Danh Sách Khách Hàng</a>
                    </li>
                </ul>
            </li>
            <li><a href="">Quản Lí Sản Phẩm</a>
                <ul class="sub-menu">
                    <li><a href="/product">Danh Sách Sản Phẩm</a>
                    </li>
                    <li><a href="/product?action=create">Thêm Mới Sản Phẩm</a>
                    </li>
                </ul>
            </li>
            <li><a href="">Quản Lí Đơn Hàng</a>
                <ul class="sub-menu">
                    <li><a href="/manager-oder">Danh Sách Đơn Hàng</a>
                    </li>
                    <li><a href="">Duyệt Đơn Hàng</a>
                        <ul class="sub-menu">
                            <li><a href="/manager-oder?action=listorderTransport">Đang Vận Chuyển</a>
                            </li>
                            <li><a href="/manager-oder?action=listorderDone">Hoàn Thành</a></li>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
                <c:choose>
                <c:when test="${sessionScope.user!=null}">
                    <li>
                        <a style="color: black">${sessionScope.user.getFullName()}
                            <img src="${sessionScope.user.getImage()}"
                                 alt="" style="width: 30px;height: 30px; border-radius: 20px; margin: -5px 5px 0px 5px;">
                        </a>
                        <ul class="sub-menu" style="margin-top: -5px;">
                            <li><a href="/user?action=view">Thông Tin Tài Khoản</a>
                            </li>
                            <li><a href="/user?action=editInfo">Thay Đổi Thông Tin</a>
                            </li>
                            <li><a href="">Đổi Mật Khẩu</a>
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