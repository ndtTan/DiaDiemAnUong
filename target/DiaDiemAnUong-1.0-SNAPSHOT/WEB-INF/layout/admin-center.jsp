<%-- 
    Document   : admin-center
    Created on : Sep 4, 2022, 9:59:32 PM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul class="nav nav-pills" style="justify-content: center">
  <li class="nav-item">
      <a class="nav-link active" data-bs-toggle="tab" href="<c:url value="/admin/cate-stats"/>">THỐNG KÊ SẢN PHẨN THEO DOANH MỤC</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-bs-toggle="tab" href="<c:url value="/admin/rev-stats"/>">THỐNG KÊ DOANH THU THEO SẢN PHẨM</a>
  </li>
</ul>