package com.iim.EMS.DAO;

import com.iim.EMS.Model.User;

public interface UserDAO {
	boolean authenticationSuccess(String UserName, String Password);
	
	void UserRegistration(User userreg);
}
