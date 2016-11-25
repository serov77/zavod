<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div>

<c:if test="${!empty vagonList}">
    <jsp:include page="table_vagon.jsp"/>
</c:if>
<c:if test="${empty vagonList}">
    <h3>Нет Данных</h3>
</c:if>
<sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
    <div class="block">
        <button class="btn btn-info btn-lg butt_add" type="button">Добавить вагон</button>
    </div>
</sec:authorize>
<script src="<c:url value="/resources/js/sbit/vagon/table_vagon.js"/>"></script>


