package com.iss.expense.demo.test;

import org.dom4j.DocumentException;

import com.iss.expense.demo.chapter2.HelloApi;
import com.iss.expense.demo.myspring.ApplicationContext;

/**
 * 自己编写spring
 * @author wangwei
 * @date 2015年8月22日  上午11:25:45
 * @version	v1.0
 */
public class MySpringTest {
	public static void main(String[] args) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ApplicationContext ctx = new ApplicationContext("E:\\test\\xml\\Book.xml");
		HelloApi hello = (HelloApi) ctx.getBean("hello");
		hello.sayHello();
	}
}
