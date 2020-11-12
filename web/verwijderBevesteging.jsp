<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 25-Oct-20
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijder dit boek</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style_leeslijst.css">
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
        <h2>Verwijder dit Boek</h2>

        <p>Ben je zeker dat je het boek "<%=request.getParameter("titel")%>" geschreven door "<%=request.getParameter("auteur")%>" wil verwijderen uit je lees lijst?</p>
        <form action="Servlet" method="post">
            <input type="hidden" name="titel" value="<%=request.getParameter("titel")%>">
            <input class="submit" type="submit" name="command" value="zeker">
            <input class="submit" type="submit" value="Toch niet">
        </form>
    </article>
</main>
<footer>
    <p>Web ontwikkeling 2 - 2020-2021 - project van Milan Brouns</p>
</footer>
</body>
</html>
