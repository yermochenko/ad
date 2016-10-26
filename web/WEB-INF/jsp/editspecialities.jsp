<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Редактирование специальности" >
    <FORM action="saveSpecialty.html" method="post" align="center">
        <c:choose>
            <c:when test="${empty check}">
                <c:choose>
                    <c:when test="${not empty specialty}">
                        <INPUT type="hidden" name="id" value="${specialty.id}">
                        <P>Код специальности: <INPUT type="text" name="code" value="${specialty.code}" required></P></P>
                        <P>Название специальности: <INPUT type="text" name="name" value="${specialty.name}" required></P>
                        <P>Сокращенное название: <INPUT type="text" name="shortName" value="${specialty.shortName}" required></P>
                        <P>Квалификация: <INPUT type="text" name="qualification" value="${specialty.qualification}" required></P>
                        <P>Направление специальности: <INPUT type="text" name="specialtyDirection" value="${specialty.specialtyDirection}" required></P>
                    </c:when>
                    <c:otherwise>
                        <P>Код специальности: <INPUT type="text" name="code" value="" required></P></P>
                        <P>Название специальности: <INPUT type="text" name="name" value="" required></P>
                        <P>Сокращенное название: <INPUT type="text" name="shortName" value="" required></P>
                        <P>Квалификация: <INPUT type="text" name="qualification" value="" required></P>
                        <P>Направление специальности: <INPUT type="text" name="specialtyDirection" value="" required></P>
                    </c:otherwise>
                </c:choose>

                <select id="select" name="select">
                    <option></option>
                    <c:forEach var="special" items="${specialties}">
                        <option>${special.id} ${special.name}</option>
                    </c:forEach>
                </select>

                <P>
                    <BUTTON type="submit">Сохранить</BUTTON>
                    <c:if test="${not empty specialty }">
                        <BUTTON formaction="deleteSpecialty.html?id=${specialty.id}">Удалить</BUTTON>
                    </c:if>
                </P>
            </c:when>
            <c:otherwise>
                <%--&??????????????????????????????--%>
                <c:if test="${not empty id }">
                    <INPUT type="hidden" name="id" value="${id}">
                </c:if>
                <P>Название</P>
                <INPUT type="text" name="name" value="${name}" required>
                <P>Сокращенное название</P>
                <INPUT type="text" name="shortName" value="${shortName}" required>
                <P>
                    <BUTTON type="submit">Сохранить</BUTTON>
                    <c:if test="${not empty id }">
                        <BUTTON formaction="deleteSpecialty.html?id=${discipline.id}">Удалить</BUTTON>
                    </c:if>
                </P>
            </c:otherwise>
        </c:choose>
    </FORM>
    <P>
    <FORM align="center">
        <BUTTON formaction="specialties.html">Вернуться назад</BUTTON>
    </FORM>
    </P>
    </BODY>
</u:html>
