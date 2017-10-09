<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Quotes</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<%@ include file="navigation.jspf" %>
<div class="container">
    <s:message code="home.welcome.caption"/> ${name}. <BR/> <s:message code="home.intro.message.p1"/> <a
        href="/quotes"><s:message code="home.intro.message.p2"/></a>
</div>
<a href="<c:url value="/quotes" />"><s:message code="home.menu.quotes"/></a> |
<a href="<c:url value="/users" />"><s:message code="home.menu.register"/></a>
</body>
</html>