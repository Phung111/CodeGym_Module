<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<div id="header">
    <nav class="container">
        <a href="" id="logo"><img src="https://cdn.codegym.vn/wp-content/uploads/2021/08/CodeGym-Logo.webp"
                                  alt=""></a>
        <ul id="main-menu">
            <li><a href="">Trang Chủ</a></li>
            <%--            <li><a href="">Quản Lí Nhân Viên</a>--%>
            <%--                <ul class="sub-menu">--%>
            <%--                    <li><a href="">Danh Sách Nhân Viên</a>--%>
            <%--                    </li>--%>
            <%--                    <li><a href="">Thêm Mới Nhân Viên</a>--%>
            <%--                    </li>--%>
            <%--                </ul>--%>
            <%--            </li>--%>
            <li><a href="">Quản Lí Khách Hàng</a>
                <ul class="sub-menu">
                    <li><a href="">Danh Sách Khách Hàng Mới</a>
                    </li>
                    <li><a href="">Danh Sách Khách Hàng</a>
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
                    <li><a href="">Danh Sách Đơn Hàng</a>
                    </li>
                    <li><a href="">Duyệt Đơn Hàng</a>
                        <ul class="sub-menu">
                            <li><a href="">Đang Vận Chuyển</a>
                            </li>
                            <li><a href="">Hoàn Thành</a></li>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="">Tài Khoản
                <img src="https://we25.vn/media2018/Img_News/2020/08/17/ca4oq9vsccmxppyhz4jliqjp5nmutucq6iy29bzd_20200817092203.jpeg" alt="" style="width: 30px;height: 30px; border-radius: 20px; margin: -5px 5px 0px 5px;">
            </a>
                <ul class="sub-menu">
                    <li><a href="">Thông Tin Tài Khoản</a>
                    </li>
                    <li><a href="">Thay Đổi Thông Tin</a>
                    </li>
                    <li><a href="">Đổi Mật Khẩu</a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="btn">
            <button>Đăng Nhập</button>
            <button>Đăng Ký</button>
        </div>
    </nav>
</div>

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $(document).ready(function () {
        $('.sub-menu').parent('li').addClass('has-child');
    })
</script>