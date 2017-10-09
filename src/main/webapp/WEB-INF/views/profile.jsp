<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${user.username}"/><br/>
<c:out value="${user.firstName}"/>
<c:out value="${user.lastName}"/>
<c:out value="${user.email}"/>
</body>
</html>
