<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="ru.solicom.zavod.domain.User" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page session="false" %>

    <div class="container">
        <!--<div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}">ОАО "СолИКом"</a>
        </div>
        <div id="navbarCollapse" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="li1" class="active"><a href="${pageContext.request.contextPath}/sbit">Сбыт</a></li>
                <li id="li2"><a href="/zavod/report">Пункт 2</a></li>
                <li id="li3"><a href="#">Пункт 3</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%
                    Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    String user = "Вы вошли как Гость";
                    if (!o.toString().equals("anonymousUser")) {
                        user = "Вы вошли как " + ((User) o).getLastName() + " " + ((User) o).getFirstName();
                    }
                %>
                <li><a href="<c:url value="/j_spring_security_logout"/>"><%=user%>
                </a></li>
                <sec:authorize access="isAnonymous()">
                    <li><a href="#" onclick="login()">Войти</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="<c:url value="/j_spring_security_logout"/>">Выйти</a></li>
                </sec:authorize>
            </ul>
        </div>-->
    </div>


          



