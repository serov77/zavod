<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Погрузка Вагонов Известью Комовой"</h3>
</br>
<div class="panel-group" id="accordion_2">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion_2" href="#collapseOne_2">Вагоны извести комовой отправленные</a>
            </h4>
        </div>
        <div id="collapseOne_2" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty pogruzkaIKList}">
                    <table id="pogruzkaIK"
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
                            <th>№ Серт.</th>
                            <th>Получатель</th>
                            <th>Прибыл</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pogruzkaIKList}" var="pogr">
                            <tr class="t_${pogr.id}">
                                <td>${pogr.id}</td>
                                <td>${pogr.vagon.nomerVagona}</td>
                                <td><fmt:formatNumber value="${pogr.brutto}" type="number" pattern="0.0"/></td>
                                <td><fmt:formatNumber value="${pogr.brutto - pogr.vagon.tara}" type="number"
                                                      pattern="0.0"/></td>
                                <td><fmt:formatDate value="${pogr.dataPogruzki}" pattern="dd.MM.yyyy"/></td>
                                <td><fmt:formatDate value="${pogr.dataOtpravleniya}" pattern="dd.MM.yyyy"/></td>
                                <td>${pogr.tara.name}</td>
                                <td>${pogr.sertificatIK.nomer}</td>
                                <td>${pogr.sertificatIK.pokupatel.name}</td>
                                <td>${pogr.dopolneniya}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_edit" rel="IK/${pogr.id}" type="button" data-toggle="tooltip" data-placement="right" title="Редактирование Погрузки">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty pogruzkaIKList}">
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
                <a data-toggle="collapse" data-parent="#accordion_3" href="#collapseOne_3">Вагоны извести комовой на линии</a>
            </h4>
        </div>
        <div id="collapseOne_3" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <c:if test="${!empty pogruzkaIKNaLiniiList}">
                    <table id="pogruzkaIK_2"
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
                            <th>Прибыл</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pogruzkaIKNaLiniiList}" var="pogr">
                            <tr class="t_${pogr.id}">
                                <td>${pogr.id}</td>
                                <td>${pogr.vagon.nomerVagona}</td>
                                <td><fmt:formatNumber value="${pogr.brutto}" type="number"  pattern="0.0" /></td>
                                <td>
                                    <fmt:formatNumber value="${pogr.brutto - pogr.vagon.tara}" type="number"  pattern="0.0" />
                                </td>
                                <td><fmt:formatDate value="${pogr.dataPogruzki}" pattern="dd.MM.yyyy"/></td>
                                <td>${pogr.tara.name}</td>
                                <td>${pogr.dopolneniya}</td>
                                <td><fmt:formatDate value="${pogr.dataPribitiyaVagona}" pattern="dd.MM.yyyy"/></td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_edit" rel="IK/${pogr.id}" type="button" data-toggle="tooltip" data-placement="right" title="Редактирование Погрузки">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                    <button class="btn btn-default btn-xs butt_otpr" rel="IK/${pogr.id}" type="button" data-toggle="tooltip" data-placement="right" title="Оформление Отправки">
                                        <span class="glyphicon glyphicon-road"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty pogruzkaIKNaLiniiList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
</div>