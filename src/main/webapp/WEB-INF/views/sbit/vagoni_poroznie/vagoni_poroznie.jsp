<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="mesto">
    </div>
</div>
<h3>Таблица "Порожние вагоны на линии" (Всего вагонов: ${vagoniPoroznieList.size()})</h3>
</br>
<div class="row">
<div class="col-xs-4">

</div>
<form action="${pageContext.request.contextPath}/vagon/pechat_nomera_svidetelstv" target="_blank">
    <div class="col-xs-4">
        </br>
        <div>
            <button class="btn btn-info btn-lg" type="submit" formmethod="post">Печатать номера свидетельств
            </button>
        </div>
        <div>

        </div>
    </div>
</form>
<div class="col-xs-4">

</div>
</div>
<c:if test="${!empty vagoniPoroznieList}">
    <jsp:include page="table_vagoni_poroznie.jsp"/>
</c:if>
<c:if test="${empty vagoniPoroznieList}">
    <h3>Нет Данных</h3>
</c:if>
</br>
<div class="row">
    <div class="col-xs-4">

    </div>
    <form action="${pageContext.request.contextPath}/vagon/pechat_zayavki" target="_blank">
        <div class="col-xs-4">
            <div class="input-group date" id="dtp_data_zayavki">
                <input type="text" class="form-control" id="dtp_d_z" name="data_zayavki" readonly="readonly"/>
                    <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                    </span>
            </div>
            </br>
            <div>
                <button class="btn btn-info btn-lg" type="submit" formmethod="post">Печать заявки
                </button>
            </div>
            <div>

            </div>
        </div>
    </form>
    <div class="col-xs-4">

    </div>
</div>



<script src="<c:url value="/resources/js/sbit/vagoni_poroznie/table_vagoni_poroznie.js"/>"></script>

