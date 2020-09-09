<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

Hello ${sessionScope.user.name}

<c:if test="${sessionScope.user != null}">
    <a href="/account">Edit Account</a>
    <a href="/calc">Calculator</a>
    <a href="/history">Calculation History</a>
    <a href="/logout">Logout</a>
</c:if>
<c:if test="${sessionScope.user == null}">
    <a href="/reg">Registration</a>
    <a href="/auth">Authorization</a>
</c:if>

</body>
</html>
