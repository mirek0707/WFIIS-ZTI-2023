<%@ page import="zti.javaClasses.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Wyświetlanie</title>
</head>
<body>
    <%-- include menu.jsp in this JSP --%>
    <jsp:include page="Menu.jsp" flush="true" />
    <h1>Wyświetlanie zawartości bazy danych</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Miasto</th>
        </tr>
        <% List<Person> table = (ArrayList<Person>)request.getAttribute("table");
            for(Person person : table)
            {
                out.print("<tr>");
                out.print("<td>" + person.getId() + "</td>");
                out.print("<td>" + person.getFname() + "</td>");
                out.print("<td>" + person.getLname() + "</td>");
                out.print("<td>" + person.getCity() + "</td>");
                out.print("</tr>");
            }

        %>
    </table>

</body>
</html>
