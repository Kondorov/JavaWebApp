<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='css/tablessso.css' %>
    a.button8 {
        display: inline-block;
        color: white;
        font-weight: 700;
        text-decoration: none;
        user-select: none;
        padding: .5em 2em;
        outline: none;
        border: 2px solid;
        border-radius: 1px;
        transition: 0.2s;
    }
    a.button8:hover { background: rgba(255,255,255,.2); }
    a.button8:active { background: white; }

</style>
<html>
<head>
    <title>Title</title>
</head>
<body background="RRR.jpg">
<table class="table_price" cellspacing='0'>
    <caption>Добавление</caption>
    <form method="get" >
        <tr>
            <td>Название</td>
            <td>Тяга</td>
            <td>Тип топлива</td>
            <td> </td>
        </tr>
        <tr>
            <td>
                <input type="text"  name="engine_name">

            </td>
            <td>
                <input type="text" name="traction">
            </td>
            <td>
                <input type="text" name="fueltype">
            </td>

            <td>
                <button formaction="addEngine" >Создать</button>
            </td>
    </form>
</table>
<center>
    <br>
    <a class="button8" href="Engine.jsp">Отмена</a>
    <br>
    <br>
    <a class="button8" href="index.jsp">Главная</a>
</center>
</body>
</html>
