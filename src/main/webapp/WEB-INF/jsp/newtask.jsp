<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<body>
<h2>New Task</h2>
	<form action="/newtask" method="POST">
		<table>
			<tr>
				<td> <label>Name: </label></td>
				<td> <input type="textbox" name="name" required> </td>
			</tr>
			<tr>
				<td> <label>Description </label></td>
				<td> <input type="textbox" name="desc" required> </td>
			</tr>
			<tr>
				<td> <label>Email: </label></td>
				<td> <input type="email" name="email" required> </td>
			</tr>
			<tr>
				<td> <label>Severity: </label></td>
				<td> <select name="severity">
						<option value="1">Low</option>
						<option value="2">Medium</option>
						<option value="3">High</option>
					</select></td>
			</tr>
			<tr>
				<td> <label>Start Date:</label></td>
				<td> <input type="date" name="startString" required></td>
			</tr>
			<tr>
				<td> <label>End Date:</label>
				<td> <input type="date" name="endString" required></td>
			</tr>
			<tr>
				<td> <input type="submit" value="Create Task"></td>
			</tr>
		</table>
	</form>
</body>
</html>
