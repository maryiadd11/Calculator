<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="/reg" method="post">
    <input type="text" name="login" placeholder="enter login">
    <input type="text" name="name" placeholder="enter name">
    <input type="text" name="password" placeholder="enter password">
    <button>Registration</button>
</form>
${requestScope.message}
</body>
</html>
