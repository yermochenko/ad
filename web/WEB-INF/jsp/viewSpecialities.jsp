<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Обзор специальности" stylesheet="table.css">
    <c:choose>
        <c:when test="${not empty specialtyImpl}">
            <%--<h1>${spetialty.name}</h1>--%>
            <TABLE align="center">
                <TR>
                    <TH>Код специальности</TH>
                    <TH>${specialtyImpl.code}</TH>
                </TR>
                <TR>
                    <TH>Название специальности</TH>
                    <TH>${specialtyImpl.name}</TH>
                </TR>
                <TR>
                    <TH>Сокращенное название</TH>
                    <TH>${specialtyImpl.shortName}</TH>
                </TR>
                <TR>
                    <TH>Квалификация</TH>
                    <TH>${specialtyImpl.qualification}</TH>
                </TR>
            </TABLE>
        </c:when>
        <c:otherwise>
            Не существует такой специальности
        </c:otherwise>
    </c:choose>
</u:html>
