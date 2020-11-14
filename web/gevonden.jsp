<%@ page import="model.domain.Boek" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 25-Oct-20
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style_leeslijst.css">
    <title>gevonden boek</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>

<main>
    <p class="enkelep">je vroeg naar de volgende gegevens: '${boek.titel}' geschreven door ${boek.auteur} en telt ${boek.aantalpaginas} pagina's.</p>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
