<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<table id="vagoni_poroznie" class="table table-bordered table-hover table-striped table-condensed display">
    <thead>
    <tr>
        <th>ID</th>
        <th>Род вагона</th>
        <th>Номер</th>
        <th>Груз</th>
        <th>№ Свид-ва</th>
        <th>Дата прибытия</th>
        <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
            <th>Операции</th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${vagoniPoroznieList}" var="vagon">
        <tr class="t_${vagon.id}">
            <td>${vagon.id}</td>
            <td>${vagon.vagon.rodVagona.name}</td>
            <td>${vagon.vagon.nomerVagona}</td>
            <td>${vagon.gruz.name}</td>
            <td>
                <c:if test="${vagon.nomerSvidetelstva>0}">
                    ${vagon.nomerSvidetelstva}
                </c:if>
            </td>
            <td><joda:format value="${vagon.dataPribitiya}" pattern="dd.MM.yyyy"/></td>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                <td>
                    <button class="btn btn-default btn-xs butt_porozniy_edit" rel="${vagon.id}" type="button"
                            data-toggle="tooltip" data-placement="right" title="Редактирование порожнего Вагона">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                    <button class="btn btn-default btn-xs butt_pogr" rel="${vagon.id}" type="button"
                            data-toggle="tooltip" data-placement="right" title="Взвешивание Вагона">
                        <span class="glyphicon glyphicon-download-alt"></span>
                    </button>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>






