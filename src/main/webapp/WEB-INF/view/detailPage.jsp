<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Detail Page</title>
</head>
<body>
	<h2>Detail Page</h2>

	<table>
		<tr>
			<td><output>First Name:</output></td>
			<td><c:out value="${customer.firstName}"/></td>
		</tr>
		<tr>
			<td><output>Last Name:</output></td>
			<td><c:out value="${customer.lastName}"/></td>
		</tr>
		<tr>
			<td><output>Age:</output></td>
			<td><c:out value="${customer.age}"/></td>
		</tr>
	</table>

	<a href="${pageContext.request.contextPath}/demoClient/mainView">Return
		Back</a>
</body>
</html>