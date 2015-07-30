<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<select class="form-control">
  <option value="0"></option>
  <c:forEach items="${sertificatList}" var="sert">
    <option value="${sert.id}">${sert.nomer}</option>
  </c:forEach>
</select>