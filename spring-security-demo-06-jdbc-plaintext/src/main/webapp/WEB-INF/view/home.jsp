<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

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
		User:
		<security:authentication property="principal.username" />
		<br /> Role(s):
		<security:authentication property="principal.authorities" />


	</p>
	<hr>

	<!-- Add a link to point to /leaders ... this is for the managers -->

	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Meeting</a> (Only for Manager peeps)
		</p>
	</security:authorize>
	<!-- Add a link to point to /systems ... this is for the admins -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a> (Only for Admin peeps)
		</p>
	</security:authorize>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>

</html>