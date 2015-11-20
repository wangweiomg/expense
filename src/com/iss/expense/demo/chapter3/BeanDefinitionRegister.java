package com.iss.expense.demo.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 *	
 * @author wangwei
 * @date 2015年8月26日  下午4:56:37
 * @version	v1.0
 */
public class BeanDefinitionRegister {
	// bean 定义缓存，此处不考虑并发问题
	private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<String, BeanDefinition>();
	public void registerBeanDefinition(String beanName, BeanDefinition bd){
		// 本实现不允许覆盖Bean定义
		if (DEFINITIONS.containsKey(bd.getId())) {
			throw new RuntimeException("已经存在Bean定义，此实现不允许覆盖");
		}
		// 2. 将Bean定义放入Bean定义缓存池
		DEFINITIONS.put(bd.getId(), bd);
	}
	public BeanDefinition getBeanDefinition(String beanName){
		return DEFINITIONS.get(beanName);
	}
	public boolean containsBeanDefinition(String beanName){
		return DEFINITIONS.containsKey(beanName);
	}
}
