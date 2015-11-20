package com.iss.expense.demo.chapter3;

/**
 *
 * @author wangwei
 * @date 2015年8月26日 下午4:51:48
 * @version v1.0
 */
public class BeanDefinition {
	// 单例
	public static final int SCOPE_SINGLETON = 0;
	// 原型
	public static final int SCOPE_PROTOTYPE = 1;
	// 唯一标识
	private String id;
	// class全限定名
	private String clazz;
	
	// 作用域
	private int scope = SCOPE_SINGLETON;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

}
