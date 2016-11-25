<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="form-group">
    <label path="station" class="col-xs-4 control-label">Станция назначения</label>
    <div class="col-xs-8">
        <c:if test="${empty pokupatelStations}">
            <input class="form-control" readonly="readonly" value="Нет"/>
            <script>stationID = 1;</script>
        </c:if>
        <c:if test="${!empty pokupatelStations}">
            <c:if test="${stationSize == 1}">
                <c:forEach items="${pokupatelStations}" var="station">
                    <input id="xxx" class="form-control" readonly="readonly" rel="${station.id}"
                           value="${station.name}"/>
                </c:forEach>
                <script>
                    $(document).ready(function () {
                        stationID = $('#xxx').attr('rel');
                        //$('#xy').val($('#xxx').attr('rel'));
                    })
                </script>
            </c:if>
            <c:if test="${stationSize > 1}">
                <select id="yyy" class="form-control show-tick" name="statId">
                    <c:forEach items="${pokupatelStations}" var="station">
                        <option value="${station.id}">${station.name}</option>
                    </c:forEach>
                </select>
                <script>stationID = $('select#yyy option:selected').val()</script>
            </c:if>
        </c:if>
    </div>

</div>
<input type="hidden" id="xy" hidden="hidden" value="">
<script>
    $('#yyy').selectpicker({});
    var stationID;
    $('#yyy').on('changed.bs.select', function (e) {
        //alert($(this).selectpicker('val'));
        stationID = $(this).selectpicker('val');
    })
</script>