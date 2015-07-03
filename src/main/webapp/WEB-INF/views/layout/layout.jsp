<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>

    <!-- Bootstrap -->
    <script src="<c:url value="/resources/js/bootstrap_base/jquery.js"/>"></script>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrapValidator.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/js/bootstrap_base/bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/dataTables.bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/bootstrapValidator.js"/>"></script>
    <script src="<c:url value="/resources/js/json.js"/>"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<div class="modal fade bs-example-modal-sm" id="myModal_2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <div class="modal-body">
                <p>Изменения успешно внесены</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade bs-example-modal-sm" id="myModal_3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <form class="form-horizontal login-form" method="post"
                  action="zavod/j_spring_security_check">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="j_username" class="col-xs-4 control-label">Логин: </label>

                        <div class="col-xs-8">
                            <input id="j_username" name="j_username" class="form-control" type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="j_password" class="col-xs-4 control-label">Пароль: </label>
                        <div class="col-xs-8">
                            <input id="j_password" name="j_password" class="form-control" type="password"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    <button class="btn btn-default" id="button_submit" type="submit">Сохранить изменения</button>
                </div>
            </form>
        </div>
    </div>
</div>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <tiles:insertAttribute name="header"/>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-2">
            <tiles:insertAttribute name="menu"/>
        </div>
        <div id="content" class="col-xs-10">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>
</div>
</body>
</html>