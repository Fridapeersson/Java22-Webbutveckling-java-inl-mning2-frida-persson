<%@page import="model.JavaBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	//check if there is a session 
	if (session.getAttribute("isLoggedIn") != null) {
		
		JavaBean userBean = (JavaBean) session.getAttribute("isLoggedIn");
		out.print("<p>You are now logged in!</p>");
		out.print("<h1>Welcome to your profile " + userBean.getUserName() + "!</h1>");
		//Go to the RemoveSessionServlet 
		out.print("<p>Press the button to log out</p>");
		out.print("<form action=\"" + request.getContextPath() + "/RemoveSessionServlet\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"Log out\" />");
		out.print("</form>");
	} else {
		response.sendRedirect("index.jsp");
	}
	
	%>


</body>
</html>