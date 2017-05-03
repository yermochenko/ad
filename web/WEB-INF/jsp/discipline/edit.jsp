<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:choose>
    <c:when test="${not empty discipline.id}">
        <c:set var="title" value="Редактирование дисциплины"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Создание дисциплины"/>
    </c:otherwise>
</c:choose>

<u:html title="${title}">
    <H1>${title}</H1>
    <c:url var="saveUrl" value="/discipline/save.html"/>
    <FORM action="${saveUrl}" method="post">
        <c:if test="${not empty discipline.id}">
            <INPUT type="hidden" name="id" value="${discipline.id}">
        </c:if>
        <P>Название</P>
        <P><INPUT type="text" name="name" value="${discipline.name}" required></P>
        <P>Сокращенное название</P>
        <P><INPUT type="text" name="shortname" value="${discipline.shortName}" required></P>
        <P>
            <BUTTON>Сохранить</BUTTON>
            <c:if test="${not empty discipline.id}">
                <BUTTON form="delete">Удалить</BUTTON>
            </c:if>
        </P>
    </FORM>
    <c:if test="${not empty discipline.id}">
        <c:url var="deleteUrl" value="/discipline/delete.html"/>
        <FORM id="delete" action="${deleteUrl}" method="post">
            <INPUT type="hidden" name="id" value="${discipline.id}">
        </FORM>
    </c:if>
    <c:url var="backUrl" value="/discipline/list.html"/>
    <P><A href="${backUrl}">Вернуться к списку дисциплин</A></P>
    <c:url var="homeUrl" value="/"/>
    <P><A href="${homeUrl}">Вернуться на главную страницу</A></P>
</u:html>