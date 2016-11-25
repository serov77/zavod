<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Вагоны" (Всего вагонов: ${vagonList.size()})</h3>
</br>
<table id="vagons" class="table table-bordered table-hover table-striped table-condensed display">
    <thead>
    <tr>
        <th>ID</th>
        <th>Род</th>
        <th>Номер</th>
        <th>Тара</th>
        <th>Гр-сть</th>
        <th>ЗПУ</th>
        <th>Дата добавления</th>
        <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
            <th>Операции</th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${vagonList}" var="vagon">
        <tr class="t_${vagon.id}">
            <td>${vagon.id}</td>
            <td>${vagon.rodVagona.name}</td>
            <td>${vagon.nomerVagona}</td>
            <td>${vagon.tara}</td>
            <td>${vagon.gruzopodyomnost}</td>
            <td>${vagon.kolichestvoZpu}</td>
            <td><joda:format value="${vagon.dataDobavleniya}" pattern="dd.MM.yyyy"/></td>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                <td>
                    <button class="btn btn-default btn-xs butt_edit" rel="${vagon.id}" type="button"
                            data-toggle="tooltip" data-placement="right" title="Редактирование Вагона">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                    <button id="butt_poroz" class="btn btn-default btn-xs" rel="${vagon.id}" type="button"
                            data-toggle="tooltip" data-placement="right" title="Отметить по прибытии">
                        <span class="glyphicon glyphicon-check"></span>
                    </button>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>





