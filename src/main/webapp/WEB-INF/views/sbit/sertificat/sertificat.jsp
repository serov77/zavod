<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div>

<div class="panel-group" id="accordion">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Сертификаты на известь
                    комовую</a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIKList}">
                    <jsp:include page="sertificatIK/table_sertificatIK.jsp"/>
                </c:if>
                <c:if test="${empty sertificatIKList}">
                    <h3>Нет Данных</h3>
                </c:if>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add" type="button">Добавить Сертификат</button>
                </div>
            </div>

        </div>
    </div>
    <!-- 2 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 2 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Сертификаты на известь
                    молотую</a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatIMList}">
                    <jsp:include page="SertificatIM/table_sertificatIM.jsp"/>
                </c:if>
                <c:if test="${empty sertificatIMList}">
                    <h3>Нет Данных</h3>
                </c:if>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add" type="button">Добавить Сертификат</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 3 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 3 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Сертификаты на минеральный порошок неактивированный</a>
            </h4>
        </div>
        <div id="collapseThree" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <c:if test="${!empty sertificatMPNList}">
                    <jsp:include page="SertificatMPN/table_sertificatMPN.jsp"/>
                </c:if>
                <c:if test="${empty sertificatMPNList}">
                    <h3>Нет Данных</h3>
                </c:if>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add" type="button">Добавить Сертификат</button>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/sbit/sertificat/table_sertificat.js"/>"></script>
</div>
