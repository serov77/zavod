<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Вагоны"</h3>
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
        <th>Операции</th>
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
            <td><fmt:formatDate value="${vagon.dataDobavleniya}" pattern="dd.MM.yyyy"/></td>
            <td>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                    <button class="btn btn-default btn-xs butt_edit" rel="${vagon.id}" type="button" data-toggle="tooltip" data-placement="right" title="Редактирование Вагона">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                    <button class="btn btn-default btn-xs butt_pogr" rel="${vagon.id}" type="button" data-toggle="tooltip" data-placement="right" title="Взвешивание Вагона">
                        <span class="glyphicon glyphicon-download-alt"></span>
                    </button>
                </sec:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>






