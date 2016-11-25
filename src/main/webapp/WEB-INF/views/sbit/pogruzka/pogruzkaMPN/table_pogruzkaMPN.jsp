<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Погрузка Вагонов Минеральным Порошком Неактивированным"</h3>
</br>
<div class="panel-group" id="accordion_6">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="mpn_2" class="pogr_main" data-toggle="collapse" data-parent="" href="#collapseOne_6">Вагоны минерального порошка
                    неактивированного отправленные</a>
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
                            <td hidden="hidden">Тара</td>
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
                        <c:forEach items="${pogruzkaMPNList}" var="pogr">
                            <tr id="tmpn_${pogr.id}">
                                <td class="id_pogruzkaMPN nomer_vagonaMPN">${pogr.id}</td>
                                <td class="nomer_vagonaMPN">${pogr.vagon.nomerVagona}</td>
                                <td class="nomer_vagonaMPN"><fmt:formatNumber value="${pogr.brutto}" type="number"
                                                                              pattern="0.0"/></td>
                                <td hidden="hidden">${pogr.vagon.tara}</td>
                                <td class="nomer_vagonaMPN"><fmt:formatNumber value="${pogr.brutto - pogr.vagon.tara}"
                                                                              type="number" pattern="0.0"/></td>
                                <td class="nomer_vagonaMPN"><joda:format value="${pogr.dataPogruzki}"
                                                                         pattern="dd.MM.yyyy"/></td>
                                <td class="nomer_vagonaMPN dataOtpravleniya"><joda:format
                                        value="${pogr.dataOtpravleniya}"
                                        pattern="dd.MM.yyyy"/></td>
                                <td class="nomer_vagonaMPN">${pogr.tara.name}</td>
                                <td class="nomer_vagonaMPN">${pogr.sertificatMPN.pokupatel.name}, ${pogr.sertificatMPN.station.name}</td>
                                <td class="nomer_vagonaMPN">${pogr.dopolneniya}</td>
                                <td>
                                    <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                        <button class="btn btn-default btn-xs butt_pogr_edit" rel="MPN/${pogr.id}"
                                                type="button" data-toggle="tooltip" data-placement="right"
                                                title="Редактирование Погрузки">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </sec:authorize>
                                    <c:if test="${pogr.dataOtpravleniya==data}">
                                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                                            <button class="btn btn-default btn-xs butt_otmena" rel="MPN/${pogr.id}"
                                                    type="button"
                                                    data-toggle="tooltip" data-placement="right"
                                                    title="Отмена оформления документов">
                                                <span class="glyphicon glyphicon-road"></span>
                                            </button>
                                        </sec:authorize>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="block printIK">

                    </div>
                    <div class="block">
                        <div id="kolMPN"></div>
                        <button class="btn btn-info btn-lg butt_print" rel="MPN" type="button">Печать документов
                        </button>
                    </div>
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
                <a id="mpn_3" class="pogr_main" data-toggle="collapse" data-parent="" href="#collapseOne_7">Вагоны минерального порошка
                    неактивированного на линии</a>
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
                            <th>Прибыл</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pogruzkaMPNNaLiniiList}" var="pogr">
                            <tr class="t_${pogr.id}">
                                <td>${pogr.id}</td>
                                <td>${pogr.vagon.nomerVagona}</td>
                                <td><fmt:formatNumber value="${pogr.brutto}" type="number" pattern="0.0"/></td>
                                <td><fmt:formatNumber value="${pogr.brutto - pogr.vagon.tara}" type="number"
                                                      pattern="0.0"/></td>
                                <td><joda:format value="${pogr.dataPogruzki}" pattern="dd.MM.yyyy"/></td>
                                <td>${pogr.tara.name}</td>
                                <td>${pogr.dopolneniya}</td>
                                <td><joda:format value="${pogr.dataPribitiyaVagona}" pattern="dd.MM.yyyy"/></td>
                                <td>
                                    <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                        <button class="btn btn-default btn-xs butt_pogr_edit" rel="MPN/${pogr.id}"
                                                type="button" data-toggle="tooltip" data-placement="right"
                                                title="Редактирование Погрузки">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                        <button class="btn btn-default btn-xs butt_otpr_mpn" rel="MPN/${pogr.id}"
                                                type="button"
                                                data-toggle="tooltip" data-placement="right"
                                                title="Оформление Отправки">
                                            <span class="glyphicon glyphicon-road"></span>
                                        </button>
                                        <button class="btn btn-default btn-xs butt_otmena_pogr_MPN"
                                                rel="MPN/${pogr.nomerOtpravki}/${pogr.vagonPorozniy.id}"
                                                type="button"
                                                data-toggle="tooltip" data-placement="right"
                                                title="Отмена погрузки вагона">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </button>
                                    </sec:authorize>
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