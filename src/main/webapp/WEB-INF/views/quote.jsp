<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title><s:message code="quote.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1><s:message code="quote.title"/></h1>
    <p class="blockquote">
        <i>
            <h2>
                "${quote.message}"
            </h2>
        </i>
    </p>
</div>
<hr>
<div class="container">
    <div class="row">
        <div class="col-md-4"><s:message code="quotes.id"/></div>
        <div class="col-md-8">${quote.id}</div>
    </div>
    <div class="row">
        <div class="col-md-4"><s:message code="quotes.author"/></div>
        <div class="col-md-8">${quote.author}</div>
    </div>
    <div class="row">
        <div class="col-md-4"><s:message code="quotes.reference"/></div>
        <div class="col-md-8">${quote.reference}</div>
    </div>
    <div class="row">
        <div class="col-md-4"><s:message code="quotes.time.added"/></div>
        <div class="col-md-8">${quote.time}</div>
    </div>
</div>
<div class="container">
    <a href="/quotes/delete-quote/${quote.id}" class="btn btn-danger">
        <s:message code="quotes.delete"/>
    </a>
</div>
</body>
</html>
