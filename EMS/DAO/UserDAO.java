package com.iim.EMS.DAO;

import java.awt.List;

import com.iim.EMS.Model.Login;
import com.iim.EMS.Model.User;

public interface UserDAO {
	boolean authenticationSuccess(String UserName, String Password);
	
	void UserRegistration(User userreg);
	
	static List getAllUsers(String username) {
		return null;
	}
	
	Login validateUser(Login login);

	
	}
	

