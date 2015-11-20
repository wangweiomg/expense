package com.iss.expense.demo.chapter2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *	
 * @author wangwei
 * @date 2015年8月20日  上午9:13:20
 * @version	v1.0
 */
public class IdRefTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
//		IdRefTestBean idRefBean = context.getBean("idrefBean1", IdRefTestBean.class);
//		IdRefTestBean idRefLocal = context.getBean("idrefBean2", IdRefTestBean.class);
//		System.out.println(idRefBean.getId());
//		System.out.println(idRefLocal.getId());
	}
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		IdRefTestBean idRefBean = context.getBean("idrefBean1", IdRefTestBean.class);
		IdRefTestBean idRefLocal = context.getBean("idrefBean2", IdRefTestBean.class);
		System.out.println(idRefBean.getId());
		System.out.println(idRefLocal.getId());

	}
}
