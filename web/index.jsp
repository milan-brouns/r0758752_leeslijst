<%@ page import="model.domain.Boek" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
<jsp:include page="header.jsp"></jsp:include>
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
        <p>dunste: '${dunste.titel}' geschreven door ${dunste.auteur} en telt ${dunste.aantalpaginas} pagina's.</p>
        <p>dikste: '${dikste.titel}' geschreven door ${dikste.auteur} en telt ${dikste.aantalpaginas} pagina's.</p>
    </article>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
