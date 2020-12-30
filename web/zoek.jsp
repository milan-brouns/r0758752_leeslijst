<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 25-Oct-20
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style_leeslijst.css">
    <title>Zoek een boek</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="zoek"/>
</jsp:include>
<main>
    <article>
        <h2>zoek een boek in de leeslijst</h2>
        <form action="Servlet" method="get" novalidate>
            <p>geef de titel van het boek dat je zoekt:</p>
            <label for="titel">titel:</label>
            <input id="titel" name="titel" type="text" required>
            <input class="submit" type="submit"name="command" value="zoek">
        </form>
    </article>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
