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
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Погружено извести комовой</a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse">
            <!-- Содержимое 1 панели -->
            <div class="panel-body">
                <jsp:include page="pogruzkaIK/table_pogruzkaIK.jsp"/>
            </div>
        </div>
    </div>
    <!-- 2 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 2 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Погружено извести молотой</a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
            <!-- Содержимое 2 панели -->
            <div class="panel-body">
                <jsp:include page="pogruzkaIM/table_pogruzkaIM.jsp"/>
            </div>
        </div>
    </div>
    <!-- 3 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 3 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseFri">Погружено Минерального Порошка Неактивированного</a>
            </h4>
        </div>
        <div id="collapseFri" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <jsp:include page="pogruzkaMPN/table_pogruzkaMPN.jsp"/>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/sbit/pogruzka/table_pogruzka.js"/>"></script>
</div>
