<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="header.jsp"></jsp:include>
<main>
    <article>
        <h2>Verwijder dit Boek</h2>

        <p>Ben je zeker dat je het boek "${param.titel}" geschreven door ${param.auteur} wil verwijderen uit je lees lijst?</p>
        <form action="Servlet" method="post">
            <input type="hidden" name="titel" value="${param.titel}">
            <input class="submit" type="submit" name="command" value="zeker">
            <input class="submit" type="submit" value="Toch niet">
        </form>
    </article>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
