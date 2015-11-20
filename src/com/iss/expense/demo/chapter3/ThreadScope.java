package com.iss.expense.demo.chapter3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *	
 * @author wangwei
 * @date 2015年8月27日  上午10:35:38
 * @version	v1.0
 */
public class ThreadScope implements Scope {
	
	private final ThreadLocal<Map<String, Object>> THREAD_SCOPE = 
			new ThreadLocal<Map<String,Object>>(){
		protected Map<String, Object> initalValue(){
			// 用于存放线程相关Bean
			return new HashMap<String, Object>();
		}
	};
	
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		// 如果当前线程已经绑定了相应的Bean，直接返回
		if (THREAD_SCOPE.get().containsKey(name)) {
			return THREAD_SCOPE.get().get(name);
		}
		// 使用objectFactory创建Bean并绑定到当前线程 上
		THREAD_SCOPE.get().put(name, objectFactory.getObject());
		return THREAD_SCOPE.get().get(name);
	}

	/**
	 * 
	 */
	@Override
	public Object remove(String name) {
		// TODO Auto-generated method stub
		return THREAD_SCOPE.get().remove(name);
	}

	/**
	 * 
	 */
	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// 此处不实现就代表类似 prototype
		
	}

	/**
	 * 
	 */
	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

}
