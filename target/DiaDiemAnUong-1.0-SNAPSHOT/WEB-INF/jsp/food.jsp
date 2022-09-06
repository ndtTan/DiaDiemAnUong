<%-- 
    Document   : food
    Created on : Aug 31, 2022, 2:11:41 AM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary">Quản Lý Menu</h1>


<c:url value="/admin/food" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="${action}" modelAttribute="food" enctype="multipart/form-data">
    
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="name" id="name" />
        <label for="name">Tên sản phẩm</label>
        <form:errors path="name" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input class="form-control" path="price" id="price"/>
        <label for="price">Giá sản phẩm</label>
        <form:errors path="price" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating">
        <form:select path="categoryId" class="form-select" id="sel1" name="sellist">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.categoryName}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Chọn danh mục:</label>
    </div>
    
    <div class="form-group mt-3 mb-3">
        <label for="file">Ảnh sản phẩm</label>
        <form:input type="file" class="form-control" path="file" id="file" placeholder="file"/>
    </div>

    <div class="form-floating">
        <br>
        <input type="submit" value="Thêm món ăn" class="btn btn-danger" />
    </div>
</form:form>

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
