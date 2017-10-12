<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title><s:message code="register.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1><s:message code="register.title"/></h1>
    <sf:form method="POST">
        <div class="form-group">
            <label for="firstName"><s:message code="register.firstname"/></label>
            <input type="text" class="form-control" name="firstName" id="firstName"
                   placeholder="<s:message code="register.firstname"/>">
        </div>
        <div class="form-group">
            <label for="lastName"><s:message code="register.lastname"/></label>
            <input type="text" class="form-control" name="lastName" id="lastName"
                   placeholder="<s:message code="register.lastname"/>">
        </div>
        <div class="form-group">
            <label for="email"><s:message code="register.email"/></label>
            <input type="text" class="form-control" name="email" id="email"
                   placeholder="<s:message code="register.email"/>">
        </div>
        <div class="form-group">
            <label for="username"><s:message code="register.username"/></label>
            <input type="text" class="form-control" name="username" id="username"
                   placeholder="<s:message code="register.username"/>">
        </div>
        <div class="form-group">
            <label for="password"><s:message code="register.password"/></label>
            <input type="password" class="form-control" name="password" id="password"
                   placeholder="<s:message code="register.password"/>">
        </div>
        <button type="submit" class="btn btn-default"><s:message code="add-quote.submit"/></button>
    </sf:form>
</div>
</body>
</html>
