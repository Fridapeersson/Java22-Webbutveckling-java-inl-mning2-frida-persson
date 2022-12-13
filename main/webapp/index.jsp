<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>uppg2</title>
</head>
<body>

	<%
	// Kollar om det finns session
	if (session.getAttribute("isLoggedIn") != null) {
		response.sendRedirect("Profile.jsp");
	}
	%>
	<h1>Log in</h1>
	<!-- Login form -->
	<form action="<%=request.getContextPath()%>/SessionServlet"
		method="POST">
		Username: <input type="text" name="username" placeholder="Username" />
		<br>
		Password: <input type="password" name="password" placeholder="Password" />
		<br>
		<input type="submit" value="Log in" />
	</form>
</body>
</html>