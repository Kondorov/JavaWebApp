<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.CosmodromeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CosmodromeDAO" %>
<%@ page import="DAO.RocketDAO" %>
<%@ page import="Entity.RocketEntity" %>
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

<%List <CosmodromeEntity> lde = CosmodromeDAO.getAll();
    List <RocketEntity> de = RocketDAO.getAll();%>

<table class="table_price" cellspacing='0'>
    <caption>Обновление</caption>
    <form method="get" action="updateFlight">
        <tr>
            <td>Дата</td>
            <td>Название космодрома</td>
            <td>Название ракеты</td>
            <td>Длительность полета</td>
            <td>Успешность запуска</td>
            <td> </td>
        </tr>
        <tr>
            <td>
                <input type="date" value="<%=request.getParameter("flight_date") %>" name="flight_date">
            </td>
            <td>
                <select value="<%=request.getParameter("cosmodrome_name") %>" name="cosmodrome_name">
                    <% for(CosmodromeEntity a: lde) { %>
                    <option ><%=a.getCName()%></option>
                    <% } %>
                </select>
            </td>

            <td>
                <select value="<%=request.getParameter("rocket_name") %>" name="rocket_name">
                    <% for(RocketEntity b: de) { %>
                    <option ><%=b.getRName()%></option>
                    <% } %>
                </select>
            </td>

            <td>
                <input type="text" value="<%=request.getParameter("duration") %>" name="duration">
            </td>

            <td>
                <input type="text" value="<%=request.getParameter("success") %>" name="success" >
            </td>

            <td>
                <button formaction="updateFlight" >Обновить</button>
            </td>
    </form>
</table>
<center>
    <br>
<a class="button8" href="Flight.jsp">Отмена</a>
<br>
    <br>
<a class="button8" href="index.jsp">Главная</a>
</center>>

</body>
</html>
