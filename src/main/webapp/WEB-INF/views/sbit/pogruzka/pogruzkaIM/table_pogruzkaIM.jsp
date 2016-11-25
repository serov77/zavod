<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Погрузка Вагонов Известью Молотой"</h3>
</br>
<div class="panel-group" id="accordion_4">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="im_2" class="pogr_main" data-toggle="collapse" data-parent="" href="#collapseOne_4">Вагоны извести молотой
                    отправленные</a>
            </h4>
        </div>
        <div id="collapseOne_4" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty pogruzkaIMList}">
                    <table id="pogruzkaIM"
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
                        <c:forEach items="${pogruzkaIMList}" var="pogr">
                            <tr id="tim_${pogr.id}">
                                <td class="id_pogruzkaIM nomer_vagonaIM">${pogr.id}</td>
                                <td class="nomer_vagonaIM">${pogr.vagon.nomerVagona}</td>
                                <td hidden="hidden">${pogr.vagon.tara}</td>
                                <td class="nomer_vagonaIM"><fmt:formatNumber value="${pogr.brutto}" type="number"
                                                                             pattern="0.0"/></td>
                                <td class="nomer_vagonaIM"><fmt:formatNumber value="${pogr.brutto - pogr.vagon.tara}"
                                                                             type="number"
                                                                             pattern="0.0"/></td>
                                <td class="nomer_vagonaIM"><joda:format value="${pogr.dataPogruzki}"
                                                                        pattern="dd.MM.yyyy"/></td>
                                <td class="nomer_vagonaIM dataOtpravleniya"><joda:format
                                        value="${pogr.dataOtpravleniya}" pattern="dd.MM.yyyy"/></td>
                                <td class="nomer_vagonaIM">${pogr.tara.name}</td>
                                <td class="nomer_vagonaIM">${pogr.sertificatIM.pokupatel.name}, ${pogr.sertificatIM.station.name}</td>
                                <td class="nomer_vagonaIM">${pogr.dopolneniya}</td>
                                <td>
                                    <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                        <button class="btn btn-default btn-xs butt_pogr_edit" rel="IM/${pogr.id}"
                                                type="button"
                                                data-toggle="tooltip" data-placement="right"
                                                title="Редактирование Погрузки">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </sec:authorize>
                                    <c:if test="${pogr.dataOtpravleniya==data}">
                                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                                            <button class="btn btn-default btn-xs butt_otmena" rel="IM/${pogr.id}"
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
                        <div id="kolIM"></div>
                        <button class="btn btn-info btn-lg butt_print" rel="IM" type="button">Печать документов</button>
                    </div>
                </c:if>
                <c:if test="${empty pogruzkaIMList}">
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
                <a  id="im_3" class="pogr_main" data-toggle="collapse" data-parent="" href="#collapseOne_5">Вагоны извести молотой на
                    линии</a>
            </h4>
        </div>
        <div id="collapseOne_5" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <c:if test="${!empty pogruzkaIMNaLiniiList}">
                    <table id="pogruzkaIM_2"
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
                        <c:forEach items="${pogruzkaIMNaLiniiList}" var="pogr">
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
                                        <button class="btn btn-default btn-xs butt_pogr_edit" rel="IM/${pogr.id}"
                                                type="button"
                                                data-toggle="tooltip" data-placement="right"
                                                title="Редактирование Погрузки">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                        <button id="butt_otpr_im" class="btn btn-default btn-xs" rel="IM/${pogr.id}"
                                                type="button"
                                                data-toggle="tooltip" data-placement="right"
                                                title="Оформление Отправки">
                                            <span class="glyphicon glyphicon-road"></span>
                                        </button>
                                        <button class="btn btn-default btn-xs butt_otmena_pogr_IM"
                                                rel="IM/${pogr.nomerOtpravki}/${pogr.vagonPorozniy.id}"
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
                <c:if test="${empty pogruzkaIMNaLiniiList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
</div>