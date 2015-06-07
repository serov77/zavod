<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  

    <h3>Таблица "Станции"</h3>
    </br>
    <table id="stations" class="table table-bordered table-hover table-striped table-condensed display">
        <thead>
            <tr>
                <th>ID</th>
                <th>Название станции</th>
                <th>Код</th>
                <th>Операции</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${stationList}" var="station">
                <tr class="t_${station.id}">
                    <td>${station.id}</td>
                    <td>${station.name}</td>
                    <td>${station.kod}</td>
                    <td>
                        <button class="btn btn-default btn-xs butt" rel="${station.id}" type="button">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    