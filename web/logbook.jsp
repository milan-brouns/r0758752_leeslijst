<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 30-Dec-20
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logboek</title>
    <link href="css/reset.css" rel="stylesheet">
    <link href="css/style_leeslijst.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="logboek"/>
</jsp:include>
<main>
    <h2>Logboek van alle veranderingen aan je leeslijst</h2>
    <c:choose>
        <c:when test="${logboek != null}">
            <table>
                <tr>
                    <th>datum</th>
                    <th>tijdstip</th>
                    <th>activiteit</th>
                </tr>
                <c:forEach var="log" items="${logboek}">
                    <tr>
                        <td>${log.datum}</td>
                        <td>${log.tijdstip}</td>
                        <td>${log.activiteit}</td>
                        </tr>
                </c:forEach>
            </table>
            <form method="post" action="Servlet?command=resetSession" novalidate>
                <input id="submit" class="submit" type="submit" value="reset je activiteiten">
            </form>
        </c:when>
        <c:otherwise>
            <p class="enkelep">U heeft momenteel nog geen activiteiten uitgevoert tijdens u sessie.</p>
        </c:otherwise>
    </c:choose>
</main>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
