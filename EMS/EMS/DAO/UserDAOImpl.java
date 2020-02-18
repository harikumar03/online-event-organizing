package com.iim.EMS.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iim.EMS.Model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		@Autowired
		NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		public void setjDBCTemplate(JdbcTemplate jDBCTemplate) {
			this.jdbcTemplate = jDBCTemplate;
			}
		public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
			this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
}
		@Override
		public boolean authenticationSuccess(String username, String password)
		{
		String sql="SELECT COUNT(Num_login_id) AS CNT FROM Tbl_mst_login WHERE Vch_user_name ='"+username+"' AND Vch_password ='"+password+"'";
		System.out.print(sql);
		int cnt = jdbcTemplate.queryForObject(sql, Integer.TYPE);
		System.out.println(cnt);
		if(cnt>0)
		return true;
		else
		return false;
		}
		
		@Override
		public void UserRegistration(User userreg)
		{
			String sql="insert into tbl_mst_UserRegistration (sno,enrollDate,username,password) values "+
					"("+userreg.getSno()+",sysdate,'"+userreg.getUsername()+"','"+userreg.getPassword()+"')";
			System.out.print(sql);
			jdbcTemplate.update(sql);
			
		}	
		}

