<%@ page import="Entity.FlightEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.FlightDAO" %>
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
    <title>Полет</title>
    <link rel="stylesheet" href="css/tablessso.css"/>
</head>
<body background="RRR.jpg">

<%List <FlightEntity> lde = FlightDAO.getAll();%>

<table class="table_price" cellspacing='0'>
    <caption>Полет</caption>
    <tbody>
    <%
        for(FlightEntity a: lde) {
    %>
    <form method="post" action="deleteFlight">
        <tr>
            <td>
                <input type="flight_date" name="date" value="<%=a.getDate()%>">
            </td>

            <td>
                <input type="text" name="cosmodrome_name" value="<%=a.getCName()%>">
            </td>

            <td>
                <input type="text" name="rocket_name" value="<%=a.getRName()%>">
            </td>

            <td>
                <input type="text" name="duration" value="<%=a.getDuration()%>">
            </td>

            <td>
                <input type="text" name="success" value="<%=a.getSuccess()%>">
            </td>

            <td>
                <input class="submit" type="submit" value="Удалить" >
            </td>

            <td>
                <button formaction="updateFlight" >Обновить</button>
            </td>
    </form>
    </tr>
    <% }%>
    </tbody>

</table>
<br>
<center>
<form method="post">
    <button formaction="addFlight">Добавить</button>
</form>

<br>
<a class="button8" href="index.jsp">Главная</a>
    </center>
</body>
</html>