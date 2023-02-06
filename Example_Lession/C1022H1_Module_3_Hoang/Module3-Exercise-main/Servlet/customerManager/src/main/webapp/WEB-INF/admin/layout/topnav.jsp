<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .log {
        margin: 10px;
        margin-left: 20px;
    }

    .chualog {
        margin-top: -25px;
    }

    .canhchinhuser {
        margin-right: 30px;
    }
</style>
<div id="preloader">
    <div id="status">&nbsp;</div>
</div>
<div class="header-connect">
    <div class="container">
        <div class="row">
            <div class="col-md-5 col-sm-8  col-xs-12">
                <div class="header-half header-call">
                    <p>
                        <span><i class="pe-7s-call"></i> +1 234 567 7890</span>
                        <span><i class="pe-7s-mail"></i> your@company.com</span>
                    </p>
                </div>
            </div>
            <div class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
                <div class="header-half header-social">
                    <ul class="list-inline">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-vine"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                        <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default ">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="admin/assets/img/logo.png" alt=""></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse yamm" id="navigation">
            <ul class="main-nav nav navbar-nav navbar-right">
                <li class="dropdown ymm-sw" data-wow-delay="0.1s">
                    <a href="index.html" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown"
                       data-delay="200">Home </a>
                </li>
                <li class="dropdown ymm-sw" data-wow-delay="0.1s">
                    <a href="index.html" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown"
                       data-delay="200">Quản lí nhân viên <b class="caret"></b></a>
                    <ul class="dropdown-menu navbar-nav">
                        <li>
                            <a href="index-2.html">Danh sách nhân viên</a>
                        </li>
                        <li>
                            <a href="index-3.html">Thêm mới nhân viên</a>
                        </li>

                    </ul>
                </li>

                <li class="dropdown ymm-sw" data-wow-delay="0.1s">
                    <a href="index.html" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown"
                       data-delay="200">Quản lí khách hàng <b class="caret"></b></a>
                    <ul class="dropdown-menu navbar-nav">
                        <li>
                            <a href="index-2.html">Danh sách khách hàng mới</a>
                        </li>
                        <li>
                            <a href="index-2.html">Danh sách khách hàng</a>
                        </li>

                    </ul>
                </li>

                <li class="dropdown ymm-sw" data-wow-delay="0.1s">
                    <a href="index.html" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown"
                       data-delay="200">Quản lí sản phẩm <b class="caret"></b></a>
                    <ul class="dropdown-menu navbar-nav">
                        <li>
                            <a href="index-2.html">Danh sách sản phẩm</a>
                        </li>
                        <li>
                            <a href="index-3.html">Thêm mới sản phẩm</a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown ymm-sw" data-wow-delay="0.1s">
                    <a href="index.html" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown"
                       data-delay="200">Quản lí đơn hàng <b class="caret"></b></a>
                    <ul class="dropdown-menu navbar-nav">
                        <li>
                            <a href="index-2.html">Danh sách đơn hàng</a>
                        </li>
                        <li class="dropdown ymm-sw" data-wow-delay="0.1s">
                            <a href="index.html" class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown"
                               data-delay="200">Duyet Don Hang <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Dang Van Chuyen</a>
                                </li>
                                <li>
                                    <a href="index-2.html">Hoan Thanh</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>



                <li class="wow fadeInDown animated" data-wow-delay="0.1s"
                    style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInDown;">
                    <div class="log">
                        <c:choose>
                        <c:when test="${sessionScope.username!=null}">
                            <label class="canhchinhuser">${sessionScope.username}</label>
                            <a href="/logout">
                                <button>log out</button>
                            </a>
                        </c:when>
                        <c:otherwise>
                    </div>
                    <div class="button navbar-right chualog">
                        <a href="/login">
                            <button class="navbar-btn nav-button wow bounceInRight login animated"
                                    style="visibility: visible; animation-delay: 0.4s; animation-name: bounceInRight;">
                                Login
                            </button>
                        </a>
                        <a href="/signup">
                            <button class="navbar-btn nav-button wow fadeInRight animated"
                                    style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
                                Sign Up
                            </button>
                        </a>
                    </div>
                    </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>