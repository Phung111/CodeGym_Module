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

<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
    <div id="content">
        <div id="main">
            <div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card card-border-color card-border-color-primary">
                            <div>
                                <div class="card-header" style="text-align: center;"><h1>Chỉnh Sửa Sản Phẩm</h1></div>
                            </div>
                            <form method="post" style="display:flex; justify-content: space-evenly;">
                                <div>
                                    <table>
                                        <input type="hidden" name="id" value="${requestScope.product.getId()}">
                                        <tr>
                                            <td>Tên Sản Phẩm: </td>
                                            <td><input type="" name="productName"  value="${requestScope.product.getName()}" ></td>
                                        </tr>
                                        <tr>
                                            <td>Giá: </td>
                                            <td><input type="text" name="price"  value="${requestScope.product.getPrice()}" ></td>
                                        </tr>
                                        <tr>
                                            <td>Số Lượng: </td>
                                            <td><input type="text" name="quantity"  value="${requestScope.product.getQuantity()}"></td>
                                        </tr>
                                        <tr>
                                            <td>Chi Tiết: </td>
                                            <td><textarea type="text" name="description"  value="${requestScope.product.getDescription()}"></textarea></td>
                                        </tr>
                                        <tr >
                                            <td>Hình Ảnh: </td>
                                            <td><input onchange="chooseFile()" type="text" name="image" onchange="chooseFile()" id="image"  value="${requestScope.product.getImage()}"></td>
                                        </tr>
                                        <tr >
                                            <td> </td>
                                            <td><button style="margin-top: 10px;">Save</button></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="form-group row">
                                    <img id="imageProduct" src="${requestScope.product.getImage()}" alt="picture" style="width: 300px;height: 400px">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
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