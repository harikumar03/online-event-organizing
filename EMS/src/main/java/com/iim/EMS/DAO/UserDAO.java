package com.iim.EMS.DAO;

public interface UserDAO {
	boolean authenticationSuccess(String UserName, String Password);
}
