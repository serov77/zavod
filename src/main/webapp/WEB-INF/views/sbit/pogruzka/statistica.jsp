<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="block left_button">
    <button class="btn btn-info btn-lg butt_statistica_nazad"
            onclick="showSbit('${pageContext.request.contextPath}/pogruzka/all/0')" rel="" type="button">
        Назад
    </button>
</div>

<h1>Погружено вагонов за период с <joda:format
        value="${data_1}" pattern="dd.MM.yyyy"/> по <joda:format
        value="${data_2}" pattern="dd.MM.yyyy"/></h1>
</br>
<c:if test="${listIK.size()>0}">
    <h3>Известь Комовая</h3>
</c:if>
<c:set var="x" value=""/>
<c:set var="summa" value="0"/>
<% int u = 0; %>
<table>
    <c:forEach items="${listIK}" var="pogr" varStatus="number">
        <tr>
            <c:if test="${x == pogr.sertificatIK.pokupatel.id}">
                <% u = u + 1; %>
                <div hidden="hidden">${summa = summa + pogr.brutto - pogr.vagon.tara}</div>
            </c:if>
            <c:if test="${x != pogr.sertificatIK.pokupatel.id}">
                <c:if test="${!number.isFirst()}">
                    <td>
                        <div>Вагонов погружено: <%= u %>
                        </div>
                    </td>
                    <td>
                        <div>Тонн погружено: <fmt:formatNumber value="${summa}" type="number" pattern="0.0"/></div>
                    </td>
                </c:if>
                <div hidden="hidden">${x=pogr.sertificatIK.pokupatel.id}</div>
                <td>
                    <h4>${pogr.sertificatIK.pokupatel.name}</h4>
                </td>
                <% u = 1; %>
                <div hidden="hidden">${summa = pogr.brutto - pogr.vagon.tara}</div>
            </c:if>
            <c:if test="${number.isLast()}">
                <td>
                    <div>Вагонов погружено: <%= u %>
                    </div>
                </td>
                <td>
                    <div>Тонн погружено: <fmt:formatNumber value="${summa}" type="number" pattern="0.0"/></div>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>

</br>
<c:if test="${listIM.size()>0}">
    <h3>Известь Молотая</h3>
</c:if>
<c:set var="x1" value=""/>
<c:set var="summa1" value="0"/>
<% int u1 = 0; %>
<c:forEach items="${listIM}" var="pogr" varStatus="number">
    <c:if test="${x == pogr.sertificatIM.pokupatel.id}">
        <% u1 = u1 + 1; %>
        <div hidden="hidden">${summa1 = summa1 + pogr.brutto - pogr.vagon.tara}</div>
    </c:if>
    <c:if test="${x != pogr.sertificatIM.pokupatel.id}">
        <c:if test="${!number.isFirst()}">
            <div>Вагонов погружено: <%= u1 %>
            </div>
            <div>Тонн погружено: <fmt:formatNumber value="${summa1}" type="number" pattern="0.0"/></div>
        </c:if>
        <div hidden="hidden">${x=pogr.sertificatIM.pokupatel.id}</div>
        <h1>${pogr.sertificatIM.pokupatel.name}</h1>
        <% u1 = 1; %>
        <div hidden="hidden">${summa1 = pogr.brutto - pogr.vagon.tara}</div>
    </c:if>
    <c:if test="${number.isLast()}">
        <div>Вагонов погружено: <%= u1 %>
        </div>
        <div>Тонн погружено: <fmt:formatNumber value="${summa1}" type="number" pattern="0.0"/></div>
    </c:if>

</c:forEach>


</br>
<c:if test="${listMPN.size()>0}">
    <h3>Минеральный порошок неактивированный</h3>
</c:if>
<c:set var="x2" value=""/>
<c:set var="summa2" value="0"/>
<% int u2 = 0; %>
<c:forEach items="${listMPN}" var="pogr" varStatus="number">
    <c:if test="${x == pogr.sertificatMPN.pokupatel.id}">
        <% u2 = u2 + 1; %>
        <div hidden="hidden">${summa2 = summa2 + pogr.brutto - pogr.vagon.tara}</div>
    </c:if>
    <c:if test="${x2 != pogr.sertificatMPN.pokupatel.id}">
        <c:if test="${!number.isFirst()}">
            <div>Вагонов погружено: <%= u2 %>
            </div>
            <div>Тонн погружено: <fmt:formatNumber value="${summa2}" type="number" pattern="0.0"/></div>
        </c:if>
        <div hidden="hidden">${x=pogr.sertificatMPN.pokupatel.id}</div>
        <h1>${pogr.sertificatMPN.pokupatel.name}</h1>
        <% u2 = 1; %>
        <div hidden="hidden">${summa2 = pogr.brutto - pogr.vagon.tara}</div>
    </c:if>
    <c:if test="${number.isLast()}">
        <div>Вагонов погружено: <%= u2 %>
        </div>
        <div>Тонн погружено: <fmt:formatNumber value="${summa2}" type="number" pattern="0.0"/></div>
    </c:if>

</c:forEach>


</br>
<c:if test="${listMPA.size()>0}">
    <h3>Минеральный порошок активированный</h3>
</c:if>
<c:set var="x3" value=""/>
<c:set var="summa3" value="0"/>
<% int u3 = 0; %>
<c:forEach items="${listMPA}" var="pogr" varStatus="number">
    <c:if test="${x == pogr.sertificatMPA.pokupatel.id}">
        <% u3 = u3 + 1; %>
        <div hidden="hidden">${summa3 = summa3 + pogr.brutto - pogr.vagon.tara}</div>
    </c:if>
    <c:if test="${x != pogr.sertificatMPA.pokupatel.id}">
        <c:if test="${!number.isFirst()}">
            <div>Вагонов погружено: <%= u3 %>
            </div>
            <div>Тонн погружено: <fmt:formatNumber value="${summa3}" type="number" pattern="0.0"/></div>
        </c:if>
        <div hidden="hidden">${x=pogr.sertificatMPA.pokupatel.id}</div>
        <h1>${pogr.sertificatMPA.pokupatel.name}</h1>
        <% u3 = 1; %>
        <div hidden="hidden">${summa3 = pogr.brutto - pogr.vagon.tara}</div>
    </c:if>
    <c:if test="${number.isLast()}">
        <div>Вагонов погружено: <%= u3 %>
        </div>
        <div>Тонн погружено: <fmt:formatNumber value="${summa3}" type="number" pattern="0.0"/></div>
    </c:if>

</c:forEach>


