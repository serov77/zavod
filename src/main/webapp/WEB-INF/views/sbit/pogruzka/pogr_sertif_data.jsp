<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="form-group">
    <c:if test="${!empty sertificatList}">
        <label path="sertificat" class="col-xs-4 control-label">Номер Сертификата</label>

        <div class="col-xs-8">
            <select class="form-control selectpicker show-tick" name="sertId" id="sertId">
                <c:forEach items="${sertificatList}" var="sert">
                    <option value="${sert.id}">${sert.nomer}</option>
                </c:forEach>
            </select>
        </div>
    </c:if>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
    <c:if test="${!empty sertificatList}">
        <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
    </c:if>
    <c:if test="${empty sertificatList}">
        <button class="btn btn-default disabled" id="button_submit" type="submit">Сохранить изменения
        </button>
    </c:if>
</div>
<script>
    $('.selectpicker').selectpicker({});
</script>