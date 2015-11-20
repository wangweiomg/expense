package com.iss.expense.demo.chapter7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wangwei
 * @date 2015年9月8日 上午10:04:23
 * @version v1.0
 */
public class TraditionalJdbcTest {
	private String user = "root";
	private String password = "";
	private String url="jdbc:mysql://localhost:3306/test";
		
	@BeforeClass
	public static void registerDriver() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Test
	public void test() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// 1. 获取JDBC连接
		try {
			conn = getConnection();

			// 2. 声明sql
			String sql = "select * from t_test";
			// 3. 预编译sql
			stmt = conn.prepareStatement(sql);
			// 4. 执行sql，返回结果集
			rs = stmt.executeQuery();
			// 5. 处理结果集
			process(rs);
			// 6. 释放结果集
			closeResultSet(rs);
			// 7. 释放statement
			closeStatement(stmt);
			// 8. 提交事务
//			conn.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 9. 处理异常并回滚事务
			conn.rollback();
			e.printStackTrace();
		} finally {
			// 10. 释放连接
			closeConnection(conn);
		}

	}

	/**
	 * @param stmt
	 */
	private void closeStatement(PreparedStatement stmt) {
		// TODO Auto-generated method stub
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param conn
	 * @throws SQLException 
	 */
	private void closeConnection(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		if (conn != null) {
			conn.close();
		}

	}


	/**
	 * @param rs
	 */
	private void closeResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 处理结果集
	 * 
	 * @param rs
	 * @throws SQLException 
	 */
	private void process(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			String userName = rs.getString(2);
			String password = rs.getString(3);
			System.out.println(userName + ":" + password);
		}
	}

	/**
	 * 
	 */
	private void process() {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取JDBC连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection(url, user, password);
	}
}
