<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title><s:message code="add-quote.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1><s:message code="add-quote.title"/></h1>
    <form method="POST">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <div class="form-group">
            <label for="message"><s:message code="add-quote.message"/></label>
            <input type="text" class="form-control" name="message" id="message"
                   placeholder="<s:message code="add-quote.message"/>">
        </div>
        <div class="form-group">
            <label for="author"><s:message code="add-quote.author"/></label>
            <input type="text" class="form-control" name="author" id="author"
                   placeholder="<s:message code="add-quote.author"/>">
        </div>
        <div class="form-group">
            <label for="reference"><s:message code="add-quote.reference"/></label>
            <input type="text" class="form-control" name="reference" id="reference"
                   placeholder="<s:message code="add-quote.reference"/>">
        </div>
        <button type="submit" class="btn btn-default"><s:message code="add-quote.submit"/></button>
    </form>
</div>
</body>
</html>
