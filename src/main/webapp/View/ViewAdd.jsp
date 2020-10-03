<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/3/2020
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h2>Add a city</h2>
        </div>
        <div class="col">
            <a href="/city?action=showall">Trở về</a>
        </div>
    </div>
    <form action="/city?action=add" method="post">
        <div class="row">
            <div class="col">Nhập tên thành phố</div>
            <div class="col"><input type="text" name="cityName"></div>
        </div>
        <div class="row">
            <div class="col">Nhập id quốc gia</div>
            <div class="col">
                <select name="nationalId">
                    <c:forEach var="national" items="${nationalList}" >
                        <option value="${national.nationalId}">${national.nationalName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col">Nhập diện tích thành phố</div>
            <div class="col"><input type="number" name="cityArea" ></div>
        </div>
        <div class="row">
            <div class="col">Nhập gdp</div>
            <div class="col"><input type="number" name="cityGDP"></div>
        </div>
        <div class="row">
            <div class="col">Nhập mô tả</div>
            <div class="col"><input type="text" name="cityDescription"></div>
        </div>
        <input type="submit" value="Thêm">
    </form>
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
