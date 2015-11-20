package com.iss.expense.demo.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.InputStreamSource;
import org.springframework.util.StringUtils;

import com.iss.expense.demo.chapter2.HelloApi;
import com.iss.expense.demo.chapter2.HelloImpl2;
import com.iss.expense.demo.chapter3.BeanDefinition;
import com.iss.expense.demo.chapter3.DefaultBeanFactory;
import com.iss.expense.demo.chapter3.bean.ArrayTestBean;
import com.iss.expense.demo.chapter3.bean.DependentBean;
import com.iss.expense.demo.chapter3.bean.HelloApiDecorator;
import com.iss.expense.demo.chapter3.bean.ListTestBean;
import com.iss.expense.demo.chapter3.bean.MapTestBean;
import com.iss.expense.demo.chapter3.bean.NameSpaceBean;
import com.iss.expense.demo.chapter3.bean.NavigationA;
import com.iss.expense.demo.chapter3.bean.NavigationC;
import com.iss.expense.demo.chapter3.bean.Printer;
import com.iss.expense.demo.chapter3.bean.PropertiesTestBean;

/**
 *	
 * @author wangwei
 * @date 2015年8月20日  上午9:56:58
 * @version	v1.0
 */
public class SprintTest {
	
	@Test
	public void testThreadScope(){
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HelloApi hello1 = ctx.getBean("helloApi", HelloApi.class);
			}
		});
		Thread t12 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void testPrototype() throws Exception{
		// 1. 创建Bean工厂
		DefaultBeanFactory bf = new DefaultBeanFactory();
		// 2. 定义原型Bean定义
		BeanDefinition bd = new BeanDefinition();
		bd.setId("bean");
		bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		bd.setClazz(HelloImpl2.class.getName());
		bf.registerBeanDefinition(bd);
		// 对于原型Bean每次应该返回一个全新的Bean
		System.out.println(bf.getBean("bean")!= bf.getBean("bean"));
	
	}
	public void testMethodReplacer(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		Printer printer = ctx.getBean("printer", Printer.class);
		printer.print("我将被替换");
	}
	public void testLookup(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		System.out.println("=============singleton sayHello=============");
		HelloApi helloApi1 = ctx.getBean("helloApi1", HelloApi.class);
		helloApi1.sayHello();
		helloApi1 =  ctx.getBean("helloApi1", HelloApi.class);
		helloApi1.sayHello();
		System.out.println("=============prototype sayHello=============");
		HelloApi helloApi2 = ctx.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
		helloApi2 = ctx.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
	}
	public void testAutowireByName() throws IOException{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		HelloApi helloApi = ctx.getBean("helloDecorator", HelloApi.class);
		helloApi.sayHello();
	}
	public void testCircleByConstructor() throws IOException{
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
			ctx.registerShutdownHook();
			DependentBean dependentBean = ctx.getBean("dependentBean", DependentBean.class);
			dependentBean.write("aaa");
	}
	public void testNavigationBeanInject(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
//		NavigationA navigationA = context.getBean("a", NavigationA.class);
//		navigationA.getNavigationB().getNavigationC().sayNavigation();
//		navigationA.getNavigationB().getList().get(0).sayNavigation();
//		navigationA.getNavigationB().getMap().get("key").sayNavigation();
//		navigationA.getNavigationB().getArray()[0].sayNavigation();
//		((NavigationC)navigationA.getNavigationB().getProperties().get("1")).sayNavigation();
		NameSpaceBean bean = context.getBean("idrefBean1", NameSpaceBean.class);
		NameSpaceBean bean2 = context.getBean("idrefBean2", NameSpaceBean.class);
		System.out.println(bean.getId());
		System.out.println(bean2.getId());
		
	}
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		ListTestBean listBean = ctx.getBean("listBean", ListTestBean.class);
		ListTestBean setBean = ctx.getBean("setBean", ListTestBean.class);
		List<String> list = listBean.getValues();
		System.out.println(list);
		System.out.println(setBean.getValues2());
		ArrayTestBean arrayBean = ctx.getBean("arrayBean1", ArrayTestBean.class);
		String[] array = arrayBean.getArray();
		for (String string : array) {
			System.out.print(string + ", ");
		}
		System.out.println();
		String[][] array2= arrayBean.getArray2();
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j] + ", ");
			}
			System.out.println();
		}
		MapTestBean mapBean = ctx.getBean("mapBean", MapTestBean.class);
		Map<String, Integer> map = mapBean.getValues();
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		PropertiesTestBean propsBean = ctx.getBean("propertiesBean", PropertiesTestBean.class);
		PropertiesTestBean propsBean2 = ctx.getBean("propertiesBean2", PropertiesTestBean.class);
		System.out.println(propsBean.getValues());
		System.out.println(propsBean2.getValues());
		HelloApiDecorator helloDecorator = ctx.getBean("bean1", HelloApiDecorator.class);
		HelloApiDecorator helloDecorator2 = ctx.getBean("bean2", HelloApiDecorator.class);
		helloDecorator.sayHello();
		helloDecorator2.sayHello();
	}
	public void testLocalAndParentBeanInject(){
		// 初始化父容器
		ApplicationContext parentBeanContext = new ClassPathXmlApplicationContext("config/spring-config/spring-parentBeanInject.xml");
		// 初始化当前容器
		ApplicationContext beanContext = new ClassPathXmlApplicationContext(new String[]{"config/spring-config/spring-localBeanInject.xml"}, parentBeanContext);
		HelloApi bean1 = beanContext.getBean("bean1", HelloApi.class);
		bean1.sayHello();	//该bean引用localBean
		HelloApi bean2 = beanContext.getBean("bean2", HelloApi.class);
		bean2.sayHello(); 	// 该bean引用parentBean
	}
	public void testInnerBeanInject(){
		ApplicationContext beanContext = new ClassPathXmlApplicationContext("config/spring-config/spring-chapter3.xml");
		HelloApi bean1 = beanContext.getBean("helloDecorator", HelloApi.class);
		bean1.sayHello();
		
	}
}
