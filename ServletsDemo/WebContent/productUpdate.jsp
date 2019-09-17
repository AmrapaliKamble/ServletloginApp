<%@page import="com.bv.model.Products"%>
<%@page import="com.bv.handler.ProductDBHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<% 
String p = request.getParameter("products");
	int id = Integer.parseInt(p);
	
	Products u = ProductDBHandler.getProductById(id);
	%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update2.jsp" method="post">
		<table align="center" style="border: 2px ; border-radius:7px  ; background : grey ; height:200px; width: 400px; padding-left: 20px">
			<tr>
				<td><lable>Product Name :</lable></td>
				<td><input type="text" name="productname" value="<%=u.getProductname()%>"/></td>
			</tr>
			<tr><td><input type="hidden" name="id" value="<%=u.getId()%>"/></td></tr>	
			<tr>
			<td><lable>Manufacturer Name :</lable></td>
				<td><select name="manufacturername"  >" style="width:150px; ">
				<option>Samsung</option>
				<option>Iphone</option>
				<option>Oppo</option>
				<option>MI</option>
				</select>
				</td>
			</tr>	
			<tr>
				<td><lable>Price:</lable></td>
				<td><input type="number" name="price" value="<%= u.getPrice()%>"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Products" /></td>
			</tr>
		
		</table>
	
	</form>
</body>
</html>