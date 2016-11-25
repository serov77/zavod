<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="modal-content">
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h4 class="modal-title" id="myModalLabel">Погрузка</h4>
</div>
<form:form id="edit_form" class="form-horizontal" method="post"
           action="javascript: edit_pogr_add();"
           commandName="pogruzka">
    <div class="modal-body" id="mesto_body">
        <h3>${title_modal}</h3>
        </br>
        <div class="form-group">
            <form:label path="vagon.nomerVagona" class="col-xs-4 control-label">Номер Вагона</form:label>
            <div class="col-xs-8">
                <form:input path="vagon.nomerVagona" class="form-control" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="vagon.rodVagona.name" class="col-xs-4 control-label">Род Вагона</form:label>
            <div class="col-xs-8">
                <form:input path="vagon.rodVagona.name" class="form-control" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="vagon.tara" class="col-xs-4 control-label">Тара Вагона, т.</form:label>
            <div class="col-xs-8">
                <form:input id="taraVag" path="vagon.tara" class="form-control" readonly="true"/>
                <form:hidden id="idVag" path="vagon.id" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="vagon.gruzopodyomnost"
                        class="col-xs-4 control-label">Грузоподъемность Вагона, т.</form:label>
            <div class="col-xs-8">
                <form:input path="vagon.gruzopodyomnost" class="form-control" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="gruz" class="col-xs-4 control-label">Груз</form:label>
            <div class="col-xs-8">
                <form:select path="gruz.id" id="gruz" data-live-search="true" class="form-control selectpicker show-tick">
                    <form:option value="0" label=""/>
                    <form:options items="${gruzList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label path="tara" class="col-xs-4 control-label">Упаковка</form:label>
            <div class="col-xs-8">
                <form:select path="tara.id" id="tara" class="form-control selectpicker show-tick">
                    <form:options items="${taraList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label path="brutto" class="col-xs-4 control-label">Вес брутто, т.</form:label>
            <div class="col-xs-8">
                <form:input path="brutto" class="form-control" oninput="Ftest_pogr_add (this)"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="netto" class="col-xs-4 control-label">Вес нетто, т.</form:label>
            <div class="col-xs-8">
                <form:input path="netto" class="form-control" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="dopolneniya" class="col-xs-4 control-label">Дополнительные отметки</form:label>
            <div class="col-xs-8">
                <form:textarea path="dopolneniya" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="dataPribitiyaVagona" class="col-xs-4 control-label">Дата прибытия вагона</form:label>
            <div class="col-xs-8">
                <form:input path="dataPribitiyaVagona" class="form-control" readonly="true"/>
            </div>
        </div>
        <input id="idPorozniy" hidden="hidden" value="${pogruzka.vagonPorozniy.id}"/>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
        <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
    </div>
    </div>
</form:form>

</div>
<script src="<c:url value="/resources/js/sbit/pogruzka/pogruzka_add.js"/>"></script>
<script type="text/javascript">
    var pogruzkaJSON2 = ${pogruzkaJSON};
</script>
<script type="text/javascript">
    function Ftest_pogr_add(obj) {
        var c = obj.value;
        c = c.replace(/,/, '.');
        obj.value = c;
        if (this.ST) return;
        var ov = obj.value;
        var ovrl = ov.replace(/\d*\.?\d*/, '').length;
        this.ST = true;
        if (ovrl > 0) {
            obj.value = obj.lang;
            Fshowerror(obj);
            return;
        }
        obj.lang = obj.value;
        this.ST = null;
        var tara = $("input#taraVag").val();
        var brutto = $("input#brutto").val();
        var x = (brutto - tara).toFixed(1);
        $("input#netto").val(x);
    }

    function Fshowerror(obj) {
        if (!this.OBJ) {
            this.OBJ = obj;
            obj.style.backgroundColor = 'pink';
            this.TIM = setTimeout(Fshowerror, 50)
        }
        else {
            this.OBJ.style.backgroundColor = '';
            clearTimeout(this.TIM);
            this.ST = null;
            Ftest(this.OBJ);
            this.OBJ = null
        }
    }
</script>
