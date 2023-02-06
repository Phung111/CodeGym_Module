<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Case Study - Quản Lí Sản Phẩm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css  ">
    <link rel="stylesheet" href="/admin1/css/menu.css">
    <style>
        img {
            width: 50px;
            height: 50px;
        }
    </style>
</head>

<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
    <div id="content">
        <div id="main">
            <div>
                <div>
                    <div class="card-header">Danh sách đơn hàng</div>
                    <div id="table4_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
                        <div class="row be-datatable-header">
                            <div class="col-sm-6">
                                <div class="dataTables_length" id="table4_length">
                                    <label>Show
                                        <select name="table4_length" aria-controls="table4"
                                                class="custom-select custom-select-sm form-control form-control-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select> entries</label>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <form action="/product?action=search" method="post">
                                    <div id="table4_filter" class="dataTables_filter" style="display: flex">
                                        <input type="search" class="form-control form-control-sm" placeholder=""
                                               aria-controls="table4" name="inputSearch">
                                        <button type="submit" class="btn btn-space btn-primary"
                                                style="margin: auto 0">
                                            <i class="icon icon-left mdi mdi-search"></i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Ngày Tạo</th>
                                <th scope="col">Tổng Tiền</th>
                                <th scope="col">Tình Trạng</th>
                                <th scope="col">Khách Hàng</th>
                                <th scope="col">User</th>
                                <th scope="col">Chi Tiết</th>
                                <th scope="col">Duyệt đơn</th>
                                <th scope="col">Thao Tác</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.orders}" var="order">
                                <c:if test="${order.getStatusId() == 1}">
                                    <tr class="odd gradeX">
                                        <td class="text-center">${order.getId()}</td>
                                        <td class="text-center">
                                                ${order.getCreatedTime()}
                                        </td>
                                        <td class="text-start">${order.getGrandTotal()}</td>

                                        <td><c:forEach items="${requestScope.statuss}" var="status">
                                            <c:if test="${status.getId() == 1}">
                                                ${status.getType()}
                                            </c:if>
                                        </c:forEach>
                                        </td>

                                        <td><c:forEach items="${requestScope.customers}" var="customer">
                                            <c:if test="${order.getCustomerId() == customer.getId()}">
                                                ${customer.getFullName()}
                                            </c:if>
                                        </c:forEach>
                                        </td>

                                        <td class="text-end">
                                            <c:if test="${order.getUserId() != null}">
                                                <c:forEach items="${requestScope.users}" var="user">
                                                    <c:if test="${order.getUserId() == user.getId()}">
                                                        ${user.getFullName()}
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </td>
                                        <td>
                                            <a href="/manager-oder?action=vieworderItem&id=${order.getId()}">Xem</a>
                                        </td>
                                        <td>
                                            <a href="/manager-oder?action=orderapproval&id=${order.getId()}">Duyệt đơn</a>
                                        </td>

                                        <td>
                                            <a href="#"><i class="fa fa-edit" style="font-size:24px"></i> </a>
                                            <a href="#"><i class="fa fa-remove" style="font-size:24px; color: red;"></i> </a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
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


<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $(document).ready(function () {
        $('.sub-menu').parent('li').addClass('has-child');
    })
</script>
</body>


</html>