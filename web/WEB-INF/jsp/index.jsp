<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Документооборот кафедры">
    <UL>
        <c:url var="disciplineUrl" value="/discipline/list.html"/>
        <LI><A href="${disciplineUrl}">Дисциплины</A></LI>
        <c:url var="specialtyUrl" value="/specialty/list.html"/>
        <LI><A href="${specialtyUrl}">Специальности</A></LI>
        <c:url var="curriculumUrl" value="/curriculum/list.html"/>
        <LI><A href="${curriculumUrl}">Учебные планы</A></LI>
    </UL>
</u:html>