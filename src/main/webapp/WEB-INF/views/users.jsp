<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="users.title"/></title>
    <%@ include file="common/style.jspf" %>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1><s:message code="users.title"/></h1>
    <form method="POST">
        <div class="form-group">
            <label for="username"><s:message code="users.username"/></label>
            <input type="text" class="form-control" name="username" id="username"
                   placeholder="<s:message code="users.username"/>">
        </div>
        <button type="submit" class="btn btn-default"><s:message code="users.submit"/></button>
    </form>
    <div>
        <a class="btn btn-success" href="/users/"><s:message code="users.add"/></a>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th><s:message code="users.username"/></th>
            <th><s:message code="users.detail"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>
                    <a href="/users/${user.username}"
                       class="btn btn-info">
                        <s:message code="users.detail"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="btn btn-success" href="/users/register/"><s:message code="users.add"/></a>
    </div>
</div>
</body>
</html>