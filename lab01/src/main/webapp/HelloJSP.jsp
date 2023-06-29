<%--
  Created by IntelliJ IDEA.
  User: 9kolodziejmir
  Date: 3/14/23
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP and JavaBean</title>
</head>
<body>

<jsp:useBean id="dateBean" scope="application" class="zti.beans.DateBean" />
<h1>Odczyt danych z JavaBean</h1>
<br />
<p>Dzisiaj jest: ${dateBean.currentDate} !</p>

</body>
</html>
