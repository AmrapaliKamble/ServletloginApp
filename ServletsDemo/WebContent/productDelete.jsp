<%@page import="com.bv.handler.ProductDBHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String p = request.getParameter("id");
	int id = Integer.parseInt(p);
	
	ProductDBHandler.deleteProducts(id);
	response.sendRedirect("viewProducts.jsp");
%>