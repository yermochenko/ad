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

        <LINK rel="stylesheet" type="text/css" href="/ad/css/bootstrap.css">

        <script type="text/javascript" src="/ad/js/controllers/MainController.js"></script>
        <script type="text/javascript" src="/ad/js/View/View.js"></script>
        <script type="text/javascript" src="/ad/js/View/DOMView/Table.js"></script>
        <script type="text/javascript" src="/ad/js/View/DOMView/Form.js"></script>
        <script type="text/javascript" src="/ad/js/Rest.js"></script>
    </HEAD>
    <BODY>
        <jsp:doBody/>
    </BODY>
</HTML>