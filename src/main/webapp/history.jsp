<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>History</title>
</head>
<body>

<c:if test="${sessionScope.operation == null}">
    <p>История операций пуста</p>
</c:if>

<c:if test="${sessionScope.operation != null}">
    <table>
        <tr>
            <td>Id = ${sessionScope.operation.id}</td>
            <td>Первое число = ${sessionScope.operation.num1}</td>
            <td>Второе число = ${sessionScope.operation.num2}</td>
            <td>Тип операции = ${sessionScope.operation.type}</td>
            <td>Результат = ${sessionScope.operation.result}</td>
        </tr>
    </table>
</c:if>

<a href="/calc">Открыть калькулятор</a>

</body>
</html>
