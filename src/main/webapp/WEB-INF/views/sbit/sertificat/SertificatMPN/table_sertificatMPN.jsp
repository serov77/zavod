<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<h3>Таблица "Сертификаты на Минеральный порошок неактивированный"</h3>
</br>
<div class="panel-group" id="accordion_8">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_mpn_2" data-toggle="collapse" data-parent="" href="#collapseOne_8">Сетрификаты
                    использованые</a>
            </h4>
        </div>
        <div id="collapseOne_8" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatMPNList}">
                    <table id="sertificatsMPN"
                           class="table table-bordered table-hover table-striped table-condensed display">
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
                            <th>Прим.</th>
                            <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                <th>Опции</th>
                            </sec:authorize>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatMPNList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td>${sertificat.pokupatel.name}, ${sertificat.station.name}</td>
                                <td><joda:format value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.massovayaDolyaVlagi}</td>
                                <td>${sertificat.zerovoySostav1250}</td>
                                <td>${sertificat.zerovoySostav0315}</td>
                                <td>${sertificat.zerovoySostav0071}</td>
                                <td>${sertificat.otmetki}</td>
                                <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                    <td>
                                        <c:if test="${sertificat.data==data}">
                                            <button class="btn btn-default btn-xs butt_sertifikat"
                                                    rel="MPN/${sertificat.id}"
                                                    type="button">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </button>
                                        </c:if>
                                        <c:if test="${sertificat.data!=data}">
                                            <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                                                <button class="btn btn-default btn-xs butt_sertifikat"
                                                        rel="MPN/${sertificat.id}"
                                                        type="button">
                                                    <span class="glyphicon glyphicon-pencil"></span>
                                                </button>
                                            </sec:authorize>
                                        </c:if>
                                    </td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatMPNList}">
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
                <a id="sert_mpn_3" data-toggle="collapse" data-parent="" href="#collapseOne_9">Сетрификаты не
                    использованые</a>
            </h4>
        </div>
        <div id="collapseOne_9" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatMPNNeIspList}">
                    <table id="sertificatsMPNNeIsp"
                           class="table table-bordered table-hover table-striped table-condensed display">
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
                            <th>Прим.</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatMPNNeIspList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td>${sertificat.pokupatel.name}, ${sertificat.station.name}</td>
                                <td><joda:format value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.massovayaDolyaVlagi}</td>
                                <td>${sertificat.zerovoySostav1250}</td>
                                <td>${sertificat.zerovoySostav0315}</td>
                                <td>${sertificat.zerovoySostav0071}</td>
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="MPN/${sertificat.id}"
                                            type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatMPNNeIspList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
    <!-- 3 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 3 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_mpn_4" data-toggle="collapse" data-parent="" href="#collapseOne_10">Сетрификаты без
                    получателя</a>
            </h4>
        </div>
        <div id="collapseOne_10" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatMPNBezPoluchatelyaList}">
                    <table id="sertificatsMPNBezPol"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№</th>
                            <th>Дата</th>
                            <th>Влага, %</th>
                            <th>Сито 1.25 мм</th>
                            <th>Сито 0.315 мм</th>
                            <th>Сито 0.071 мм</th>
                            <th>Прим.</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatMPNBezPoluchatelyaList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td><joda:format value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.massovayaDolyaVlagi}</td>
                                <td>${sertificat.zerovoySostav1250}</td>
                                <td>${sertificat.zerovoySostav0315}</td>
                                <td>${sertificat.zerovoySostav0071}</td>
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="MPN/${sertificat.id}"
                                            type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatMPNBezPoluchatelyaList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
</div>
