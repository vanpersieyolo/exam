<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/3/2020
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            Thành phố <c:out value="${city.cityName}"/>
        </div>
        <div class="col">
            <a href="/city?action=back">Trở về</a>
        </div>
    </div>
    <table border="1" cellpadding="10px">
        <tr>
            <td>Id thành phố:</td>
            <td><c:out value="${city.cityId}" /></td>
        </tr>
        <tr>
            <td>Tên thành phố:</td>
            <td><c:out value="${city.cityName}"/></td>
        </tr>
        <tr>
            <td>Tên quốc gia:</td>
            <td><c:out value="${city.nationalName}"/></td>
        </tr>
        <tr>
            <td> Diện tích :</td>
            <td><c:out value="${city.cityArea}"/></td>
        </tr>
        <tr>
            <td>GDP:</td>
            <td><c:out value="${city.cityGDP}"/></td>
        </tr>
        <tr>
            <td> Mô tả:</td>
            <td><c:out value="${city.cityDescription}"/></td>
        </tr>
        <tr>
            <td><a href="/city?action=update&id=${city.cityId}">Chỉnh sửa</a></td>
            <td><a href="/city?action=remove&id=${city.cityId}">Xóa</a></td>
        </tr>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
