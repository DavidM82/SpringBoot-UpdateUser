<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<body>
<h2>Update Task</h2>
<form:form method="post" modelAttribute="task" action="/updatetask">
	<table>
		<tr>
			<td><form:hidden path="taskid" /></td>
		</tr>
		<tr>
			<td><form:hidden path="user" /></td>
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
			<td><form:label path="description">Description</form:label></td>
			<td><form:input path="description" /></td>
		</tr>
		<tr>
			<td><form:label path="severity">Severity</form:label></td>
			<td><form:select path="severity">
				<form:option value="1">Low</form:option>
				<form:option value="2">Medium</form:option>
				<form:option value="3">High</form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><form:label name="startString" path="startDate">Start Date</form:label>
				<input type="date" name="startString" path="startDate" value=${startdate} />
			</td>
		</tr>
		<tr>
			<td><form:label name="endString" path="endDate">End Date</form:label>
			<input type="date" name="endString" path="endDate" value=${enddate} />
		</tr>
		<tr>
        	<td><input type="submit" value="Submit"/></td>
        </tr>
        
	</table>
</form:form>
</body>
</html>
