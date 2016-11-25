<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Вагон</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: editPorozniy();"
               commandName="vagonPorozniy">
    <div class="modal-body" id="mesto_body">
        <h3>${title_modal}</h3>
        </br>
        <div class="form-group">
            <form:label path="vagon.nomerVagona" class="col-xs-4 control-label">Номер вагона</form:label>
            <div class="col-xs-8">
                <form:input path="vagon.nomerVagona" class="form-control" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="vagon.rodVagona.name" class="col-xs-4 control-label">Род вагона</form:label>
            <div class="col-xs-8">
                <form:input path="vagon.rodVagona.name" class="form-control" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="gruz.name" class="col-xs-4 control-label">Груз</form:label>
            <div class="col-xs-8">
                <form:select path="gruz.id" id="gruz" class="form-control selectpicker show-tick">
                    <form:options items="${gruzList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label path="dataPribitiya" class="col-xs-4 control-label">Дата прибытия</form:label>
            <div class="col-xs-8">
                <input id="data_pribitiya_hide" type="hidden"
                       value="<joda:format value="${vagonPorozniy.dataPribitiya}" pattern="yyyy-MM-dd"/>">
                <div class="input-group date" id="datetimepicker3">
                    <input type="text" class="form-control" id="dtpdp" readonly="readonly"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <div class="form-group" id="ns_grour">
            <form:label path="nomerSvidetelstva" class="col-xs-4 control-label">Номер свидетельства</form:label>
            <div class="col-xs-8">
                <form:input path="nomerSvidetelstva" class="form-control" oninput="Ftest (this)"/>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
        </div>
        </form:form>
    </div>
    <script src="<c:url value="/resources/js/sbit/vagoni_poroznie/vagon_porozniy.js"/>"></script>
    <script type="text/javascript">
        var vagonPorozniyJSON = ${vagoniPoroznieJSON};
    </script>
    <!--<script type="text/javascript">
        function Ftest(obj) {
            if (this.ST) return;
            var ov = obj.value;
            var ovrl = ov.replace(/\d*/, '').length;
            this.ST = true;
            if (ovrl > 0) {
                obj.value = obj.lang;
                Fshowerror(obj);
                return;
            }
            obj.lang = obj.value;
            this.ST = null;
        }

        function Fshowerror(obj) {
            if (!this.OBJ) {
                this.OBJ = obj;
                obj.style.backgroundColor = 'pink';
                this.TIM = setTimeout(Fshowerror, 100)
            }
            else {
                this.OBJ.style.backgroundColor = '';
                clearTimeout(this.TIM);
                this.ST = null;
                Ftest(this.OBJ);
                this.OBJ = null
            }
        }
    </script>-->