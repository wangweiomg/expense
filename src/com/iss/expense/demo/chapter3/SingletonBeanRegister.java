package com.iss.expense.demo.chapter3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

/**
 *	
 * @author wangwei
 * @date 2015年8月26日  下午4:23:48
 * @version	v1.0
 */
public class SingletonBeanRegister implements SingletonBeanRegistry {
	// 单例Bean缓存池，此处不考虑并发
	private final Map<String, Object> BEANS = new HashMap<String, Object>();

	@Override
	public boolean containsSingleton(String beanName) {
		// TODO Auto-generated method stub
		return BEANS.containsKey(beanName);
	}

	@Override
	public Object getSingleton(String beanName) {
		// TODO Auto-generated method stub
		return BEANS.get(beanName);
	}

	@Override
	public int getSingletonCount() {
		// TODO Auto-generated method stub
		return BEANS.size();
	}

	@Override
	public String[] getSingletonNames() {
		// TODO Auto-generated method stub
		return BEANS.keySet().toArray(new String[0]);
	}

	@Override
	public void registerSingleton(String beanName, Object bean) {
		// TODO Auto-generated method stub
		if (BEANS.containsKey(beanName)) {
			throw  new  RuntimeException("["+ beanName +"]已存在");
		}
		BEANS.put(beanName, bean);
	}

}
