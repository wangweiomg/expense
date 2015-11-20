package com.iss.expense.demo.chapter2;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *	
 * @author wangwei
 * @date 2015年8月18日  下午1:58:39
 * @version	v1.0
 */
public class InstantiatingBeanTest {
	@Test
	public void testInstantiatingBeanByStaticFactory(){
		// 使用静态工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/spring-config/spring-demo.xml");
		HelloApi bean4 = beanFactory.getBean("bean3", HelloApi.class);
		bean4.sayHello();
	}
}
