package com.bv.handler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bv.connection.DBConnect;
import com.bv.model.Products;

public class ProductDBHandler {
	
	public static int addProducts(Products products) {
		int status = 0;
		String sql= "insert into products(productname,manufacturername,price)"
				+"values(?,?,?)";
		Connection connection = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, products.getProductname());
			pstmt.setString(2, products.getManufacturername());
			pstmt.setDouble(3, products.getPrice());
			status = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static int updateProducts(Products products) {
		
		int status = 0;
		String sql= "update products set productname=?,manufacturername=?,price=?"
				+" where id=?";
		Connection connection = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, products.getProductname());
			pstmt.setString(2, products.getManufacturername());
			pstmt.setDouble(3, products.getPrice());
			pstmt.setInt(4, products.getId());
			status = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteProducts(int id) {
		int status = 0;
		String sql ="delete from products where id=?";
		Connection connection = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List<Products> getAllProducts(){
		List<Products> productlist = new ArrayList<>();
		String sql = "select * from products";
		
		Connection connection = DBConnect.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql) ;
			while(rs.next()) {
				Products products= new Products();
				products.setId(rs.getInt("id"));
				products.setProductname(rs.getString("productname"));
				products.setManufacturername(rs.getString("manufacturername"));
				products.setPrice(rs.getDouble(4));
				productlist.add(products);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productlist;
	}
	
	public static Products getProductById(int id) {
		Products u = new Products();
		try {
		
			Connection connection=DBConnect.getConnection();
			PreparedStatement s = connection.prepareStatement(
					"select * from products where id = ?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			if(rs.next()) {				
				u.setId(rs.getInt(1));
				u.setProductname(rs.getString(2));
				u.setManufacturername(rs.getString(3));
				u.setPrice(rs.getDouble(4));			
			}
			rs.close();
	//		con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return u;
		
	}
}
