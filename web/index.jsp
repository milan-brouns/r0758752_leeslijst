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
        <p>Je kan ook zelf je favoriete boeken toevoegen door op "voeg een boek toe" te klikken. </p>
        <p>hier onder vind je het boek met de minste en de meeste pagina's terug.</p>
        <p>Ten slotte je kan onder deze twee sugestie's ook aan geven wat de minimum dikte van boek moet zijn voor jou.</p>
        <p>Veel lees plezier!!</p>
    </article>
    <article>
        <h3>hier zijn het dunste en het dikste boek:</h3>
        <p>dunste: ${dunste}
        <p>dikste: ${dikste}
    </article>
    <form action="Servlet" method="post" id="cookieForm" novalidate >
        <p class="enkelep">Hier kun je aan geven wat de minimum dikte van een boek moet zijn.</p>
        <c:if test="${not empty errors}">
            <div class="error">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <div class="${minimumDikteClass}">
        <label for="minimumDikte">Jou minimum aantal pagina's voor een boek is: </label>
        <input type="number" name="minimumDikte" id="minimumDikte" placeholder="200" <c:if test="${vorigeMinimumDikte != null}">value="${vorigeMinimumDikte}"</c:if>>
        </div>
            <input type="text" name="command" value="setMinimumDikte" hidden>
        <input type="submit" id="bewaar" value="bewaar mijn voorkeur">
    </form>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
