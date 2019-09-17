<%@page import="com.bv.model.Products"%>
<%@page import="java.util.List"%>
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
	<h1>List All Products</h1>
	
	<%
		List<Products> list = ProductDBHandler.getAllProducts();
	%>
	<h3 style="text-align: right;"></h3>
	<table align="center"style="background-color: gray; border-radius: 7px; color: #ffffff; height: 200px; width: 500px">
		<%
			for (Products p : list) {
		%>
		<td>
		<tr style="text-align: center;">
			<td><%=p.getId()%></td>
			<td><%=p.getProductname()%></td>
			<td><%=p.getManufacturername()%></td>
			<td><%=p.getPrice()%></td>
			<td><a href="productUpdate.jsp?products=<%=p.getId()%>" style="color: white;">update</a></td>
			<td><a href="productDelete.jsp?id=<%=p.getId()%>"style="color: white;">Delete</a></td>
			<td><a href="getById.jsp?pid=<%=p.getId()%>"style="color: white;">Select</a></td>

		</tr>
		</td>

		<%
			}
		%>
		
</table>
        <a href="products.html">Add Products</a></br>
		<a href = "LogOutServlet">Log out</a>
</body>
</html>