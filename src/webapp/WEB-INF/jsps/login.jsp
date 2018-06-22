<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/12
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>xxx</title>
</head>
<body>
    <table>
        <tr>
            <td>name</td>
            <td>age</td>
        </tr>
        <c:forEach items="${girls}" var="girl" >
            <tr>
                <td>${girl.name}</td>
                <td>${girl.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
