package com.bv.dao;

public class LoginDao {
	public static boolean validateUser(String username,String password)
	{
		if(username.equals("admin") && password.equals("pass"))
			return true;
		return false;
	}
}
