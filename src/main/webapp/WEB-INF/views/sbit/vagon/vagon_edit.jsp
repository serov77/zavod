<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Вагон</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
               commandName="vagon">
        <div class="modal-body" id="mesto_body">
            <h3>${title_modal}</h3>
            </br>
            <form:hidden path="id" />
            <div class="form-group">
                <form:label path="nomerVagona" class="col-xs-4 control-label">Номер вагона</form:label>
                    <div class="col-xs-8">
                    <form:input path="nomerVagona" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <form:label path="rodVagona" class="col-xs-4 control-label">Род вагона</form:label>
                    <div class="col-xs-8">
                    <form:select path="rodVagona.id" id="rodVagona" class="form-control">
                        <form:option value="0" label="" />
                        <form:options items="${rodVagonaList}" itemValue="id" itemLabel="name" />
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <form:label path="tara" class="col-xs-4 control-label">Тара</form:label>
                    <div class="col-xs-8">
                    <form:input path="tara" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="gruzopodyomnost" class="col-xs-4 control-label">Грузоподъемность</form:label>
                    <div class="col-xs-8">
                    <form:input path="gruzopodyomnost" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="kolichestvoZpu" class="col-xs-4 control-label">Количество ЗПУ</form:label>
                    <div class="col-xs-8">
                    <form:select path="kolichestvoZpu" class="form-control">
                        <form:option value="0" label="нет" />
                        <form:option value="1" label="1" />
                        <form:option value="2" label="2" />
                        <form:option value="3" label="3" />
                        <form:option value="4" label="4" />
                        <form:option value="5" label="5" />
                        <form:option value="6" label="6" />
                        <form:option value="7" label="7" />
                        <form:option value="8" label="8" />
                        <form:option value="9" label="9" />
                        <form:option value="10" label="10" />
                    </form:select>
                </div>
            </div>
            <c:if test="${!empty vagon.dataDobavleniya}">
                <div class="form-group">
                    <form:label path="dataDobavleniya" class="col-xs-4 control-label">Дата добавления</form:label>
                        <div class="col-xs-8">
                            <div class="form-control"><fmt:formatDate value="${vagon.dataDobavleniya}" pattern="dd.MM.yyyy"/></div>
                    </div>
                </div>
            </c:if>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
            </div> 
        </form:form>
    </div>
    <script src="<c:url value="/resources/js/sbit/vagon/vagon_edit.js"/>"></script>
