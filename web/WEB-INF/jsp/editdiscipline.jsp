<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:choose>
	<c:when test="${not empty discipline}">
		<c:set var="title" value="Редактирование дисциплины" />
	</c:when>
	<c:otherwise>
		<c:set var="title" value="Создание дисциплины" />
	</c:otherwise>
</c:choose>
<u:html title="${title}">
<FORM action="save.html" method="post">
	<c:if test="${not empty discipline }">
		<INPUT type="hidden" name="id" value="${discipline.id}">
	</c:if>
	<P>Название</P>
	<c:choose>
		<c:when test="${not empty discipline}">
			<INPUT type="text" name="name" value="${discipline.name}"
				required>
		</c:when>
		<c:otherwise>
			<INPUT type="text" name="name" value="" required>
		</c:otherwise>
	</c:choose>
	<P>Сокращенное название</P>
	<c:choose>
		<c:when test="${not empty discipline}">
			<INPUT type="text" name="shortname"
				value="${discipline.shortName}" required>
		</c:when>
		<c:otherwise>
			<INPUT type="text" name="shortname" value="" required>
		</c:otherwise>
	</c:choose>
	<P>
		<BUTTON type="submit">Сохранить</BUTTON>
		<c:if test="${not empty discipline }">
			<BUTTON formaction="delete.html?id=${discipline.id}">Удалить</BUTTON>
		</c:if>
	</P>
</FORM>
<P>
<FORM>
	<BUTTON formaction="disciplines.html">Вернуться назад</BUTTON>
</FORM>
</P>
</BODY>
</u:html>