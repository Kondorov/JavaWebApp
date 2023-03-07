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
    <title>Космодром</title>
</head>
<body background="RRR.jpg">
<table class="table_price" cellspacing='0'>
    <caption>Добавление</caption>
    <form method="get" >
        <tr>
            <td>Название</td>
            <td>Страна</td>
            <td>Временная зона</td>
            <td> </td>
        </tr>
        <tr>
            <td>
                <input type="text"  name="cosmodrome_name">

            </td>
            <td>
                <input type="text" name="country">
            </td>
            <td>
                <input type="text" name="timezone">
            </td>

            <td>
                <button formaction="addCosmodrome" >Создать</button>
            </td>
    </form>
</table>
<center>
    <br>
    <a class="button8" href="Cosmodrome.jsp">Отмена</a>
    <br>
    <br>
    <a class="button8" href="index.jsp">Главная</a>
</center>
</body>
</html>
