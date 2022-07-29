<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Biricik Company Home Page</title>
</head>

<body>
	<h2>Biricik Company Home Page</h2>
	<hr>

	Welcome to the Biricik company home page!

	<!-- Display user name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br/>
		Role(s): <security:authentication property="principal.authorities"/>
	
	
	</p>


	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>

</html>