<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>              

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div>
<c:if test="${!empty pokupatelList}">
    <jsp:include page="table_pokupatel.jsp"/>
</c:if>
<c:if test="${empty pokupatelList}">
    <h3>Нет Данных</h3>
</c:if>
<div class="block">   
    <button class="btn btn-info btn-lg butt_add_pokupatel" type="button">Добавить Получателя</button>
</div>

<script src="<c:url value="/resources/js/sbit/pokupatel/table_pokupatel.js"/>"></script>
