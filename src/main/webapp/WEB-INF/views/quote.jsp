<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="quote.title"/> ${quote.id}</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<%@ include file="navigation.jspf" %>
<div class="container">
    <table class="table table-striped">
        <caption>
            "${quote.message}"
        </caption>
        <thead>
        <tr>
            <th><s:message code="quotes.author"/></th>
            <th><s:message code="quotes.reference"/></th>
            <th><s:message code="quotes.time.added"/></th>
            <th><s:message code="quotes.delete"/></th>
            <th><s:message code="quotes.detail"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quotes}" var="quote">
            <tr>
                <td>${quote.author}</td>
                <td>${quote.reference}</td>
                <td>${quote.time}</td>
                <td><a href="/quotes/${quote.id}" class="btn-info"><s:message code="quotes.detail"/></a>
                <td><a href="/delete-quote?id=${quote.id}" class="btn btn-danger"><s:message
                        code="quotes.delete"/></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <div class="quoteView">
            <c:out value="${quote.id}"/>
            <c:out value="${quote.author}"/>
            <c:out value="${quote.reference}"/>
            <c:out value="${quote.time}"/>
        </div>
    </table>
</div>
</body>
</html>
