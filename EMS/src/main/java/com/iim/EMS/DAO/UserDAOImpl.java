package com.iim.EMS.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

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

		}

