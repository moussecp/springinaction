<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <spring:message code="home.welcome.caption"/> ${name}. <BR/> <spring:message code="home.intro.message.p1"/> <a
        href="/quotes"><spring:message code="home.intro.message.p2"/></a>
</div>
<a href="<c:url value="/quotes" />"><spring:message code="home.menu.quotes"/></a> |
<a href="<c:url value="/quotes/register" />"><spring:message code="home.menu.register"/></a>
</body>
</html>