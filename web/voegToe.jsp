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
        <h2>vul de velden in om je boek toe te voegen</h2>
        <%if (request.getAttribute("error") !=null){
            String error = (String) request.getAttribute("error");
        %>
        <p id="error"><%=error%></p>
        <%}%>
        <form method="post" action="Servlet?command=voegToe" novalidate>
            <label for="titel">Titel van je boek:</label>
            <input id="titel" name="titel" placeholder="titel" type="text" required>
            <label for="auteur">de auteur van je boek:</label>
            <input id="auteur" name="auteur" placeholder="auteur" type="text" required>
            <label for="aantalPaginas">aantal pagina's dat het boek telt:</label>
            <input id="aantalPaginas" name="aantalPaginas" placeholder="200" type="number" value="5">
            <input id="submit" class="submit" type="submit" value="Voeg dit boek toe">
        </form>
    </article>
</main>
<footer>
    <p>Web ontwikkeling 2 - 2020-2021 - project van Milan Brouns</p>
</footer>
</body>
</html>