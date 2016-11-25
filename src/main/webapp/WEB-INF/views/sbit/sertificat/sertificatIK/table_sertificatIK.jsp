<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Сертификаты на Известь Комовую"</h3>
</br>
<div class="panel-group" id="accordion_2">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_ik_2" data-toggle="collapse" data-parent="" href="#collapseOne_2">Сетрификаты
                    использованые</a>
            </h4>
        </div>
        <div id="collapseOne_2" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIKList}">
                    <table id="sertificatsIK"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№</th>
                            <th>Покупатель</th>
                            <th>Дата</th>
                            <th>CaO + MgO, %</th>
                            <th>Время гашения</th>
                            <th>Темп. гашения</th>
                            <th>Непог. зерна, %</th>
                            <th>Угл., %</th>
                            <th>Прим.</th>
                            <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                <th>Опции</th>
                            </sec:authorize>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatIKList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td>${sertificat.pokupatel.name}, ${sertificat.station.name}</td>
                                <td><joda:format value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.aktivnost}</td>
                                <td>${sertificat.vremyaGascheniya}</td>
                                <td>${sertificat.temperaturaGascheniya}</td>
                                <td>${sertificat.soderNepogZeren}</td>
                                <td>${sertificat.soderUglekisloti}</td>
                                <td>${sertificat.otmetki}</td>
                                <sec:authorize access="hasAnyRole('ROLE_ADMIN, MASTER_POGRUZKI')">
                                    <td>
                                        <c:if test="${sertificat.data==data}">
                                            <button class="btn btn-default btn-xs butt_sertifikat"
                                                    rel="IK/${sertificat.id}"
                                                    type="button">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </button>
                                        </c:if>
                                        <c:if test="${sertificat.data!=data}">
                                            <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                                                <button class="btn btn-default btn-xs butt_sertifikat"
                                                        rel="IK/${sertificat.id}"
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
                <c:if test="${empty sertificatIKList}">
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
                <a id="sert_ik_3" data-toggle="collapse" data-parent="" href="#collapseOne_3">Сетрификаты не
                    использованые</a>
            </h4>
        </div>
        <div id="collapseOne_3" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIKNeIspList}">
                    <table id="sertificatsIKNeIsp"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№</th>
                            <th>Покупатель</th>
                            <th>Дата</th>
                            <th>CaO + MgO, %</th>
                            <th>Время гашения</th>
                            <th>Темп. гашения</th>
                            <th>Непог. зерна, %</th>
                            <th>Угл., %</th>
                            <th>Прим.</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatIKNeIspList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td>${sertificat.pokupatel.name}, ${sertificat.station.name}</td>
                                <td><joda:format value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.aktivnost}</td>
                                <td>${sertificat.vremyaGascheniya}</td>
                                <td>${sertificat.temperaturaGascheniya}</td>
                                <td>${sertificat.soderNepogZeren}</td>
                                <td>${sertificat.soderUglekisloti}</td>
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="IK/${sertificat.id}"
                                            type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatIKNeIspList}">
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
                <a id="sert_ik_4" data-toggle="collapse" data-parent="" href="#collapseOne_4">Сетрификаты без
                    получателя</a>
            </h4>
        </div>
        <div id="collapseOne_4" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIKBezPoluchatelyaList}">
                    <table id="sertificatIKBezPol"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№</th>
                            <th>Дата</th>
                            <th>CaO + MgO, %</th>
                            <th>Время гашения</th>
                            <th>Темп. гашения</th>
                            <th>Непог. зерна, %</th>
                            <th>Угл., %</th>
                            <th>Прим.</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatIKBezPoluchatelyaList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td><joda:format value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.aktivnost}</td>
                                <td>${sertificat.vremyaGascheniya}</td>
                                <td>${sertificat.temperaturaGascheniya}</td>
                                <td>${sertificat.soderNepogZeren}</td>
                                <td>${sertificat.soderUglekisloti}</td>
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="IK/${sertificat.id}"
                                            type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatIKBezPoluchatelyaList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
</div>