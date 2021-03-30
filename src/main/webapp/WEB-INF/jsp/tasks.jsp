<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Tasks</h2>

<table style="float:left">
   <tr><th>ID</th><th>Name</th><th>Description<th>Email</th><th>Severity<th>Start Date</th> <th>End Date</th> <th>User</th> <th>Action</th></tr>
   <c:forEach items="${tasks}" var="task" varStatus="count">
    <tr id="${count.index}">
    	<td>${task.taskid}</td>
        <td>${task.name}</td>
        <td>${task.description}</td>
        <td>${task.email}</td>
        <td>${task.severity}</td>
        <td>${task.startDate}</td>
        <td>${task.endDate}</td>
        <td>${task.user}</td>
        <td><a href="/updateTask/${task.taskid}">Edit</a></td>
    </tr>
  </c:forEach>
</table>


</body>
</html>