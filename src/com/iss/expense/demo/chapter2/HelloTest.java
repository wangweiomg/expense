package com.iss.expense.demo.chapter2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *	
 * @author wangwei
 * @date 2015年8月18日  下午4:08:18
 * @version	v1.0
 */
public class HelloTest {
	@Test
	public void testHelloWorld(){
		// 1. 读取配置文件实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config/spring-demo.xml");
		// 2. 从容器中获取Bean，此处完全面向接口编程，而不是面向实现
		HelloApi helloApi1 = (HelloApi) context.getBean("helloImpl4", HelloApi.class);
		// 3. 执行业务逻辑
		helloApi1.sayHello();
		BooleanTestBean bean1 = context.getBean("booleanBean1", BooleanTestBean.class);
		BooleanTestBean bean2 = context.getBean("booleanBean2", BooleanTestBean.class);
		BooleanTestBean bean3 = context.getBean("booleanBean3", BooleanTestBean.class);
		BooleanTestBean bean4 = context.getBean("booleanBean4", BooleanTestBean.class);
		System.out.println(bean1.isSuccess());
		System.out.println(bean2.isSuccess());
		System.out.println(bean3.isSuccess());
		System.out.println(bean4.isSuccess());
	}
}
