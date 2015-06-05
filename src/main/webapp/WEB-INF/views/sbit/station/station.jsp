<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div> 

<c:if test="${!empty stationList}">
    <jsp:include page="table_station.jsp"/>
</c:if>
<c:if test="${empty stationList}">
    <h3>Нет Данных</h3>
</c:if>
<div class="block">   
    <button class="btn btn-info btn-lg butt_add" type="button">Добавить станцию</button>
</div>

<script src="<c:url value="/resources/js/sbit/station/table_station.js"/>"></script>

