<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Выбранные вагоны</h4>
    </div>
    <form:form action="${pageContext.request.contextPath}/dokumentMPN" target="_blank" method="post" class="form-horizontal" commandName="listMPN">
        <div class="modal-body" id="mesto_body">
            <c:forEach items="${setPokupatel}" var="pokupatel">
                <h3>${pokupatel.name}</h3>
                <c:forEach items="${listMPN.pogruzkaMPNList}" var="pogr">
                    <c:if test="${pogr.sertificatMPN.pokupatel.id == pokupatel.id}">
                        <div>${pogr.vagon.nomerVagona}</div>
                    </c:if>
                </c:forEach>
                <hr>
            </c:forEach>
            <div class="form-group">
                <form:label path="kolSertMPN" class="col-xs-9 control-label">Сертификат</form:label>
                <div class="col-xs-3">
                    <form:select path="kolSertMPN" class="form-control">
                        <form:option value="0">Нет</form:option>
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <form:label path="spravkaOVzvMPN" class="col-xs-9 control-label">
                    Справка о взвешивании
                </form:label>
                <div class="col-xs-3">
                    <form:select path="spravkaOVzvMPN" class="form-control">
                        <form:option value="0">Нет</form:option>
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <form:label path="master" class="col-xs-4 control-label">Мастер погрузки</form:label>
                <div class="col-xs-8">
                    <form:input path="master" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            <button class="btn btn-default" id="button_pechat" type="submit">Печать</button>
        </div>
    </form:form>
</div>
<script src="<c:url value="/resources/js/sbit/pogruzka/pogruzkaMPN_pechat.js"/>"></script>