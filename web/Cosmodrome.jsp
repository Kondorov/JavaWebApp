<%@ page import="Entity.CosmodromeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CosmodromeDAO" %>
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
    <title>Космодром</title>
    <link rel="stylesheet" href="css/tablessso.css"/>
</head>
<body background="RRR.jpg">

<%List <CosmodromeEntity> lde = CosmodromeDAO.getAll();%>

<table class="table_price" cellspacing='0'>
    <caption>Космодром</caption>

    <tbody>
    <%
        for(CosmodromeEntity a: lde) {
    %>
    <form method="post" action="deleteCosmodrome">
        <tr>
            <td>
                <input type="text" name="cosmodrome_name" value="<%=a.getCName()%>">
            </td>

            <td>0
                <input type="text" name="country" value="<%=a.getCountry()%>">
            </td>

            <td>
                <input type="text" name="timezone" value="<%=a.getTimezone()%>">
            </td>

            <td>
                </a><input class="submit" type="submit" value="Удалить" ></a>
            </td>

            <td>
                </a><button formaction="updateCosmodrome" >Обновить</button></a>
            </td>
    </form>
    </tr>
    <% }%>
    </tbody>
</table>
<br>
    <center>
<form method="post">
    <button class="button8" align="center" formaction="addCosmodrome">Добавить</button>
</form>
<br>
<a href="index.jsp" class="button8">Главная</a>
    </center>
</body>
</html>
