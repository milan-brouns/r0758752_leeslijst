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
<%ArrayList<Boek> boekenlijst = (ArrayList<Boek>) request.getAttribute("boekenLijst"); %>
<html>
<head>
    <title>boeken overzicht</title>
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
    <h2>Overzicht van alle boeken in de leeslijst</h2>
    <table>
        <tr>
            <th>titel</th>
            <th>auteur</th>
            <th>aantal pagina's</th>
            <th>verwijderen?</th>
        </tr>
       <%for (Boek boek: boekenlijst){%>
        <tr>
            <td><%=boek.getTitel()%></td>
            <td><%=boek.getAuteur()%></td>
            <td><%=boek.getAantalpaginas()%></td>
            <td><a href="Servlet?command=verwijder&titel=<%=boek.getTitel()%>&auteur=<%=boek.getAuteur()%>">verwijder</a></td>
        </tr>
        <%}%>

    </table>
</main>
<footer>
    <p>Web ontwikkeling 2 - 2020-2021 - project van Milan Brouns</p>
</footer>
</body>
</html>
