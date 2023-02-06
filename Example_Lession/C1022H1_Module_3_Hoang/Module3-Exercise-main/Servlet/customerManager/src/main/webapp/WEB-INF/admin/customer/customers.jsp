<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>GARO ESTATE | Home page</title>
    <jsp:include page="/WEB-INF/admin/layout/headcss.jsp"></jsp:include>
    <style>
        .search-form {
        display: flex;
        border: none;
        margin: 20px;
        padding: 0px 0px;
        }

        .search-form>input {
            border: 1px solid;
            padding: 10px;
            margin-right: 10px;
        }

        .row-search-form {
            justify-content: space-between;
            display: flex;
            padding: 0px 20px;
        }

        .addproductbtn {
            margin-top: 25px;
            margin-right: auto;
        }

        .addproductbtn button {
            font-size: 24px;
            border: 2px solid;
        }

        .phantrang {
            float: right!important;
            margin-right: 60px;
        }


    </style>

</head>
<body>
<!-- Body content -->
<jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
<!-- End of nav bar -->
<div class="row">
    <div class="col-sm-12">
        <div class="demo-box p-2">
            <div class="row row-search-form">
                <div class="addproductbtn"><a href="/customers?action=create"><button style="font-size:24px; border: 2px solid" >add Product</button></a>
                </div>
                <div>
                    <form method="get" action="/customers" class="search-form">
                        <input type="text" name="kw" class="mr-1" value="${requestScope.kw}">
                        <select name="idCountry" id="idCountry" class="form-control" class="mr-1" >
                            <option value="-1">All</option>
                            <c:forEach items="${applicationScope.countries}" var="country">
                                <option value="${country.getId()}" <c:if test="${requestScope.idCountry == country.getId()}"> selected</c:if>>${country.getName()}
                                </option>
                            </c:forEach>
                        </select>
                        <button>Search</button>
                    </form>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Fullname</th>
                        <th scope="col">Address</th>
                        <th scope="col">Country</th>
                        <th scope="col">Picture</th>
                        <th scope="col">Action</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.customers}" var="customer">
                        <tr>
                            <th scope="row">${customer.getId()}</th>
                            <td>${customer.getName()}</td>
                            <td>${customer.getAddress()}</td>
                            <c:forEach items="${applicationScope.countries}" var="country">
                                <c:if test="${country.getId() == customer.getIdCountry()}">
                                    <td>${country.getName()}</td>
                                </c:if>
                            </c:forEach>
                            <td><img src="${customer.getPicture()}"> </td>
                            <td>
                                <a href="/customers?action=edit&id=${customer.getId()}"><i class="fa fa-edit" style="font-size:24px"></i> </a>
                                <a href="/customers?action=remove&id=${customer.getId()}"><i class="fa fa-remove" style="font-size:24px; color: red;"></i> </a>
                                    <%--                    <i class="fa fa-remove" onclick="myFunction(this)"  id="${customer.getId()}"  style="font-size:24px"></i>--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="phantrang">
                <ul class="pagination pagination-split float-right mb-0">
                    <c:if test="${currentPage != 1}">
                        <li class="page-item">
                            <a href="/customers?page=${currentPage - 1}&kw=${requestScope.kw}&idCountry=${requestScope.idCountry}" class="page-link"><i class="fa fa-angle-left"></i></a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <li class="page-item active">
                                    <a href="#" class="page-link">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a href="/customers?page=${i}&q=${requestScope.kw}&idCountry=${requestScope.idCountry}" class="page-link">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage lt noOfPages}">
                        <li class="page-item">
                            <a href="/customers?page=${currentPage + 1}&kw=${requestScope.kw}&idCountry=${requestScope.idCountry}" class="page-link"><i class="fa fa-angle-right"></i></a>
                        </li>
                    </c:if>

                </ul>
            </div>
        </div>
        <!-- end card-box -->
    </div>
    <!-- end col -->
</div>
<jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>

</body>
</html>