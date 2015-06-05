<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Таблица "Сертификаты на Минеральный порошок неактивированный"</h3>
</br>
<table id="sertificatsMPN" class="table table-bordered table-hover table-striped table-condensed display">
    <thead>
    <tr>
        <th>ID</th>
        <th>№</th>
        <th>Покупатель</th>
        <th>Дата</th>
        <th>Влага, %</th>
        <th>Сито 1.25 мм</th>
        <th>Сито 0.315 мм</th>
        <th>Сито 0.071 мм</th>
        <th>Опции</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sertificatMPNList}" var="sertificat">
        <tr class="t_${sertificat.id}">
            <td>${sertificat.id}</td>
            <td>${sertificat.nomer}</td>
            <td>${sertificat.pokupatel.name}</td>
            <td><fmt:formatDate value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
            <td>${sertificat.massovayaDolyaVlagi}</td>
            <td>${sertificat.zerovoySostav1250}</td>
            <td>${sertificat.zerovoySostav0315}</td>
            <td>${sertificat.zerovoySostav0071}</td>
            <td>
                <button class="btn btn-default btn-xs butt" rel="${sertificat.id}" type="button">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
