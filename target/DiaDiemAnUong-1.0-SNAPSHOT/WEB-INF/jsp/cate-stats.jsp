<%-- 
    Document   : cate-stats
    Created on : Sep 3, 2022, 4:57:11 PM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Tên danh mục</th>
                <th>Số món ăn</th>
            </tr>
            <c:forEach items="${stats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <canvas id="myChart"></canvas>
    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];

    <c:forEach items="${stats}" var="c">
        data.push(${c[2]});
        labels.push('${c[1]}');
    </c:forEach>

        cateStats(data, labels);
    }
</script>