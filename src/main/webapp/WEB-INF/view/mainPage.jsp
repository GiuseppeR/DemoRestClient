<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Main Page</title>
</head>
<body>
	<h2>Insert New Customer</h2>

	<form action="${pageContext.request.contextPath}/demoClient"
		method="post">
		<table>
			<tr>
				<td><label for="firstName">First Name:</label></td>
				<td><input type="text" id="firstName" name=firstName />
			</tr>
			<tr>
				<td><label for="lastName">Last Name:</label></td>
				<td><input type="text" id="lastName" name="lastName" /></td>
			</tr>
			<tr>
				<td><label for="age">Age:</label></td>
				<td><input type="text" id="age" name="age" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="OK" /></td>
			</tr>
		</table>
	</form>

	<br />
	<br />

	<form action="${pageContext.request.contextPath}/demoClient"
		method="get">
		<h2>Get Customer's List</h2>
		<p>
			<input type=submit value="Get List">
		</p>
	</form>

	<br />
	<br />

	<form action="${pageContext.request.contextPath}/demoClient"
		method="get">
		<h2>Get a Customer</h2>
		<p>
			<label for="age">Insert ID:</label>
		</p>
		<p>
			<input type="text" id="id" name="id" />
		</p>
		<p>
			<input type=submit value="Get Customer">
		</p>
	</form>

	<br />
	<br />

	<h2>Modify Customer</h2>

	<form
		action="${pageContext.request.contextPath}/demoClient?_method=put"
		method="post">
		<table>
			<tr>
				<td><label for="id">Id:</label></td>
				<td><input type="text" id="id" name=id /></tr>
			<tr>
				<td><label for="firstName">First Name:</label></td>
				<td><input type="text" id="firstName" name=firstName />
			</tr>
			<tr>
				<td><label for="lastName">Last Name:</label></td>
				<td><input type="text" id="lastName" name="lastName" /></td>
			</tr>
			<tr>
				<td><label for="age">Age:</label></td>
				<td><input type="text" id="age" name="age" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="OK" /></td>
			</tr>
		</table>
	</form>

	<br />
	<br />

	<form action="${pageContext.request.contextPath}/demoClient?_method=delete"
		method="post">
		<h2>Delete a Customer</h2>
		<p>
			<label for="age">Insert ID:</label>
		</p>
		<p>
			<input type="text" id="id" name="id" />
		</p>
		<p>
			<input type=submit value="Delete Customer">
		</p>
	</form>
	
</body>
</html>