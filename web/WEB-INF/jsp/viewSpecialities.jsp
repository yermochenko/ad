<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Обзор специальности" stylesheet="table.css">
    <c:choose>
        <c:when test="${not empty specialty}">
            <%--<h1>${spetialty.name}</h1>--%>
            <TABLE align="center">
                <TR>
                    <TH>Код специальности</TH>
                    <TH>${specialty.code}</TH>
                </TR>
                <TR>
                    <TH>Название специальности</TH>
                    <TH>${specialty.name}</TH>
                </TR>
                <TR>
                    <TH>Сокращенное название</TH>
                    <TH>${specialty.shortName}</TH>
                </TR>
                <TR>
                    <TH>Квалификация</TH>
                    <TH>${specialty.qualification}</TH>
                </TR>
                <TR>
                    <TH>Направление специальности</TH>
                    <TH>${specialty.specialtyDirection}</TH>
                </TR>
                <TR>
                    <TH>Дочерние специальности</TH>
                    <TH><select>
                            <c:forEach var="child" items="${specialty.children}">
                                <option>${child.id} ${child.name}</option>
                            </c:forEach>
                        </select>
                    </TH>
                </TR>
            </TABLE>
        </c:when>
        <c:otherwise>
            Не существует такой специальности
        </c:otherwise>
    </c:choose>
</u:html>
