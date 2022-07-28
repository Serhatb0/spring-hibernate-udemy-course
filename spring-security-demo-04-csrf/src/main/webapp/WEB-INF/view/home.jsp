<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Biricik Company Home Page</title>
</head>

<body>
	<h2>Biricik Company Home Page</h2>
	<hr>

	Welcome to the Biricik company home page!


	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>

</html>