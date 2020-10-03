<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/3/2020
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fuild">
    <h2>Chỉnh sửa thông tin</h2>
    <a href="/city?action=back">thoát</a>
    <form action="/city?action=update" method="post">
        <div class="row">
            <input type="text" value="<c:out value="${city.cityId}"/>" name="cityid" hidden>
            <div class="col">Tên thành phố <input type="text" value="<c:out value="${city.cityName}"/>" name="cityName"></div>
            <div class="col">Tên quốc gia <select name="nationalId">
                <c:forEach var="national" items="${nationalList}" >
                    <option value="${national.nationalId}">${national.nationalName}</option>
                </c:forEach>
            </select></div>
            <div class="col">Diện tích <input type="text" value="<c:out value="${city.cityArea}"/>" name="cityarea"></div>
            <div class="col">Gdp<input type="text" value="<c:out value="${city.cityGDP}"/>" name="cityGdp"></div>
            <div class="col">Mô tả <input type="text" value="<c:out value="${city.cityDescription}"/>" name="cityDescription"></div>
        </div>
        <button type="submit"> chỉnh sửa</button>
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
