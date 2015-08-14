<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <c:if test="${!empty sertificatList}">
        <label path="sertificat" class="col-xs-4 control-label">Номер Сертификата</label>

        <div class="col-xs-8">
            <select class="form-control" name="n" id="n">
                <c:forEach items="${sertificatList}" var="sert">
                    <option value="${sert.id}">${sert.nomer}</option>
                </c:forEach>
            </select>
        </div>
    </c:if>
