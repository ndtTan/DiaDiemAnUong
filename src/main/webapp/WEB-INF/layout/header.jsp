<%-- 
    Document   : header
    Created on : Aug 29, 2022, 8:02:10 PM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">BC FoodStall</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <c:forEach items="${categories}" var="c">
                    <c:url value="/" var="cUrl">
                        <c:param name="cateId" value="${c.id}"/>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}">${c.categoryName}</a>
                    </li>
                </c:forEach>

            </ul>
            <c:url value="/" var="action"/>
            <form action="${action}" class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                <button type="submit" class="btn btn-primary" type="button">Tim</button>
            </form>
        </div>
    </div>
</nav>
