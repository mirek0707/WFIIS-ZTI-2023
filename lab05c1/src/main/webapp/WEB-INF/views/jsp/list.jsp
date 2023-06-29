<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="insert">Add New Person</a>
<h1>People List</h1>
<table border="2" width="70%" cellpadding="2">
  <tr><th>Id</th><th>Fname</th><th>Lname</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
  <c:forEach var="person" items="${table}">
    <tr>
      <td>${person.id}</td>
      <td>${person.fname}</td>
      <td>${person.lname}</td>
      <td>${person.email}</td>
      <td><a href="edit?id=${person.id}">Edit</a></td>
      <td><a href="delete/${person.id}">Delete</a></td>
    </tr>
  </c:forEach>
</table>