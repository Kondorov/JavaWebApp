<%@ page import="Entity.EngineEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.EngineDAO" %>
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
    <title>Двигатель</title>
    <link rel="stylesheet" href="css/tablessso.css"/>
</head>
<body background="RRR.jpg">

<%List <EngineEntity> lde = EngineDAO.getAll();%>

<table class="table_price" cellspacing='0'>
    <caption>Двигатель</caption>
    <tbody>
    <%
        for(EngineEntity a: lde) {
    %>
    <form method="post" action="deleteEngine">
        <tr>
            <td>
                <input type="text" name="engine_name" value="<%=a.getEName()%>">
            </td>

            <td>
                <input type="text" name="traction" value="<%=a.getTraction()%>">
            </td>

            <td>
                <input type="text" name="fueltype" value="<%=a.getFueltype()%>">
            </td>

            <td>
                <input class="submit" type="submit" value="Удалить" >
            </td>

            <td>
                <button formaction="updateEngine" >Обновить</button>
            </td>
    </form>
    </tr>
    <% }%>
    </tbody>
</table>
<br>
<center>
<form method="post">
    <button formaction="addEngine">Добавить</button>
</form>

<br>
<a class="button8" href="index.jsp">Главная</a>
    </center>
</body>
</html>
