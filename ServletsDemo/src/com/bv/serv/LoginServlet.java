package com.bv.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bv.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
     super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		if(LoginDao.validateUser(username, password)) {
			HttpSession session = request.getSession();
			rd  = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
			
		}
		else {
			
			out.print("Invalid Credential");
			rd  = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
