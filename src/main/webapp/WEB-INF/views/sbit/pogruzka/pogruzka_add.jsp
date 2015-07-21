<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Погрузка</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
               commandName="pogruzka">
    <div class="modal-body" id="mesto_body">
        <h3>${title_modal}</h3>
        </br>
        <form:hidden path="id" />
        <div class="form-group">
            <form:label path="name" class="col-xs-4 control-label">Название получателя</form:label>
            <div class="col-xs-8">
                <form:input path="name" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="kod" class="col-xs-4 control-label">Код</form:label>
            <div class="col-xs-8">
                <form:input path="kod" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="okpo" class="col-xs-4 control-label">ОКПО</form:label>
            <div class="col-xs-8">
                <form:input path="okpo" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="station" class="col-xs-4 control-label">Станция</form:label>
            <div class="col-xs-8">
                <form:select path="station.id" id="station" class="form-control">
                    <form:option value="1" label="" />
                    <form:options items="${stationList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
        </div>
        </form:form>
    </div>
    <script src="<c:url value="/resources/js/sbit/pokupatel/pokupatel_edit.js"/>"></script>
