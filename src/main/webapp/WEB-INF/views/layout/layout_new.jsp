<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="ru.solicom.zavod.domain.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>

    <!-- Bootstrap -->
    <script src="<c:url value="/resources/js/bootstrap_base/jquery.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/moment-with-locales.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/bootstrap-datetimepicker.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/dataTables.bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <script src="<c:url value="/resources/js/sbit/tab_pogr.js"/>"></script>
    <script src="<c:url value="/resources/js/sbit/tab_sert.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.mmenu.min.all.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap_base/bootstrapValidator.js"/>"></script>
    <script src="<c:url value="/resources/js/json.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.behavior.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap-select.min.js"/>"></script>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/demo.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/jquery.mmenu.all.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrapValidator.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-select.min.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <![endif]-->

    <script type="text/javascript">
        $(function () {
            $('nav#menu').mmenu({
                extensions: ['effect-slide-menu', 'pageshadow', 'pagedim-black']
            });
        });
    </script>

</head>
<body>
<div id="page">
    <div class="modal fade bs-example-modal-sm" id="myModal_2" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel"
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

    <div class="modal fade bs-example-modal-sm" id="myModal_3" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel"
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
                        <button class="btn btn-default" id="button_submit" type="submit">Войти</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <div class="header">
        <a class="main" href="#menu"></a>

        <div>
            <%
                Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String user = "Здравствуйте, Гость!";
                if (!o.toString().equals("anonymousUser")) {
                    user = "Здравствуйте, " + ((User) o).getObrashenie();
                }
            %>
            <%=user%>
            <sec:authorize access="isAnonymous()">
                <a class="login" href="#" onclick="login()">Войти</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a class="login" href="<c:url value="/j_spring_security_logout"/>">Выйти</a>
            </sec:authorize>
        </div>
    </div>
    <div class="content">
        <div class="container">
            <div class="row">
                <div id="content" class="col-lg-12">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <tiles:insertAttribute name="footer"/>
                </div>
            </div>
        </div>
    </div>
    <nav id="menu">
        <ul>
            <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/home_ajax')">Домой</a></li>
            <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/sbit')">Сбыт</a>
                <ul>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/rod_vagona/all')">Род Вагона</a></li>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/vagon/all')">Вагоны</a></li>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/vagon/poroznieAll')">Порожние вагоны на линии</a></li>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/station/all')">Железнодорожные Станции</a></li>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/pokupatel/all')">Получатели</a></li>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/sertificat/all')">Сертификаты</a></li>
                    <li><a href="#" onclick="showSbit('${pageContext.request.contextPath}/pogruzka/all/0')">Погрузка</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/report" target="_blank">Сбыт</a></li>
        </ul>
    </nav>
</div>
</body>
</html>