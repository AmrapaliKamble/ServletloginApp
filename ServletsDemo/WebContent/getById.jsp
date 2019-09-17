<%@page import="com.bv.handler.ProductDBHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String p = request.getParameter("pid");
	int id = Integer.parseInt(p);
	
	ProductDBHandler.getProductById(id);
	response.sendRedirect("viewProducts.jsp");
    %>
</body>
</html>