<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Дисциплины" stylesheet="table.css">
<CENTER>
	<c:choose>
		<c:when test="${not empty disciplineImpls}">
			<FORM action="editdiscipline.html" method="post">
				<TABLE>
					<TR>
						<TH>ID</TH>
						<TH>Название</TH>
						<TH>Сокращенное название</TH>
					</TR>
					<c:forEach var="disciplineImpl" items="${disciplineImpls}">
						<TR>
							<TD>
								<CENTER>
									<A href="editdiscipline.html?id=${disciplineImpl.id}">${disciplineImpl.id}</A>
								</CENTER>
							</TD>
							<TD>
								<CENTER>${disciplineImpl.name}</CENTER>
							</TD>
							<TD>
								<CENTER>${disciplineImpl.shortName}</CENTER>
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