<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="quotes.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1><s:message code="quotes.title"/></h1>
    <div>
        <a class="btn btn-success" href="/quotes/add-quote/"><s:message code="quotes.add"/></a>
    </div>
    <table class="table table-striped">
        <caption>
            <s:message code="quotes.caption"/> (<s:message code="quotes.showing"/> ${quotes.size()})
        </caption>
        <thead>
        <tr>
            <th><s:message code="quotes.author"/></th>
            <th><s:message code="quotes.message.preview"/></th>
            <th><s:message code="quotes.detail"/></th>
            <th><s:message code="quotes.reference"/></th>
            <th><s:message code="quotes.time.added"/></th>
            <th><s:message code="quotes.delete"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quotes}" var="quote">
            <tr>
                <td>${quote.author}</td>
                <td>${quote.truncatedMessage}</td>
                <td>
                    <a href="/quotes/${quote.id}"
                       class="btn btn-info">
                        <s:message code="quotes.detail"/>
                    </a>
                </td>
                <td>${quote.reference}</td>
                <td>${quote.time}</td>
                <td>
                    <a href="/quotes/delete-quote/${quote.id}"
                       class="btn btn-danger">
                        <s:message code="quotes.delete"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="btn btn-success" href="/quotes/add-quote/"><s:message code="quotes.add"/></a>
    </div>
</div>
</body>
</html>