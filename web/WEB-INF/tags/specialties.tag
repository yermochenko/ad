<%@tag language="java" pageEncoding="UTF-8"%>

<%@attribute name="items" required="true" rtexprvalue="true" type="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:if test="${not empty items}">
    <UL>
        <c:forEach var="specialty" items="${items}">
            <LI>
                <c:url var="editUrl" value="/specialty/edit.html">
                    <c:param name="id" value="${specialty.id}"/>
                </c:url>
                <A href="${editUrl}">
                    ${specialty.code} ${specialty.name}<c:if test="${not empty specialty.qualification}">, квалификация: ${specialty.qualification}</c:if>
                </A>
                <u:specialties items="${specialty.children}"/>
            </LI>
        </c:forEach>
    </UL>
</c:if>