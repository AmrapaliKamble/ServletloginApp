package com.bv.serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.connection.DBConnect;


@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	String uname = request.getParameter("username");
	String upass = request.getParameter("password");
	Connection con = null;
	try {
		con = DBConnect.getConnection();
		PreparedStatement s = con.prepareStatement("select * from users where username = ? and password = ?");
		s.setString(1, uname);
		s.setString(2, upass);
		RequestDispatcher rd;
		ResultSet rs = s.executeQuery();
		if(rs.next()) {
		rd =	request.getRequestDispatcher("viewProducts.jsp");
		rd.forward(request, response);
		}else {
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		rs.close();
		s.close();
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	
}

}
