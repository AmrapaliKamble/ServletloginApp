<%@page import="com.bv.handler.ProductDBHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="Products" class="com.bv.model.Products" ></jsp:useBean>
<jsp:setProperty property="*" name="Products"/>

<%
	ProductDBHandler.updateProducts(Products);
	response.sendRedirect("viewProducts.jsp");
%>