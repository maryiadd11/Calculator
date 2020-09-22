<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Account</title>
</head>
<body>
    <form action="/account" method="post">
        <input name="value" type="text" placeholder="login" required minlength="3" maxlength="16">
        <select name="field">
            <option value="name">Update name</option>
            <option value="password">Update password</option>
        </select>
        <button>Update</button>
    </form>
    ${requestScope.message}
    <a href="/">Home</a>
</body>
</html>
