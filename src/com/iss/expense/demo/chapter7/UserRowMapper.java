package com.iss.expense.demo.chapter7;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 *	
 * @author wangwei
 * @date 2015年9月11日  上午10:23:43
 * @version	v1.0
 */
public class UserRowMapper implements RowMapper<UserModel> {
	
	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserModel model = new UserModel();
		model.setId(rs.getInt("id"));
		model.setUserName(rs.getString("user_name"));
		return model;
	}

}
