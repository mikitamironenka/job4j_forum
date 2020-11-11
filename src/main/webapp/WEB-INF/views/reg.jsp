<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<div class="row">
    <h4>Регистрация</h4>
</div>
<form name=,'login' action="<c:url value='/reg'/>" method='POST'>
    <table>
        <tr>
            <td>Введите имя:</td>
            <td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Подтвердить" /></td>
        </tr>
    </table>
</form>
</body>
</html>