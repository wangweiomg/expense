package com.iss.expense.demo.chapter6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iss.expense.demo.chapter6.service.IHelloWorldService;
import com.iss.expense.demo.chapter6.service.IIntroductionService;

/**
 *	
 * @author wangwei
 * @date 2015年8月29日  下午5:57:26
 * @version	v1.0
 */
public class AopTest {
	public void testAnnotationBeforeAdvice(){
		System.out.println("=================================");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter6-advice.xml");
		IHelloWorldService helloWorldService = ctx.getBean("helloWorldServiceImpl", IHelloWorldService.class);
//		helloWorldService.sayAfterThrowing();
//		helloWorldService.sayAfterFinally();
		helloWorldService.sayAround("around param");
		System.out.println("=================================");
	}
	public void testSchemaAdvisor(){
		System.out.println("========");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter6.xml");
		IHelloWorldService helloWorldService = ctx.getBean("helloWorldServiceImpl", IHelloWorldService.class);
		helloWorldService.sayAdvisorBefore("haha");
		System.out.println("========");
	}
	@Test
	public void testSchemaIntroduction(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter6.xml");
		IIntroductionService introductionService = ctx.getBean("helloWorldServiceImpl", IIntroductionService.class);
		introductionService.induct();
	}
	public void testHelloWorld(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter6.xml");
		IHelloWorldService helloWorldService = ctx.getBean("helloWorldServiceImpl", IHelloWorldService.class);
		helloWorldService.sayHello();
		helloWorldService.print("IIIIII");
		System.out.println("*************");
		helloWorldService.sayAfterReturning();
		System.out.println("*************");
		helloWorldService.sayAround("DDDDDDDDDDDD");
	}
}
