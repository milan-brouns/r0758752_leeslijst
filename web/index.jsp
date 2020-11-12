<%@ page import="model.domain.Boek" %><%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 02-Oct-20
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
    <link href="css/reset.css" rel="stylesheet">
    <link href="css/style_leeslijst.css" rel="stylesheet">
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
    <article>
        <h2>Welkom op de leeslijst</h2>
        <p>Op deze website kan je zelf een leestlijst samen stellen. Ik heb al enkele van mijn favoriete boeken in het
            overzicht gezet. Je kan deze bekijken door boven aan op "overzicht van boeken" te klikken.</p>
        <p> Je kan ook zelf je favoriete boeken toevoegen door op "voeg een boek toe" te klikken. </p>
        <p>Ten slotte vind je hier onder het boek met de minste en de meeste pagina's terug. </p>
        <p>Veel lees plezier!!</p>
    </article>
    <article>
        <h3>hier zijn het dunste en het dikste boek:</h3>
        <%Boek dunste = (Boek) request.getAttribute("dunste");
        Boek dikste = (Boek) request.getAttribute("dikste");%>
        <p>dunste: <%=dunste.toString()%></p>
        <p>dikste: <%=dikste.toString()%></p>
    </article>
</main>
<footer>
    <p>Web ontwikkeling 2 - 2020-2021 - project van Milan Brouns</p>
</footer>
</body>
</html>
