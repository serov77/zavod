<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Погрузка Вагонов Минеральным Порошком Неактивированным"</h3>
</br>
<div class="panel-group" id="accordion_6">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion_6" href="#collapseOne_6">Вагоны минерального порошка неактивированного отправленные</a>
            </h4>
        </div>
        <div id="collapseOne_6" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty pogruzkaMPNList}">
                    <table id="pogruzkaMPN"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№ Вагона</th>
                            <th>Брутто, т.</th>
                            <th>Нетто, т.</th>
                            <th>Погружен</th>
                            <th>Отправлен</th>
                            <th>Тара</th>
                            <th>Получатель</th>
                            <th>Отметки</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pogruzkaIMList}" var="pogr">
                            <tr class="t_${pogr.id}">
                                <td>${pogr.id}</td>
                                <td>${pogr.vagon.nomerVagona}</td>
                                <td>${pogr.brutto}</td>
                                <td>${pogr.brutto - pogr.vagon.tara}</td>
                                <td><fmt:formatDate value="${pogr.dataPogruzki}" pattern="dd.MM.yyyy"/></td>
                                <td><fmt:formatDate value="${pogr.dataOtpravleniya}" pattern="dd.MM.yyyy"/></td>
                                <td>${pogr.tara.name}</td>
                                <td>${pogr.sertificatMPN.pokupatel.name}</td>
                                <td>${pogr.dopolneniya}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt" rel="${pogr.id}" type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty pogruzkaMPNList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
    <!-- 2 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 2 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion_7" href="#collapseOne_7">Вагоны минерального порошка неактивированного на линии</a>
            </h4>
        </div>
        <div id="collapseOne_7" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <c:if test="${!empty pogruzkaMPNNaLiniiList}">
                    <table id="pogruzkaMPN_2"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№ Вагона</th>
                            <th>Брутто, т.</th>
                            <th>Нетто, т.</th>
                            <th>Погружен</th>
                            <th>Тара</th>
                            <th>Отметки</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pogruzkaMPNNaLiniiList}" var="pogr">
                            <tr class="t_${pogr.id}">
                                <td>${pogr.id}</td>
                                <td>${pogr.vagon.nomerVagona}</td>
                                <td><fmt:formatNumber value="${pogr.brutto}" type="number"  pattern="0.0" /></td>
                                <td><fmt:formatNumber value="${pogr.brutto - pogr.vagon.tara}" type="number"  pattern="0.0" /></td>
                                <td><fmt:formatDate value="${pogr.dataPogruzki}" pattern="dd.MM.yyyy"/></td>
                                <td>${pogr.tara.name}</td>
                                <td>${pogr.dopolneniya}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt" rel="${pogr.id}" type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                    <button class="btn btn-default btn-xs butt" rel="${pogr.id}" type="button">
                                        <span class="glyphicon glyphicon-road"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty pogruzkaMPNNaLiniiList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
</div>