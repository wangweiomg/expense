package com.iss.expense.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 数据访问基类
 * @author wangwei
 * @date 2015年8月7日  上午9:33:14
 * @version	v1.0
 */
@Repository
public class BaseDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查找单个结果
	 * @param statement
	 * @return
	 */
	public <T> T selectOne(String statement){
		return sqlSessionTemplate.selectOne(statement);
	}
	
	public <T> T selectOne(String statement, Object parameter){
		return sqlSessionTemplate.selectOne(statement, parameter);
	}
	
	/**
	 * Map结果返回
	 * @param statement
	 * @param mapKey
	 * @return
	 */
	public <K, V> Map<K, V> selectMap(String statement, String mapKey){
		return sqlSessionTemplate.selectMap(statement, mapKey);
	}
	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey){
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}
	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey,
			RowBounds rowBounds){
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey, rowBounds);
	}
	
	/**
	 * 返回List列表
	 * @param statement
	 * @return
	 */
	public <E> List<E> selectList(String statement){
		return sqlSessionTemplate.selectList(statement);
	}
	public <E> List<E> selectList(String statement, Object parameter){
		return sqlSessionTemplate.selectList(statement, parameter);
	}
	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds){
		return sqlSessionTemplate.selectList(statement, parameter, rowBounds);
	}
	
	public void select(String statement, ResultHandler handler){
		sqlSessionTemplate.select(statement, handler);
	}
	public void select(String statement, Object parameter, ResultHandler handler){
		sqlSessionTemplate.select(statement, parameter, handler);
	}
	public void select(String statement, Object parameter, RowBounds rowBounds,
			ResultHandler handler){
		sqlSessionTemplate.select(statement, parameter, rowBounds, handler);
	}
	
	/**
	 * 插入数据
	 * @param statement
	 * @return 受影响的行数
	 */
	public int insert(String statement){
		return sqlSessionTemplate.insert(statement);
	}
	public int insert(String statement, Object parameter){
		return sqlSessionTemplate.insert(statement, parameter);
	}
	
	/**
	 * 更新数据
	 * @param statement
	 * @return
	 */
	public int update(String statement){
		return  sqlSessionTemplate.update(statement);
	}
	public int update(String statement, Object parameter){
		return sqlSessionTemplate.update(statement, parameter);
	}
	
	/**
	 * 删除数据
	 * @param statement
	 * @return
	 */
	public int delete(String statement){
		return sqlSessionTemplate.delete(statement);
	}
	public int delete(String statement, Object parameter){
		return sqlSessionTemplate.delete(statement, parameter);
	}
}
