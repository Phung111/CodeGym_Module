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

<style>

</style>

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
                <div class="card-header" style="text-align: center;"><h1>Chỉnh Sửa User</h1></div>
              </div>
              <form method="post" style="display:flex; justify-content: space-evenly;">
                <div>
                  <table>
                    <tr>
                      <td>Họ Tên: </td>
                      <td><input type="text" name="fullName"  value="${requestScope.user.getFullName()}"></td>
                    </tr>
                    <tr>
                      <td>Ngày Sinh: </td>
                      <td><input type="date" name="birthDay"  value="${requestScope.user.getBirthDay()}" ></td>
                    </tr>
                    <tr>
                      <td>Số Điện Thoại: </td>
                      <td><input type="number" name="phoneNumber"  value="${requestScope.user.getPhoneNumber()}"></td>
                    </tr>
                    <tr>
                      <td>Email: </td>
                      <td><input type="email" name="email"  value="${requestScope.user.getEmail()}"></td>
                    </tr>
                    <tr>
                      <td>Địa Chỉ: </td>
                      <td><input type="text" name="address"  value="${requestScope.user.getAddress()}"></input></td>
                    </tr>
                    <tr>
                      <td>Hình Ảnh: </td>
                      <td><input id="image" onchange="chooseFile()"  type="text" name="image" value="${requestScope.user.getImage()}"></td>
                    </tr>
                    <tr>
                      <td>Vai Trò: </td>
                      <td><input type="number" name="role"  value="${requestScope.user.getRole()}" min="1" max="2"></td>
                    </tr>
                    <tr>
                      <td>Mật Khẩu: </td>
                      <td><input type="text" name="password"  value="${requestScope.user.getPassword()}"></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td><button style="margin-top: 10px;">Lưu Chỉnh Sửa</button></td>
                    </tr>
                  </table>
                </div>
                <div class="form-group row">
                  <img id="imageProduct" src="${requestScope.user.getImage()}" alt="image">
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