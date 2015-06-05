<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>Таблица "Род Вагона"</h3>
</br>
<table id="rod_vagona" class="table table-bordered table-hover table-striped table-condensed display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="rodVagona">
            <tr>
                <td>${rodVagona.id}</td>
                <td>${rodVagona.name}</td>
            </tr>
        </c:forEach> 
    </tbody>
</table>

<script src="<c:url value="/resources/js/sbit/rod_vagona/table_rod_vagona.js"/>"></script>
