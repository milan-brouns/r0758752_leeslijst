<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.DB.LeesLijst" %>
<%@ page import="model.domain.Boek" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 02-Oct-20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boeken overzicht</title>
    <link href="css/reset.css" rel="stylesheet">
    <link href="css/style_leeslijst.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="overzicht"/>
</jsp:include>
<main>
    <h2>Overzicht van alle boeken in de leeslijst</h2>
    <c:choose>
        <c:when test="${boekenLijst != null}">
            <table>
                <tr>
                    <th>titel</th>
                    <th>auteur</th>
                    <th>aantal pagina's</th>
                    <th>verwijderen?</th>
                    <th>updaten?</th>
                </tr>
                <c:forEach var="boek" items="${boekenLijst}">
                <tr>
                    <td>${boek.titel}</td>
                    <td>${boek.auteur}</td>
                    <td>${boek.aantalpaginas}</td>
                    <td><a href="Servlet?command=verwijder&titel=${boek.titel}&auteur=${boek.auteur}">verwijder</a></td>
                    <td><a href="Servlet?command=update&boekTitel=${boek.titel}">update</a></td>
                </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p class="enkelep">U heeft alle voorgestelde boeken verwijderd. voegzelf een boek toe om een overzicht te krijgen.</p>
        </c:otherwise>
    </c:choose>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
