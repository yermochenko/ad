<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Ошибка приложения">
    <c:choose>
        <c:when test="${not empty pageContext.exception}">
            <H2>Ошибка работы с базой данных</H2>
            <P>Обратитесь к системному администратору</P>
        </c:when>
        <c:otherwise>
            <H2>Непредвиденная ошибка приложения</H2>
            <P>Обратитесь к системному администратору</P>
        </c:otherwise>
    </c:choose>
</u:html>