<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Оформление</h4>
    </div>
    <form:form id="edit_form_dobSert" class="form-horizontal" method="post"
               action="pogruzka/save"
               commandName="pogruzka">
        <div class="modal-body" id="mesto_body">
            <h3>${title_modal}</h3>
            </br>
            <div class="form-group">
                <form:label path="vagon.nomerVagona" class="col-xs-4 control-label">Номер Вагона</form:label>
                <div class="col-xs-8">
                    <form:input path="vagon.nomerVagona" class="form-control" readonly="true"/>
                </div>
            </div>
            <div class="form-group">
                <label path="sertificat" class="col-xs-4 control-label">Дата Сертификата</label>

                <div class="col-xs-8">
                    <div class="input-group date" id="datetimepicker1">
                        <input type="text" class="form-control" id="dtqqq" readonly="readonly"/>
                    <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
            </div>
            <div class="form-group" id="sertif_data">
                <jsp:include page="pogr_sertif_data.jsp"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
            </div>
        </div>
    </form:form>
    <input type="hidden" id="gruz" value="${gruz}">
    <input type="hidden" id="pogrId" value="${pogruzka.id}">
</div>
<script src="<c:url value="/resources/js/sbit/pogruzka/pogruzka_otpr.js"/>"></script>

