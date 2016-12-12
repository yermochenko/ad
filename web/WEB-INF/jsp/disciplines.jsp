<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Дисциплины" stylesheet="table.css">
<CENTER>
	<c:choose>
		<c:when test="${not empty disciplines}">
			<FORM action="editdiscipline.html" method="post">
				<TABLE>
					<TR>
						<TH>ID</TH>
						<TH>Название</TH>
						<TH>Сокращенное название</TH>
					</TR>
					<c:forEach var="discipline" items="${disciplines}">
						<TR>
							<TD>
								<CENTER>
									<A href="editdiscipline.html?id=${discipline.id}">${discipline.id}</A>
								</CENTER>
							</TD>
							<TD>
								<CENTER>${discipline.name}</CENTER>
							</TD>
							<TD>
								<CENTER>${discipline.shortName}</CENTER>
							</TD>
						</TR>
					</c:forEach>
				</TABLE>
			</FORM>
		</c:when>
		<c:otherwise>
			<P>Список дисциплин пока пуст</P>
		</c:otherwise>
	</c:choose>
</CENTER>
<P>
<CENTER>
	<FORM>
		<BUTTON formaction="editdiscipline.html">Добавить</BUTTON>
		<BUTTON formaction="index.html">Вернуться на главную страницу</BUTTON>
	</FORM>
</CENTER>
</P>
</BODY>
</u:html>