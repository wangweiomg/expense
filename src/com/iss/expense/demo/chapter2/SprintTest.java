package com.iss.expense.demo.chapter2;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *	
 * @author wangwei
 * @date 2015年8月18日  上午8:54:30
 * @version	v1.0
 */
public class SprintTest {
	
	@Test
	public void test1(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/spring-config/spring-demo.xml");
		HelloImpl2 hello1 = beanFactory.getBean("bean1", HelloImpl2.class);
		HelloImpl2 hello2 = beanFactory.getBean("bean2", HelloImpl2.class);
	}
}
