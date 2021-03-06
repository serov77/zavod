<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

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
            <td>
                <c:forEach items="${pokupatel.stations}" var="station">
                    ${station.name},
                </c:forEach>
            </td>
            <td>
                <button class="btn btn-default btn-xs butt_pokupatel" rel="${pokupatel.id}" type="button"
                        data-toggle="tooltip" data-placement="right" title="Редактирование Покупателя">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach items="${pokupatel.stations}" var="station">
    ${station.name},
</c:forEach>
<!--<script>
    $('.selectpicker').on('hidden.bs.select', function (e) {
        $('.selectpicker').selectpicker('val', []);
    });
</script>-->
