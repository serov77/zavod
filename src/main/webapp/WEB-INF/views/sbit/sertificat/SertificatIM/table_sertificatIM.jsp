<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>Таблица "Сертификаты на Известь Молотую"</h3>
</br>
<table id="sertificatsIM" class="table table-bordered table-hover table-striped table-condensed display">
    <thead>
    <tr>
        <th>ID</th>
        <th>№</th>
        <th>Покупатель</th>
        <th>Дата</th>
        <th>CaO + MgO, %</th>
        <th>Время гашения</th>
        <th>Темп. гашения</th>
        <th>Угл., %</th>
        <td>Сито 0.2 мм</td>
        <td>Сито 0.08 мм</td>
        <th>Опции</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sertificatIMList}" var="sertificat">
        <tr class="t_${sertificat.id}">
            <td>${sertificat.id}</td>
            <td>${sertificat.nomer}</td>
            <td>${sertificat.pokupatel.name}</td>
            <td><fmt:formatDate value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
            <td>${sertificat.aktivnost}</td>
            <td>${sertificat.vremyaGascheniya}</td>
            <td>${sertificat.temperaturaGascheniya}</td>
            <td>${sertificat.soderUglekisloti}</td>
            <td>${sertificat.sito02}</td>
            <td>${sertificat.sito008}</td>
            <td>
                <button class="btn btn-default btn-xs butt" rel="IM/${sertificat.id}" type="button">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
