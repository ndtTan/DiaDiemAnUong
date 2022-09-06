<%-- 
    Document   : rev-stats
    Created on : Sep 5, 2022, 12:42:55 AM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

${revenueStats}
<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Tên món ăn</th>
                <th>Doanh thu món ăn</th>
            </tr>
            <c:forEach items="${revenueStats}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]}</td>
                    <td>${r[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>