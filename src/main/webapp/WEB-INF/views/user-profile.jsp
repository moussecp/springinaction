<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title><s:message code="profile.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>"${user.username}"</h1>
</div>
<hr>
<div class="container">
    <div class="row">
        <div class="col-md-4"><s:message code="register.username"/></div>
        <div class="col-md-8">${user.username}</div>
    </div>
    <div class="row">
        <div class="col-md-4"><s:message code="register.firstname"/></div>
        <div class="col-md-8">${user.firstName}</div>
    </div>
    <div class="row">
        <div class="col-md-4"><s:message code="register.lastname"/></div>
        <div class="col-md-8">${user.lastName}</div>
    </div>
    <div class="row">
        <div class="col-md-4"><s:message code="register.email"/></div>
        <div class="col-md-8">${user.email}</div>
    </div>
</div>
</body>
</html>