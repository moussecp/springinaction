<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Quotes</title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <s:message code="home.welcome.caption"/> ${username}. <BR/> <s:message code="home.intro.message.p1"/> <a
        href="/quotes"><s:message code="home.intro.message.p2"/></a>
</div>
<a href="<c:url value="/quotes" />"><s:message code="home.menu.quotes"/></a> |
<a href="<c:url value="/users/register" />"><s:message code="home.menu.user.register"/></a>
</body>
</html>