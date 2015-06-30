<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav role="navigation" class="navbar navbar-default">	
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}">ОАО "СолИКом"</a>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav main-menu-a-1">
            <li id="li1"><a href="${pageContext.request.contextPath}/sbit">Сбыт</a></li>
            <li id="li2"><a href="#">Пункт 2</a></li>
            <li id="li3"><a href="#">Пункт 3</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#" onclick="login()">Войти</a></li>
        </ul>
    </div>
</nav>
          



