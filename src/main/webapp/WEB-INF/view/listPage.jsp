<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Page</title>
</head>
<body>
	<h2>List Page</h2>

	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${list}" var="customer">
			<tr>
				<td><c:out value="${customer.id}" /></td>
				<td><c:out value="${customer.firstName}" /></td>
				<td><c:out value="${customer.lastName}" /></td>
				<td><c:out value="${customer.age}" /></td>
			</tr>
		</c:forEach>
	</table>

	<a href="${pageContext.request.contextPath}/demoClient/mainView">Return
		Back</a>

</body>
</html>