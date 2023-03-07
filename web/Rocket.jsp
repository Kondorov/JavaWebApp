<%@ page import="Entity.RocketEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.RocketDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
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
    <title>Ракета</title>
    <link rel="stylesheet" href="css/tablessso.css"/>
</head>
<body background="RRR.jpg">

<%List <RocketEntity> lde = RocketDAO.getAll();%>

<table class="table_price" cellspacing='0'>
    <caption>Ракета</caption>
    <tbody>
    <%
        for(RocketEntity a: lde) {
    %>
    <form method="post" action="deleteRocket">
        <tr>
            <td>
                <input type="text" name="rocket_name" value="<%=a.getRName()%>">
            </td>

            <td>
                <input type="text" name="engines_number" value="<%=a.getEnumb()%>">
            </td>

            <td>
                <input type="text" name="height" value="<%=a.getHeight()%>">
            </td>

            <td>
                <input class="submit" type="submit" value="Удалить" >
            </td>

            <td>
                <button formaction="updateRocket" >Обновить</button>
            </td>
    </form>
    </tr>
    <% }%>
    </tbody>
</table>
<center>
<br>
<form method="post">
    <button formaction="addRocket">Добавить</button>
</form>

<br>
<a class="button8" href="index.jsp">Главная</a>
</center>
</body>
</html>
