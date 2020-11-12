<%@ page import="model.domain.Boek" %><%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 25-Oct-20
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style_leeslijst.css">
    <title>gevonden boek</title>
</head>
<body>
<header>
    <h1>leeslijst</h1>
    <nav>
        <ul>
            <li><a href="Servlet">Home pagina</a></li>
            <li><a href="zoek.jsp">zoek een boek</a></li>
            <li><a href="voegToe.jsp">voeg een boek toe</a></li>
            <li><a href="Servlet?command=overzicht">overzicht van boeken</a></li>
        </ul>
    </nav>
</header>
<main>
    <%Boek boek = (Boek) request.getAttribute("boek");%>
    <p class="enkelep">je vroeg naar de volgende gegevens: <%=boek.toString()%></p>
</main>
<footer>
    <p>Web ontwikkeling 2 - 2020-2021 - project van Milan Brouns</p>
</footer>
</body>
</html>
