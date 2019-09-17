<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Logged in successfully</h1>
		<%String uname = request.getParameter("username");%>
		
		<h1>welcome <% out.println(uname); %> ! </h1>
		<a href="login.html">Login Page</a>
</body>
</html>