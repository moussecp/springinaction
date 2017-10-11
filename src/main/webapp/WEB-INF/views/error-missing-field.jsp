<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title><s:message code="error.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1><img
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Dialog-error-round.svg/2000px-Dialog-error-round.svg.png"
            height="40">
        <s:message code="error.missing.field"/></h1>

    <s:message code="error.message"/>: ${error}
</div>
</body>
</html>
