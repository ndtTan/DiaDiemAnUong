<%-- 
    Document   : cate-stats
    Created on : Sep 3, 2022, 4:57:11 PM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container mt-3">
    <h2 class="col-md-6" style="text-align: center;margin: auto;">THỐNG KÊ</h2>
    <br>
    <!-- Nav pills -->
    <ul class="nav nav-pills" role="tablist" style=" justify-content: center;">
        <li class="nav-item">
            <a class="nav-link active" data-bs-toggle="pill" href="#home">THỐNG KÊ SẢN PHẨM THEO DANH MỤC</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="pill" href="#menu1">Menu 1</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="pill" href="#menu2">Menu 2</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container tab-pane active"><br>
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
        </div>
        <div id="menu1" class="container tab-pane fade"><br>
            <h3>Menu 1</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div id="menu2" class="container tab-pane fade"><br>
            <h3>Menu 2</h3>
            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
        </div>
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