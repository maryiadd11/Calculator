<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Account</title>
</head>
<body>
    <form action="/account" method="post">
        <input name="name" type="text" placeholder="Enter new name" required minlength="3" maxlength="16">
        <input name="password" type="password" placeholder="Enter new password" required minlength="5" maxlength="16">
        <button>Update</button>
    </form>
<a href="/">Home</a>
</body>
</html>
