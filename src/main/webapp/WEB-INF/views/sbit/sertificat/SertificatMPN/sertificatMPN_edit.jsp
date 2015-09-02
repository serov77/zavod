<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Сертификат</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
               commandName="sertificat">
    <div class="modal-body" id="mesto_body">
        <h3>${title_modal}</h3>
        </br>
        <form:hidden path="id"/>
        <div class="form-group">
            <form:label path="nomer" class="col-xs-4 control-label">Номер Сертификата</form:label>
            <div class="col-xs-8">
                <form:input path="nomer" class="form-control" oninput="Ftest (this)"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="massovayaDolyaVlagi" class="col-xs-4 control-label">Влага, %</form:label>
            <div class="col-xs-8">
                <form:input path="massovayaDolyaVlagi" class="form-control" oninput="Ftest (this)"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="pokupatel" class="col-xs-4 control-label">Получатель</form:label>
            <div class="col-xs-8">
                <form:select path="pokupatel.id" id="pokupatel" class="form-control">
                    <form:option value="1" label=""/>
                    <form:options items="${pokupatelList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label path="zerovoySostav1250" class="col-xs-4 control-label">Сито 1.25 мм</form:label>
            <div class="col-xs-8">
                <form:input path="zerovoySostav1250" class="form-control" oninput="Ftest (this)"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="zerovoySostav0315" class="col-xs-4 control-label">Сито 0.315 мм</form:label>
            <div class="col-xs-8">
                <form:input path="zerovoySostav0315" class="form-control" oninput="Ftest (this)"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="zerovoySostav0071" class="col-xs-4 control-label">Сито 0.071 мм</form:label>
            <div class="col-xs-8">
                <form:input path="zerovoySostav0071" class="form-control" oninput="Ftest (this)"/>
            </div>
        </div>
        <form:hidden path="data" class="form-control"/>
        <c:if test="${!empty sertificat.data}">
            <div class="form-group">
                <form:label path="data" class="col-xs-4 control-label">Дата добавления</form:label>
                <div class="col-xs-8">
                    <div class="form-control"><fmt:formatDate value="${sertificat.data}" pattern="dd.MM.yyyy"/></div>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <form:label path="otmetki" class="col-xs-4 control-label">Прим.</form:label>
            <div class="col-xs-8">
                <form:input path="otmetki" class="form-control"/>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
        </div>
        </form:form>
    </div>
</div>
<script src="<c:url value="/resources/js/sbit/sertificat/sertificatMPN/sertificatMPN_edit.js"/>"></script>
