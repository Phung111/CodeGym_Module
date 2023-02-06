<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <title>Case Study - Quản Lí Sản Phẩm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css  ">
    <link rel="stylesheet" href="/admin1/css/menu.css">
    <link rel="stylesheet" href="/admin1/css/customer.css">
    <style>
        #main {
            width: auto;
            height: auto;
            margin-left: 1%;
        }
        img {
            width: 50px;
        }
    </style>
</head>

<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/customer/topnav.jsp"></jsp:include>
    <div id="content">
        <div id="main">
            <section class="wrapper">
                <div class="products">
                    <ul>
                        <c:if test="${requestScope.messagesuccess!=null}">
                            <div class="alert alert-primary">
                                    ${requestScope.messagesuccess}
                            </div>
                        </c:if>
                        <c:forEach items="${requestScope.products}" var="product">
                            <li class="main-product">
                                <div class="img-product">
                                    <img class="img-prd"
                                         src="${product.getImage()}"
                                         alt="">
                                </div>
                                <div class="content-product">
                                    <h3 class="content-product-h3">${product.getName()}</h3>
                                    <div class="content-product-deltals">
                                        <div class="price">
                                            <span class="money">${product.getPrice()}</span>
                                        </div>
                                        <div>
                                            <form action="/trangchu?action=addtocart" method="post">
                                                <div><input type="hidden" name="id" value="${product.getId()}"></div>
                                                <button type="submit" class="btn btn-cart" style="cursor: pointer">Thêm Vào Giỏ</button>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
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