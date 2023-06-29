<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Person</title>
</head>
<body>
<h1>Edit Person</h1>
<form:form method="POST" modelAttribute="person" action="${pageContext.request.contextPath}/mvc/save${person.id}">
    <table>
        <tr>
            <td><form:label path="id">ID:</form:label></td>
            <td><form:input path="id" readonly="true" /></td>
        </tr>
        <tr>
            <td><form:label path="fname">First Name:</form:label></td>
            <td><form:input path="fname" /></td>
        </tr>
        <tr>
            <td><form:label path="lname">Last Name:</form:label></td>
            <td><form:input path="lname" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="city">City:</form:label></td>
            <td><form:input path="city" /></td>
        </tr>
        <tr>
            <td><form:label path="tel">Telephone:</form:label></td>
            <td><form:input path="tel" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save Changes" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>