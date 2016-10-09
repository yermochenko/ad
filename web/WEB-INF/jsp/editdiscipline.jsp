<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<TITLE>Редактирование дисциплины</TITLE>
<STYLE>
TABLE {
	border-collapse: collapse;
}

TH, TD {
	border: 1px solid black;
	padding: 5px 5px 5px 5px;
}
</STYLE>
</HEAD>
<BODY>
	<FORM action="check.html" method="post">
		<c:choose>
			<c:when test="${empty check}">
				<c:if test="${not empty discipline }">
					<INPUT type="hidden" name="id" value="${discioline.id}">
				</c:if>
				<P>Название</P>
				<c:choose>
					<c:when test="${not empty discipline}">
						<INPUT type="text" name="name" value="${discipline.name}" required>
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
			</c:when>
			<c:otherwise>
				<c:if test="${not empty id }">
					<INPUT type="hidden" name="id" value="${id}">
				</c:if>
				<P>Название</P>
				<INPUT type="text" name="name" value="${name}" required>
				<P>Сокращенное название</P>
				<INPUT type="text" name="shortname" value="${shortname}" required>
				<P>
					<BUTTON type="submit">Сохранить</BUTTON>
					<c:if test="${not empty id }">
						<BUTTON formaction="delete.html?id=${discipline.id}">Удалить</BUTTON>
					</c:if>
				</P>
			</c:otherwise>
		</c:choose>
	</FORM>
	<P>
	<FORM>
		<BUTTON formaction="disciplines.html">Вернуться назад</BUTTON>
	</FORM>
	</P>
</BODY>
</HTML>