package com.iss.expense.demo.chapter2;

/**
 *	
 * @author wangwei
 * @date 2015年8月18日  上午11:13:41
 * @version	v1.0
 */
public class HelloImpl2 implements HelloApi {
	public HelloImpl2() {
		System.out.println("HelloImpl2 constructor for null params");
	}
	public HelloImpl2(String value) {
		System.out.println("HelloImpl2 constructor for params");
		System.out.println(value);
	}
	@Override
	public void sayHello() {
		System.out.println("HelloImpl2.sayHello()");
	}
}
