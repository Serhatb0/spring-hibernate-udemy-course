<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>


<body>

The Student is Confirmed: ${student.firstName} ${student.lastName}
<br/>
Country: ${student.country}
<br/>

Favorite Language: ${student.favoriteLanguage}

<br/>
Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystem}">

		<li> ${temp} </li>

	</c:forEach>
</ul>
</body>

</html>