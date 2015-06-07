<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    textarea {
        resize:vertical;
    } 
</style>
<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Станция</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
               commandName="station">
        <div class="modal-body" id="mesto_body">
            <h3>${title_modal}</h3>
            </br>
            <form:hidden path="id" />
            <div class="form-group">
                <form:label path="name" class="col-xs-4 control-label">Название станции</form:label>
                    <div class="col-xs-8">
                    <form:textarea path="name" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <form:label path="kod" class="col-xs-4 control-label">Код</form:label>
                    <div class="col-xs-8">
                    <form:input path="kod" class="form-control"/>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
            </div> 
        </form:form>
    </div>
    <script src="<c:url value="/resources/js/sbit/station/station_edit.js"/>"></script>
