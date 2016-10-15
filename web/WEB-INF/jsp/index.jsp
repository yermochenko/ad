<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Документооборот кафедры">
<CENTER>
	<FORM>
		<BUTTON formaction="disciplines.html">Дисциплины</BUTTON>
		<BUTTON formaction="curriculumdisciplines.html">Дисциплины
			учебных планов</BUTTON>
		<BUTTON formaction="specialties.html">Специальности</BUTTON>
		<BUTTON formaction="curriculums.html">Учебные планы</BUTTON>
	</FORM>
</CENTER>
</BODY>
</u:html>