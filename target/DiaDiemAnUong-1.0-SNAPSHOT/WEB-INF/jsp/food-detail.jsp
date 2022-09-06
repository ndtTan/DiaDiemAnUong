<%-- 
    Document   : food_detail
    Created on : Sep 5, 2022, 5:16:58 AM
    Author     : tannn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger" style="margin-bottom: 2rem;">CHI TIET SAN PHAM</h1>

<div class="row">
    <div class="col-md-5" style="display: flex;justify-content: center;align-items: center;">
        <img src="${food.imgFood}" alt="${food.name}" class="img-fluid"/>
    </div>
    <div class="col-md-7" >
        <h1>${food.name}</h1>
    </div>
</div>


<c:url value="/api/comments" var="url" />

<div class="form-group">
    <textarea class="form-control" id="contentId" placeholder="Nội dung comment" style="margin-top: 1rem;"></textarea>
    <input type="button" onclick="addComment('${url}', ${food.id})" value="Bình luận" class="btn btn-danger" style="margin-top: 1rem;" />

    <ul id="comments" style="margin-bottom: 1rem; margin-top: 1rem; padding-left: 0;">

    </ul>
</div>



<script src="<c:url value="/js/food.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script>
    window.onload = function () {
        loadComments('${url}');
    }
</script>