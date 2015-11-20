package com.iss.expense.demo.chapter3.bean;

import com.iss.expense.demo.chapter2.HelloApi;

/**
 *	
 * @author wangwei
 * @date 2015年8月22日  下午2:31:46
 * @version	v1.0
 */
public class HelloApiDecorator implements HelloApi {
	private HelloApi helloApi;
	public HelloApiDecorator(){}
	public HelloApiDecorator(HelloApi  helloApi){
		this.helloApi = helloApi;
	}
	public void setHelloApi(HelloApi helloApi){
		this.helloApi = helloApi;
	}
	@Override
	public void sayHello() {
		System.out.println("--装饰一下--");
		helloApi.sayHello();
		System.out.println("--装饰一下--");
	}

}
