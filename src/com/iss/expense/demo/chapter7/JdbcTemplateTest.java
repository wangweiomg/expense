package com.iss.expense.demo.chapter7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterBatchUpdateUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author wangwei
 * @date 2015年9月8日 上午10:38:56
 * @version v1.0
 */
public class JdbcTemplateTest {
	private static JdbcTemplate jdbcTemplate;
	
	@Test
	public void testSimpleJdbcTemplate(){
		SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(jdbcTemplate);
		String insertSql = "insert into test(user_name) values(?)";
		simpleJdbcTemplate.update(insertSql, "name5");
		String selectSql = "select * from test where id=? and user_name=?";
		List<Map<String, Object>> result = simpleJdbcTemplate.queryForList(selectSql, 1, "name5");
		System.out.println(result.get(0));
		RowMapper<UserModel> mapper = new UserRowMapper();
		List<UserModel> result2 = simpleJdbcTemplate.query(selectSql, mapper, 1, "name5");
		System.out.println(result2);
		
	}
	public void testNamedParameterJdbcTemplate2(){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		UserModel user = new UserModel();
		user.setUserName("name5");
		String insertSql = "insert into test(user_name) values(:userName)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(insertSql, paramSource);
	}
	public void testNamedParameterJdbcTemplate1() {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String insertSql = "insert into test(user_name) values(:name)";
		String selectSql = "select *from test where user_name=:name";
		String deleteSql = "delete from test where user_name=:name";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", "name5");
		namedParameterJdbcTemplate.update(insertSql, paramMap);
		final List<Object> result = new ArrayList<Object>();
		namedParameterJdbcTemplate.query(selectSql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						result.add(rs.getInt("id"));
						result.add(rs.getString("user_name"));
					}
				});
		System.out.println(result);
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		namedParameterJdbcTemplate.update(deleteSql, paramSource);
		
	}

	// @Test no procedure available
	public void testCallableStatementCreator3() {
		final String callProcedureSql = "{call PROCEDURE_TEST(?, ?)}";
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlInOutParameter("inOutName", Types.VARCHAR));
		params.add(new SqlOutParameter("outId", Types.INTEGER));
		Map<String, Object> outValues = jdbcTemplate.call(
				new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(
							Connection conn) throws SQLException {
						CallableStatement cstmt = conn
								.prepareCall(callProcedureSql);
						cstmt.registerOutParameter(1, Types.VARCHAR);
						cstmt.registerOutParameter(2, Types.INTEGER);
						cstmt.setString(1, "test");
						return cstmt;
					}
				}, params);
		System.out.println(outValues.get("outId"));
	}

	public void testCallableStatementCreator2() {
		String createFunctionSql = "CREATE FUNCTION FUNCTION_TEST(str VARCHAR(100))"
				+ " returns INT return LENGTH(str)";
		String dropFunctionSql = "DROP FUNCTION IF EXISTS FUNCTION_TEST";
		jdbcTemplate.update(dropFunctionSql);
		jdbcTemplate.update(createFunctionSql);
		// 准备sql，
		final String callFunctionSql = "{?= call FUNCTION_TEST(?)}";
		// 定义参数
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlOutParameter("result", Types.INTEGER));
		params.add(new SqlParameter("str", Types.VARCHAR));
		Map<String, Object> outvalues = jdbcTemplate.call(
				new CallableStatementCreator() {

					@Override
					public CallableStatement createCallableStatement(
							Connection conn) throws SQLException {
						CallableStatement cstmt = conn
								.prepareCall(callFunctionSql);
						cstmt.registerOutParameter(1, Types.INTEGER);
						cstmt.setString(2, "test");
						return cstmt;
					}
				}, params);
		System.out.println(outvalues.get("result"));
	}

	public void testQuery() {
		jdbcTemplate.update("insert into test(user_name) values('tencent')");
		jdbcTemplate.update("insert into test(user_name) values('baidu')");
		// 1. 查询一行数据并返回int型结果
		int count = jdbcTemplate.queryForInt("select count(*) from test");
		System.out.println(count);
		// 2. 查询一行数据并将该行数据转换为Map返回
		Map<String, Object> map = jdbcTemplate
				.queryForMap("select * from test where user_name='baidu'");
		System.out.println(map);
		// 3. 查询一行任何了性数据，最后一个参数指定返回结果类型
		int cnt = jdbcTemplate.queryForObject("select count(*) from test",
				Integer.class);
		System.out.println(cnt);
		// 4. 查询一批数据，默认将每行数据转换为map
		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select * from test");
		for (Map<String, Object> map2 : list) {
			System.out.println(map2);
		}
		// 5. 只查询一列数据，列类型是String类型，列名字是name
		List<String> name = jdbcTemplate.queryForList(
				"select user_name from test where id=?", new Object[] { 2 },
				String.class);
		System.out.println(name);

		// 6. 查询一批数据，返回SqlRowSet,类似于ResultSet，但不再绑定到连接上
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from test");
		while (rs.next()) {
			System.out.println(rs.getString(2));

		}

	}

	public <T> void testResultSert3() {
		jdbcTemplate.update("insert into test(user_name) values('163')");
		String listSql = "select * from test";
		List<Map<Integer, String>> result = jdbcTemplate.query(listSql,
				new ResultSetExtractor<List<Map<Integer, String>>>() {

					@Override
					public List<Map<Integer, String>> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Map<Integer, String>> result = new ArrayList<Map<Integer, String>>();
						while (rs.next()) {
							Map<Integer, String> row = new HashMap<Integer, String>();
							row.put(rs.getInt("id"), rs.getString("user_name"));
							result.add(row);
						}
						for (Map<Integer, String> map : result) {
							System.out.println(map);
						}
						return result;
					}
				});
		for (Map<Integer, String> map : result) {
			System.out.println(map);
		}
		jdbcTemplate.update("delete from test  where user_name='163'");
	}

	public void testResultSet1() {
		jdbcTemplate.update("insert into test(user_name) values('sohu')");
		jdbcTemplate.update("insert into test(user_name) values('baidu')");
		String listSql = "select * from test";
		List<Map<Integer, Object>> result = jdbcTemplate.query(listSql,
				new RowMapper<Map<Integer, Object>>() {
					@Override
					public Map<Integer, Object> mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map<Integer, Object> row = new HashMap<Integer, Object>();
						row.put(rs.getInt("id"), rs.getString("user_name"));
						return row;
					}
				});
		for (Map<Integer, Object> map : result) {
			System.out.println(map);
		}
	}

	public void testPreparedStatement2() {
		String insertSql = "insert into test(user_name) values(?)";
		int count = jdbcTemplate.update(insertSql,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt)
							throws SQLException {
						// TODO Auto-generated method stub
						pstmt.setObject(1, "sina");
					}
				});
		System.out.println(count);
		String deleteSql = "delete from test where user_name=?";
		count = jdbcTemplate.update(deleteSql, new Object[] { "sina" });
		System.out.println(count);
	}

	public void testPreparedStatement1() {
		int count = jdbcTemplate.execute(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				String sql = "select count(*) from test";
				return conn.prepareStatement(sql);
			}
		}, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				pstmt.execute();
				ResultSet rs = pstmt.getResultSet();
				rs.next();
				System.out.println(rs.getInt(1));
				return rs.getInt(1);
			}
		});
	}

	@BeforeClass
	public static void setUpClass() {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url,
				username, password);
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void testCRUD() {
		insert();
		// update();
		select();
		// delete();
	}

	private void select() {
		final List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		jdbcTemplate.query("select * from test", new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("user_name", rs.getString("user_name"));
				row.put("password", rs.getString("password"));
				result.add(row);
			}
		});
		for (Map<String, Object> map : result) {
			System.out.println(map);
		}
	}

	/**
	 * 
	 */
	private void update() {
		// TODO Auto-generated method stub
		jdbcTemplate
				.update("update test set password='tencent' where user_name='tencent'");

	}

	private void delete() {
		jdbcTemplate.update("delete from test");
		int count = jdbcTemplate.queryForInt("select count(*) from test");
		System.out.println(count);
	}

	/**
	 * 
	 */
	private void insert() {
		// TODO Auto-generated method stub
		jdbcTemplate
				.update("insert into test(user_name, password) values('tencent', '123456')");
		jdbcTemplate
				.update("insert into test(user_name, password) values('baidu', 'qwerdf')");
		jdbcTemplate
				.update("insert into test(user_name, password) values('ali', 'ayyy')");
		int count = jdbcTemplate.queryForInt("select count(*) from test");
		System.out.println(count);
	}

	public void test() {
		// 1. 声明sql
		String sql = "select * from t_test";
		jdbcTemplate.query(sql, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// 2. 处理结果集
				while (rs.next()) {
					String userName = rs.getString(2);
					System.out.println(userName);
				}
			}
		});
	}

	@Before
	public void setUp() {
		String createTableSql = "create table test(id int primary key auto_increment, user_name varchar(30), password varchar(30))";
		jdbcTemplate.update(createTableSql);
	}

	@After
	public void tearDown() {
		String dropTableSql = "drop table test";
		jdbcTemplate.execute(dropTableSql);
	}

}
