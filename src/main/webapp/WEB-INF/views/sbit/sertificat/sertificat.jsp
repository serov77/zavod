<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div>

<div class="panel-group" id="accordion_sert">
    <!-- 1 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 1 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_ik" data-toggle="collapse" data-parent="#accordion_sert" href="#collapseOne">Сертификаты на известь
                    комовую</a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <jsp:include page="sertificatIK/table_sertificatIK.jsp"/>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add_sert" type="button" rel="ik">Добавить Сертификат</button>
                </div>
            </div>

        </div>
    </div>
    <!-- 2 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 2 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_im" data-toggle="collapse" data-parent="#accordion_sert" href="#collapseTwo">Сертификаты на известь
                    молотую</a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <jsp:include page="SertificatIM/table_sertificatIM.jsp"/>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add_sert" type="button" rel="im">Добавить Сертификат</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 3 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 3 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_mpn" data-toggle="collapse" data-parent="#accordion_sert" href="#collapseThree">Сертификаты на минеральный
                    порошок неактивированный</a>
            </h4>
        </div>
        <div id="collapseThree" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <jsp:include page="SertificatMPN/table_sertificatMPN.jsp"/>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add_sert" type="button" rel="mpn">Добавить Сертификат</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 4 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 4 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="sert_mpa" data-toggle="collapse" data-parent="#accordion_sert" href="#collapseThree_2">Сертификаты на минеральный
                    порошок активированный</a>
            </h4>
        </div>
        <div id="collapseThree_2" class="panel-collapse collapse">
            <!-- Содержимое 4 панели -->
            <div class="panel-body">
                <jsp:include page="sertificatMPA/table_sertificatMPA.jsp"/>
                <div class="block">
                    <button class="btn btn-info btn-lg butt_add_sert" type="button" rel="mpa">Добавить Сертификат</button>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/sbit/sertificat/table_sertificat.js"/>"></script>
</div>
