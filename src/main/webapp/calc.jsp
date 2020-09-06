<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
    <form action="/calc" method="post">
         <input type="text" name="num1" placeholder="enter first number">
         <input type="text" name="num2" placeholder="enter second number">
         <input type="text" name="type" placeholder="enter calculation type">
         <button>Calculate</button>
    </form>

    <c:if test="${requestScope.result != null}">
        <p>${requestScope.result}</p>
    </c:if>

    <a href="/history">Показать историю операций</a>

</body>
</html>
