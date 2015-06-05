<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  

<h3>Таблица "Получатели"</h3>
</br>
<table id="pokupatel" class="table table-bordered table-hover table-striped table-condensed display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Код</th>
            <th>ОКПО</th>
            <th>Станция</th>
            <th>Операции</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pokupatelList}" var="pokupatel">
            <tr class="t_${pokupatel.id}">
                <td>${pokupatel.id}</td>
                <td>${pokupatel.name}</td>
                <td>${pokupatel.kod}</td>
                <td>${pokupatel.okpo}</td>
                <td>${pokupatel.station.nameStation}</td>
                <td>
                    <button class="btn btn-default btn-xs butt" rel="${pokupatel.id}" type="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                </td>
            </tr>
        </c:forEach> 
    </tbody>
</table>
