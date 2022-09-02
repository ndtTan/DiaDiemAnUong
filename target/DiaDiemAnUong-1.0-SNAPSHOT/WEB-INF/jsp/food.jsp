<%-- 
    Document   : food
    Created on : Aug 31, 2022, 2:11:41 AM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary">Quản Lý Menu</h1>

<div class="spinner-border text-dark" id="loadIcon"></div>
<table class="table">
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tbody id="adminFood">
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>
<script src="<c:url value="/js/food.js" />"></script>
<script>
    <c:url value="/api/food" var="endpoint" />
    window.onload = function () {
        loadAdminFood('${endpoint}');
    }
</script>
