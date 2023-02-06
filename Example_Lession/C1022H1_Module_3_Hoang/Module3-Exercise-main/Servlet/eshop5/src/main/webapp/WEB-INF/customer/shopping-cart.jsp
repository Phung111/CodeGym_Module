<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            margin-left: 1%;
            float: none;
        }

        img {
            width: 50px;
        }

        td button{
            margin-top: 0px;
        }
        .name {
            margin-top: 15px;
        }

        .leftPST {
            text-align: center;
            padding-right: 5px;
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 10px;
            margin-left: 65px;
        }


        .btnn{
            text-align: center;
        }

    </style>
</head>

<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/customer/topnav.jsp"></jsp:include>
    <div id="content">
        <div id="main">
            <div>
                <h1 style="text-align: center">Danh Sách Sản Phẩm</h1>
                <table border="1">
                    <tr>
                        <th class="text-center">Id Sản Phẩm</th>
                        <th class="text-center">Sản phẩm</th>
                        <th class="text-center">Giá (VNĐ)</th>
                        <th class="text-center">Số lượng</th>
                        <th class="text-center">Thành tiền (VNĐ)</th>
                    </tr>
                    <c:forEach items="${requestScope.carts}" var="cart">
                    <tr>
                        <td style="text-align: center">${cart.getProductId()}</td>
                        <td><img src="https://cdn1.viettelstore.vn/images/Product/ProductImage/medium/325815861.jpeg"
                                 alt="" style="float: left;padding-left: 20%">
                            <p class="name">${cart.getProductName()}</p>
                        </td>
                        <td class="leftPST" style="text-align: center">${cart.getPrice()}</td>
                        <td class="leftPST ">
                            <div class="buttons_added">
                                    <a href="/cart?action=add&id=${cart.getProductId()}"><i class="fa-solid fa-plus"></i></a>
                                    <input style="text-align: center" aria-label="quantity" class="input-qty"  min="0" name="" type="number" name="quatity" value="${cart.getQuantity()}" disabled>
                                    <a href="/cart?action=sub&id=${cart.getProductId()}"><i class="fa-solid fa-minus"></i></a>
                            </div>
                        </td>
                        <td class="leftPST">${(cart.getPrice()*cart.getQuantity())}</td>
                        <td class="btnn"><a href="/cart?action=removeOne&id=${cart.getProductId()}"><button>remove</button></a></td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td class="btnn"><a href="/cart?action=removeAll"><button>Xoa Tat Ca</button></a></td>
                        <td class="btnn"><a href="/trangchu"><button>Tiep Tuc Mua Sam</button></a></td>
                            <td colspan="3" style="text-align: end; padding: 10px;">Tổng Tiền: ${requestScope.total}</td>
                        <td class="btnn"><a href="/checkout"><button>Thanh Toán</button></a></td>
                    </tr>
                </table>
            </div>
        </div>    </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $(document).ready(function () {
        $('.sub-menu').parent('li').addClass('has-child');
    })



    class Order{
        constructor(name, address, total) {
            this.name = name;
            this.address = address;
            this.total = total;
            this.orderItems = [];
        }
    }
    class OrderItem{
        constructor(idProduct, idOrder, quantity){
            this.idProduct = idProduct;
            this.idOrder = idOrder;
            this.quantity = quantity;
        }
    }
</script>
</body>


</html>