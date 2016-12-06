<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:choose>
	<c:when test="${not empty disciplineImpl}">
		<c:set var="title" value="Редактирование дисциплины" />
	</c:when>
	<c:otherwise>
		<c:set var="title" value="Создание дисциплины" />
	</c:otherwise>
</c:choose>
<u:html title="${title}">
<FORM action="save.html" method="post">
	<c:if test="${not empty disciplineImpl }">
		<INPUT type="hidden" name="id" value="${disciplineImpl.id}">
	</c:if>
	<P>Название</P>
	<c:choose>
		<c:when test="${not empty disciplineImpl}">
			<INPUT type="text" name="name" value="${disciplineImpl.name}" required>
		</c:when>
		<c:otherwise>
			<INPUT type="text" name="name" value="" required>
		</c:otherwise>
	</c:choose>
	<P>Сокращенное название</P>
	<c:choose>
		<c:when test="${not empty disciplineImpl}">
			<INPUT type="text" name="shortname" value="${disciplineImpl.shortName}"
				required>
		</c:when>
		<c:otherwise>
			<INPUT type="text" name="shortname" value="" required>
		</c:otherwise>
	</c:choose>
	<P>
		<BUTTON type="submit">Сохранить</BUTTON>
		<c:if test="${not empty disciplineImpl }">
			<BUTTON formaction="delete.html?id=${disciplineImpl.id}">Удалить</BUTTON>
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