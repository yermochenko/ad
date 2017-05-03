<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="stylesheet" required="false" rtexprvalue="true" type="java.lang.String"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>${title}</TITLE>
        <c:if test="${not empty stylesheet}">
            <LINK rel="stylesheet" type="text/css" href="${stylesheet}">
        </c:if>
    </HEAD>
    <BODY>
        <jsp:doBody/>
    </BODY>
</HTML>