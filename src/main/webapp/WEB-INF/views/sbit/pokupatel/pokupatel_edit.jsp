<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Получатель</h4>
    </div>
    <form:form id="edit_form" class="form-horizontal" method="post"
               action="javascript: edit();"
               commandName="pokupatel">
        <div class="modal-body" id="mesto_body">
            <h3>${title_modal}</h3>
            </br>
            <form:hidden path="id" />
            <div class="form-group">
                <form:label path="name" class="col-xs-4 control-label">Название получателя</form:label>
                    <div class="col-xs-8">
                    <form:input path="name" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <form:label path="kod" class="col-xs-4 control-label">Код</form:label>
                    <div class="col-xs-8">
                    <form:input path="kod" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="okpo" class="col-xs-4 control-label">ОКПО</form:label>
                    <div class="col-xs-8">
                    <form:input path="okpo" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="station" class="col-xs-4 control-label">Станция</form:label>
                    <div class="col-xs-8">
                    <form:select path="station.id" id="station" class="form-control">
                        <form:option value="1" label="" />
                        <form:options items="${stationList}" itemValue="id"  itemLabel="name"/>
                    </form:select>
                </div>
            </div>    
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
            </div> 
        </form:form>
    </div>
    <script src="<c:url value="/resources/js/sbit/pokupatel/pokupatel_edit.js"/>"></script>
    <script type="text/javascript">
        var pokupatelJSON = ${pokupatelJSON};
        function Ftest(obj) {
            if (this.ST) return;
            var ov = obj.value;
            var ovrl = ov.replace(/\d*\.?\d*/, '').length;
            this.ST = true;
            if (ovrl > 0) {
                obj.value = obj.lang;
                Fshowerror(obj);
                return
            }
            obj.lang = obj.value;
            this.ST = null;
            var tara = $("input#taraVag").val();
            var brutto = $("input#brutto").val();
            var x = brutto-tara;
            var y = x.toFixed(1);
            $("input#netto").val(y);
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

