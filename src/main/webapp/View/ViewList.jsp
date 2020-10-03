<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/1/2020
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>City Management</h1>
    <h2>
        <a href="/city?action=add">Add New City</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of City</h2></caption>
        <div>
            <form method="post" action="/city?action=search">
                <input type="text" name="search">
                <button type="submit">search</button>
            </form>
        </div>
        <tr>
            <th>id</th>
            <th>tên tp</th>
            <th>diện tích</th>
            <th>gdp</th>
            <th>mô tả</th>
            <th>tên quốc gia</th>
        </tr>
        <c:forEach var="city" items="${cityList}">
            <tr>
                <td><c:out value="${city.cityId}"/></td>
                <td><a href="/city?action=detail&id=${city.cityId}"><c:out value="${city.cityName}"/></a></td>
                <td><c:out value="${city.cityArea}"/></td>
                <td><c:out value="${city.cityGDP}"/></td>
                <td><c:out value="${city.cityDescription}"/></td>
                <td><c:out value="${city.nationalName}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
