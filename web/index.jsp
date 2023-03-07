<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='css/lists.css' %>
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
    <title>KONDOROV</title>
</head>
<body background="RRR.jpg">
<div>

    <ul class="push">
        <li><a class="button8" href="Cosmodrome.jsp">Космодром</a></li>
        <li><a class="button8" href="Flight.jsp">Полет</a></li>
        <li><a class="button8" href="Rocket.jsp">Ракета</a></li>
        <li><a class="button8" href="Engine.jsp">Двигатель</a></li>
    </ul>

</div>
</body>
</html>