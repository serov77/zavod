<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  

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
                    <button class="btn btn-default btn-xs butt" rel="${vagon.id}" type="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                </td>
            </tr>
        </c:forEach> 
    </tbody>
</table>







