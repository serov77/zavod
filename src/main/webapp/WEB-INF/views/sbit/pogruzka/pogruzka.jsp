<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<div class="modal fade" id="myModal" tabindex="1000" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div>
<div class="block left_button">
    <button class="btn btn-info btn-lg butt_statistica" onclick="showSbit('/zavod/pogruzka/statistica')" rel=""
            type="button">
        Статистика по погрузке
    </button>
</div>


</br>
<div class="row">
    <div style="width: inherit" class="col-md-4 col-md-offset-4">
        <h3 style="margin-top: 5px">Таблица "Погрузка"${zaPeriod} </h3>
        </div>
    <div class="col-md-2">
        <select id="period" class="selectpicker">
            <option value="1">За день</option>
            <option value="2">За месяц</option>
            <option value="3">За год</option>
        </select>
        <script>
            $("#period [value='${period}']").attr("selected", "selected");
        </script>
    </div>
</div>
</br>


<div class="panel-group" id="accordion_pogr">


    <!-- 1 панель -->
    <div class="panel panel-default">

        <!-- Заголовок 1 панели -->
        <div class="panel-heading">

            <h4 class="panel-title">

                <a id="ik" class="pogr_main" data-toggle="collapse" data-parent="#accordion_pogr"
                   href="#collapseOne">Погружено
                    извести
                    комовой</a>
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
                <a id="im" class="pogr_main" data-toggle="collapse" data-parent="#accordion_pogr"
                   href="#collapseTwo">Погружено
                    извести молотой</a>
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
                <a id="mpn" class="pogr_main" data-toggle="collapse" data-parent="#accordion_pogr"
                   href="#collapseFri">Погружено
                    Минерального Порошка
                    Неактивированного</a>
            </h4>
        </div>
        <div id="collapseFri" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <jsp:include page="pogruzkaMPN/table_pogruzkaMPN.jsp"/>
            </div>
        </div>
    </div>
    <!-- 4 панель -->
    <div class="panel panel-default">
        <!-- Заголовок 4 панели -->
        <div class="panel-heading">
            <h4 class="panel-title">
                <a id="mpa" class="pogr_main" data-toggle="collapse" data-parent="#accordion_pogr"
                   href="#collapseFo">Погружено
                    Минерального Порошка
                    Aктивированного</a>
            </h4>
        </div>
        <div id="collapseFo" class="panel-collapse collapse">
            <!-- Содержимое 3 панели -->
            <div class="panel-body">
                <jsp:include page="pogruzkaMPA/table_pogruzkaMPA.jsp"/>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/sbit/pogruzka/table_pogruzka.js"/>"></script>
</div>