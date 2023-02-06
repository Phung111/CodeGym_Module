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
                                <div class="card-header" style="text-align: center;"><h1>Thêm Mới Sản Phẩm</h1></div>
                            </div>
                            <form method="post" style="display:flex; justify-content: space-evenly;">
                                <div>
                                    <table>
                                        <tr>
                                            <td>Tên Sản Phẩm: </td>
                                            <td><input type="text" name="productName"  placeholder="Nhập Tên Sản Phẩm"></td>
                                        </tr>
                                        <tr>
                                            <td>Giá: </td>
                                            <td><input type="text" name="price"  placeholder="Nhập Giá"></td>
                                        </tr>
                                        <tr>
                                            <td>Số Lượng: </td>
                                            <td><input type="text" name="quantity"  placeholder="Nhập Số Lượng"></td>
                                        </tr>
                                        <tr>
                                            <td>Chi Tiết: </td>
                                            <td><textarea type="text" name="description"  value=""></textarea></td>
                                        </tr>
                                        <tr >
                                            <td>Hình Ảnh: </td>
                                            <td><input type="text" name="image" id="image" onchange="chooseFile()"   placeholder="Nhập Hình Ảnh"></td>
                                        </tr>
                                        <tr >
                                            <td> </td>
                                            <td style="padding-top: 15px"><button>Thêm Sản Phẩm</button></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="form-group row">
                                    <img id="imageProduct" src="https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/02/09/image-removebg-preview-7.png" alt="">
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