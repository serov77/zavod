<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3>Таблица "Сертификаты на Известь Молотую"</h3>
</br>
<div class="panel-group" id="accordion_5">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion_5" href="#collapseOne_5">Сетрификаты использованые</a>
            </h4>
        </div>
        <div id="collapseOne_5" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIMList}">
                    <table id="sertificatsIM"
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
                            <th>Угл., %</th>
                            <td>Сито 0.2 мм</td>
                            <td>Сито 0.08 мм</td>
                            <th>Прим.</th>
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
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="IM/${sertificat.id}" type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatIMList}">
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
                <a data-toggle="collapse" data-parent="#accordion_6" href="#collapseOne_6">Сетрификаты не использованые</a>
            </h4>
        </div>
        <div id="collapseOne_6" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIMNeIspList}">
                    <table id="sertificatsIMNeIsp"
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
                            <th>Угл., %</th>
                            <td>Сито 0.2 мм</td>
                            <td>Сито 0.08 мм</td>
                            <th>Прим.</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatIMNeIspList}" var="sertificat">
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
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="IM/${sertificat.id}" type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatIMNeIspList}">
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
                <a data-toggle="collapse" data-parent="#accordion_7" href="#collapseOne_7">Сетрификаты без получателя</a>
            </h4>
        </div>
        <div id="collapseOne_7" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIMBezPoluchatelyaList}">
                    <table id="sertificatsIMBezPol"
                           class="table table-bordered table-hover table-striped table-condensed display">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>№</th>
                            <th>Дата</th>
                            <th>CaO + MgO, %</th>
                            <th>Время гашения</th>
                            <th>Темп. гашения</th>
                            <th>Угл., %</th>
                            <td>Сито 0.2 мм</td>
                            <td>Сито 0.08 мм</td>
                            <th>Прим.</th>
                            <th>Опции</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sertificatIMBezPoluchatelyaList}" var="sertificat">
                            <tr class="t_${sertificat.id}">
                                <td>${sertificat.id}</td>
                                <td>${sertificat.nomer}</td>
                                <td><fmt:formatDate value="${sertificat.data}" pattern="dd.MM.yyyy"/></td>
                                <td>${sertificat.aktivnost}</td>
                                <td>${sertificat.vremyaGascheniya}</td>
                                <td>${sertificat.temperaturaGascheniya}</td>
                                <td>${sertificat.soderUglekisloti}</td>
                                <td>${sertificat.sito02}</td>
                                <td>${sertificat.sito008}</td>
                                <td>${sertificat.otmetki}</td>
                                <td>
                                    <button class="btn btn-default btn-xs butt_sertifikat" rel="IM/${sertificat.id}" type="button">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty sertificatIMBezPoluchatelyaList}">
                    <h3>Нет Данных</h3>
                </c:if>
            </div>
        </div>
    </div>
</div>
