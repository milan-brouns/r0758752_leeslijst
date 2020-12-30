<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 12-Nov-20
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <h1>leeslijst</h1>
    <nav>
        <ul>
            <li<c:if test="${param.current eq 'home'}"> class="current"</c:if>><a href="Servlet">Home pagina</a></li>
            <li<c:if test="${param.current eq 'zoek'}"> class="current"</c:if>><a href="zoek.jsp">zoek een boek</a></li>
            <li<c:if test="${param.current eq 'voegToe'}"> class="current"</c:if>><a href="voegToe.jsp">voeg een boek toe</a></li>
            <li<c:if test="${param.current eq 'overzicht'}"> class="current"</c:if>><a href="Servlet?command=overzicht">overzicht van boeken</a></li>
            <li<c:if test="${param.current eq 'logboek'}"> class="current"</c:if>><a href="logbook.jsp">logboek</a></li>
        </ul>
    </nav>
</header>

