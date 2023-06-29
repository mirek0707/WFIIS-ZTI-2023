<%--
  Created by IntelliJ IDEA.
  User: 9kolodziejmir
  Date: 3/21/23
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dodawanie</title>
</head>
<body>
<%-- include menu.jsp in this JSP --%>
<jsp:include page="Menu.jsp" flush="true" />
<h1>Dodawanie danych do bazy</h1>
<form name="form1" method="post" action="${pageContext.request.contextPath}/ZadDomMVC?action=dodawanie">
    <label>Imię: </label> <input type="text" name="fname"></input><br />
    <label>Nazwisko: </label> <input type="text" name="lname"></input><br />
    <label>Miasto: </label> <input type="text" name="city"></input><br />
    <input type="submit"></input>
</form>
</body>
</html>
