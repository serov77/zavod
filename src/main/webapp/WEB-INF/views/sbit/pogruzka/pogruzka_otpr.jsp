<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Оформление</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
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
                <label path="sertificat" class="col-xs-4 control-label">Номер Сертификата</label>

                <div class="col-xs-8">
                    <select class="form-control">
                        <option value="0"></option>
                        <c:forEach items="${sertificatList}" var="sert">
                            <option value="${sert.id}">${sert.nomer}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
            </div>
        </div>
    </form:form>

</div>
<script src="<c:url value="/resources/js/sbit/pogruzka/pogruzka_otpr.js"/>"></script>