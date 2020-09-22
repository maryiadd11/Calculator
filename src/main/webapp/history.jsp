<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>History</title>
</head>
<body>
<table>
    <c:forEach items="${requestScope.report}" var="operation">
        <tr>
            <td><div>id = ${operation.id}</div></td>
            <td><div>num_1 = ${operation.num1}</div></td>
            <td><div>num_2 = ${operation.num2}</div></td>
            <td><div>operation_type = ${operation.type}</div></td>
            <td><div>result = ${operation.result}</div></td>
        </tr>
    </c:forEach>
</table>

<a href="/calc">Открыть калькулятор</a>

</body>
</html>
