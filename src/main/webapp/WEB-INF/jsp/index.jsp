<%-- 
    Document   : index
    Created on : Aug 24, 2022, 3:17:41 PM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${foods.size() == 0}">
    <p><em>KHONG CO SAN PHAM NAO</em></p>
</c:if>
    
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(pageCounter/pageSize)}" var="i">
        <c:url value="/" var="c">
            <c:param name="page" value="${i}"/>
        </c:url>
        <li class="page-item"><a class="page-link" href="${c}">Trang ${i}</a></li>
    </c:forEach>
  
</ul>
    
<div class="row">
    <c:forEach items="${foods}" var="f">
        <div class="col-md-3 col-xs-12" style="padding: 5px;">
            <div class="card">
                <img class="card-img-top" class="img-fluid" src="https://res.cloudinary.com/ndt1010/image/upload/v1661336253/cld-sample-4.jpg" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${f.name}</h4>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${f.price}" />
                        VND
                    </p>
                    <a href="#" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
