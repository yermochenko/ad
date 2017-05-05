<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Специальности">
    <H1>Список специальностей</H1>
    <c:choose>
        <c:when test="${not empty specialties}">
            <u:specialties items="${specialties}"/>
        </c:when>
        <c:otherwise>
            <P>Список специальностей пока пуст</P>
        </c:otherwise>
    </c:choose>
    <c:url var="editUrl" value="/specialty/edit.html"/>
    <FORM action="${editUrl}">
        <BUTTON>Добавить</BUTTON>
    </FORM>
    <c:url var="backUrl" value="/"/>
    <P><A href="${backUrl}">Вернуться на главную страницу</A></P>
</u:html>