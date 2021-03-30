<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<body>
<h2>Update User</h2>
<form:form method="post" modelAttribute="user" action="/update">
	<table>
		<tr>
			<td><form:hidden path="id" /></td>
		</tr>
		
		<tr>
			<td><form:label path="name">Name</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Password</form:label></td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
        	<td><input type="submit" value="Submit"/></td>
        </tr>
        
	</table>
</form:form>
</body>
</html>
