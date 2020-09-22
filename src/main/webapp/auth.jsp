<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/auth" method="post">
    <input type="text" name="login" placeholder="enter login">
    <input type="text" name="password" placeholder="enter password">
    <button>Authorization</button>
</form>
${requestScope.message}
</body>
</html>
