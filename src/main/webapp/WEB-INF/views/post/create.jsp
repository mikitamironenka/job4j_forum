
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name'></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='text'></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>
