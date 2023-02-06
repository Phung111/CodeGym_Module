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

</head>
<body>
<!-- Body content -->
<jsp:include page="/WEB-INF/admin/layout/topnav.jsp"></jsp:include>
<!-- End of nav bar -->
<div class="container">
    <h1>Customer manager</h1>
    <a href="/customers?action=create"><button style="font-size:24px; border: 2px solid" >add Product</button></a>
    <div class="row row-search-form">
        <div><h4 class="header-title">List Customer</h4></div>
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
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Fullname</th>
            <th scope="col">Address</th>
            <th scope="col">Country</th>
            <th scope="col">Picture</th>
            <th scope="col">Action</th>
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
    <script>
        function myFunction(e) {
            let id = e.id;
            let url = "http://localhost:8080/customers?action=remove&id=" + id;
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                    window.location.replace(url);
                }
            })
        }


    </script>
</div>

<jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>

</body>
</html>