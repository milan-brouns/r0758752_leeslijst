<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 02-Oct-20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>voeg boek toe</title>
    <link href="css/reset.css" rel="stylesheet">
    <link href="css/style_leeslijst.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main>
    <article>
        <h2>vul de velden in om je boek toe te voegen</h2>
        <c:if test="${not empty errors}">
            <div class="error">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        
        <form method="post" action="Servlet?command=voegToe" novalidate>
            <div class="${titelClass}">
                <label for="titel">Titel van je boek:</label>
                <input id="titel" name="titel" placeholder="titel" type="text" value="${titelPreviousValue}" required>
            </div>
            <div class="${auteurClass}">
                <label for="auteur">de auteur van je boek:</label>
                <input id="auteur" name="auteur" placeholder="auteur" type="text" value="${auteurPreviousValue}" required>
            </div>
            <div class="${aantalPaginasClass}">
                <label for="aantalPaginas">aantal pagina's dat het boek telt:</label>
                <input id="aantalPaginas" name="aantalPaginas" placeholder="200" type="number" value="${aantalPaginasPreviousValue}" required>
            </div>
            <input id="submit" class="submit" type="submit" value="Voeg dit boek toe">
        </form>
    </article>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>