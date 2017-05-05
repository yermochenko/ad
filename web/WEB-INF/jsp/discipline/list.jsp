<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:url var="cssUrl" value="/table.css"/>
<u:html title="Дисциплины" stylesheet="${cssUrl}">
    <H1>Список дисциплин</H1>
    <c:choose>
        <c:when test="${not empty disciplines}">
            <UL>
                <c:forEach var="discipline" items="${disciplines}">
                    <c:url var="editUrl" value="/discipline/edit.html">
                        <c:param name="id" value="${discipline.id}"/>
                    </c:url>
                    <LI><A href="${editUrl}">${discipline.name}</A></LI>
                </c:forEach>
            </UL>
        </c:when>
        <c:otherwise>
            <P>Список дисциплин пока пуст</P>
        </c:otherwise>
    </c:choose>
    <c:url var="editUrl" value="/discipline/edit.html"/>
    <FORM action="${editUrl}">
        <BUTTON>Добавить</BUTTON>
    </FORM>
    <c:url var="backUrl" value="/"/>
    <P><A href="${backUrl}">Вернуться на главную страницу</A></P>
</u:html>