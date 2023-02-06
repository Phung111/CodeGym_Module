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
    <link rel="stylesheet" href="/admin1/css/confirm.css">


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
        <div id="main".>
            <div>
                <div>
                    <div class="card-header" style="text-align: center;"><h1>Danh sách User</h1></div>
                    <div style="display: none" id="dialog">
                        <div id="snackbar">Some text some message..</div>
                    </div>
                </div>
                    <c:if test="${requestScope.message!=null}">
                        <script>
                            $(document).ready(function(){
                                document.querySelector("#dialog").style.display = "block";
                                let message = '<%=request.getAttribute("message")%>';
                                document.querySelector("#snackbar").innerText = message;
                            });
                            <%--setTimeout($(document).ready(function(){message.replace("<%=request.getAttribute("message")%>", "null"); }, 3000));--%>
                        </script>
                    </c:if>

                <div id="table4_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
                    <form action="user" method="get">
                        <div class="row be-datatable-header">
                            <div class="col-sm-6">
                                <div class="dataTables_length" id="table4_length">
                                    <label>Show
                                        <select id="idSlLimitEntries" name="table4_length" aria-controls="table4"
                                                class="custom-select custom-select-sm form-control form-control-sm"
                                                onchange="handleLimitEntries()">
                                            <c:forEach items="${requestScope.numberOflines}" var="numberOfline">
                                                <option value="${numberOfline}" <c:if
                                                        test="${requestScope.recordsPerPage == numberOfline}"> selected</c:if>>${numberOfline}
                                                </option>
                                            </c:forEach>
                                        </select> entries</label>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <input style="padding: 10px;" type="text" id="idTxtSearch" placeholder="Tìm kiếm..."
                                       name="q" value="${requestScope.q}">
                                <button id="submit" type="submit"><i class="fas fa-search"></i></button>
                                    <%--                                    <div class="input-group">--%>
                                    <%--                                        <div class="form-outline">--%>
                                    <%--                                            <input type="search" id="form1" class="form-control" value="${requestScope.q}" name="q" />--%>
                                    <%--                                        </div>--%>
                                    <%--                                        <button type="button" class="btn btn-primary">--%>
                                    <%--                                            <i class="fas fa-search"></i>--%>
                                    <%--                                        </button>--%>
                                    <%--                                    </div>--%>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="table-responsive">
                    <table class="table" style="font-size: 13px; text-align: left;">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Họ Tên</th>
                            <th scope="col">Ngày Sinh</th>
                            <th scope="col">Số Điện Thoại</th>
                            <th scope="col">Email</th>
                            <th scope="col">Địa Chỉ</th>
                            <th scope="col">Hình Ảnh</th>
                            <th scope="col">Quyền</th>
                            <th scope="col">Mật Khẩu</th>
                            <th scope="col">Ngày Tạo</th>
                            <th scope="col">Ngày Cập Nhật</th>
                            <th scope="col">Thao Tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.users}" var="user">
                            <tr class="odd gradeX">
                                <td class="text-center">${user.getId()}</td>
                                <td class="text-start">${user.getFullName()}</td>
                                <td class="text-end"> ${user.getBirthDay()}</td>
                                <td class="text-end">
                                        ${user.getPhoneNumber()}
                                </td>
                                <td class="text-center">
                                        ${user.getEmail()}
                                </td>
                                <td class="text-center">
                                        ${user.getAddress()}
                                </td>
                                <td class="text-center">
                                    <img src="${user.getImage()}"
                                         alt="image">
                                </td>
                                <td class="text-center">
                                        ${user.getRole()}
                                </td>
                                <td class="text-center">
                                        ${user.getPassword()}
                                </td>
                                <td class="text-center">
                                        ${user.getCreatedTime()}
                                </td>
                                <td class="text-center">
                                    <c:choose>
                                        <c:when test="${user.getUpdatedTime()==null}">
                                            <span>Chưa cập nhật</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span>${user.getUpdatedTime()}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="/user?action=edituser&id=${user.getId()}"><i class="fa fa-edit"
                                                                                          style="font-size:24px"></i>
                                    </a>
                                    <a href="/user?action=removeuser&id=${user.getId()}"
                                       onclick="return confirm('Bạn có chắc chắn xóa ${user.getFullName()} không?');"><i
                                            class="fa fa-remove"
                                            style="font-size:24px; color: red;"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <c:if test="${currentPage != 1}">
                            <a href="/user?page=${1}&q=${requestScope.q}&table4_length=${requestScope.recordsPerPage}">&laquo;</a>
                        </c:if>
                        <c:forEach begin="${requestScope.start}" end="${requestScope.end}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <a class="active">${i}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/user?page=${i}&q=${requestScope.q}&table4_length=${requestScope.recordsPerPage}">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${currentPage lt noOfPages}">
                            <a href="/user?page=${noOfPages}&q=${requestScope.q}&table4_length=${requestScope.recordsPerPage}">&raquo;</a>
                        </c:if>
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
</div>
<script>
    function handleLimitEntries() {
        let limitEntries = document.getElementById("idSlLimitEntries").value;
        let txtSearch = document.getElementById("idTxtSearch").value;

        <%--let url = `/user?table4_length=${limitEntries}&q=${txtSearch}`;--%>
        <%--console.log(url)--%>
        let url1 = "/user?table4_length=" + limitEntries + "&q=" + txtSearch;
        window.location.assign(url1)
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