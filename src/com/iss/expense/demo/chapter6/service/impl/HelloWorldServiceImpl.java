package com.iss.expense.demo.chapter6.service.impl;

import com.iss.expense.demo.chapter6.service.IHelloWorldService;

/**
 *
 * @author wangwei
 * @date 2015年8月29日 下午5:10:37
 * @version v1.0
 */
public class HelloWorldServiceImpl implements IHelloWorldService {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("===========Hello World!");
	}

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println("------>" + message);
	}

	@Override
	public boolean sayAfterReturning() {
		System.out.println("=========after returning");
		return true;
	}

	@Override
	public void sayAfterThrowing() {
		System.out.println("======before throwing");
		throw new RuntimeException();
	}

	@Override
	public boolean sayAfterFinally() {
		// TODO Auto-generated method stub
		System.out.println("====say after finally");
		return true;
	}

	@Override
	public void sayAround(String param) {
		System.out.println("====around param:" + param);
	}

	@Override
	public void sayAdvisorBefore(String param) {
		System.out.println("======say " + param);
	}
	@Override
	public void beforeAdvice(String param) {
		System.out.println("=====before advice param:" + param);
	}

}
