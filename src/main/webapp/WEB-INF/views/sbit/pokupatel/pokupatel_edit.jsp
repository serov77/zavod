<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Получатель</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
               commandName="pokupatel">
    <div class="modal-body" id="mesto_body">
        <h3>${title_modal}</h3>
        </br>
        <form:hidden path="id"/>
        <div class="form-group">
            <form:label path="name" class="col-xs-4 control-label">Название получателя</form:label>
            <div class="col-xs-8">
                <form:input path="name" class="form-control"/>
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
            <form:label path="stations" class="col-xs-4 control-label">Станция</form:label>
            <div class="col-xs-8">
                <form:select path="stations" id="stations" multiple="true"
                             class="form-control  selectpicker multiple show-tick">
                    <form:option value="1" label=""/>
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
    <script type="text/javascript">
        var pokupatelJSON = ${pokupatelJSON};
        var s = [];
        for (i = 0; i < pokupatelJSON.stations.length; i++) {
            s.push(pokupatelJSON.stations[i].id);
        }

        $('.selectpicker').on('loaded.bs.select', function (e) {
            if (s.length == 0) {
                $('.selectpicker').selectpicker('val', 1);
            } else {
                $('.selectpicker').selectpicker('val', s);
            }
        });
        $('.selectpicker').on('changed.bs.select', function (e) {
            var x = $('.selectpicker');

            if (x.selectpicker('val')[0] == 1) {
                if (s[0] == 1) {
                    x.selectpicker('val', x.selectpicker('val')[1]);
                } else {
                    x.selectpicker('val', 1);
                }
            }
            s = x.selectpicker('val');
        });
    </script>

