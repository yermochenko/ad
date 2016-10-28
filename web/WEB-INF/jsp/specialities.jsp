<%--
Главная Jsp страница специальности
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Специальности" stylesheet="table.css">
    <CENTER>
        <c:choose>
            <c:when test="${not empty specialities}">
                <FORM action="editspecialities.html" method="post">
                    <TABLE>
                        <TR>
                            <TH>ID</TH>
                            <TH>Код специальности</TH>
                            <TH>Название специальности</TH>
                            <TH>Сокращенное название</TH>
                            <TH>Квалификация</TH>
                            <TH>Направление специальности</TH>
                            <TH>Родительская специальность</TH>
                            <TH>Дочерние специальности</TH>
                        </TR>
                        <c:forEach var="special" items="${specialities}">
                            <TR>
                                <TD><A href="editspecialities.html?id=${special.id}">${special.id}</A></TD>
                                <TD>${special.code}</TD>
                                <TD>${special.name}</TD>
                                <TD>${special.shortName}</TD>
                                <TD>${special.qualification}</TD>
                                <TD>${special.specialtyDirection}</TD>
                                <c:choose>
                                    <c:when test="${not empty special.parent}">
                                        <TD><A href="viewSpecialty.html?id=${special.parent.id}">${special.parent.toString()}</A></TD>
                                    </c:when>
                                    <c:otherwise>
                                        <TD>Нет родительской специальности</TD>
                                    </c:otherwise>
                                </c:choose>
                                <TD>
                                    <select>
                                        <option>Детки</option>
                                        <c:forEach var="child" items="${special.children}">
                                            <option>${child.id} ${child.name}</option>
                                        </c:forEach>
                                    </select>
                                </TD>
                            </TR>
                        </c:forEach>
                    </TABLE>
                </FORM>
            </c:when>
            <c:otherwise>
                <P>Список специальностей пока пуст</P>
            </c:otherwise>
        </c:choose>
    </CENTER>
    <P>
    <CENTER>
        <FORM>
            <BUTTON formaction="editspecialities.html">Добавить</BUTTON>
            <BUTTON formaction="index.html">Вернуться на главную страницу</BUTTON>
        </FORM>
    </CENTER>
    </P>
    </BODY>
</u:html>
