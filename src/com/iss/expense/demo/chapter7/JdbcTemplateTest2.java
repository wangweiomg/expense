package com.iss.expense.demo.chapter7;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *	
 * @author wangwei
 * @date 2015年9月8日  上午10:58:59
 * @version	v1.0
 */
public class JdbcTemplateTest2 {
	
	private static JdbcTemplate jdbcTemplate;  
	static{
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		String driverClassName = "com.mysql.jdbc.Driver";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassName);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Test
	public void test(){
		String sql = "select * from t_test";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()){
					String userName = rs.getString(2);
					System.out.println(userName);
				}
			}
		});
	}
}
