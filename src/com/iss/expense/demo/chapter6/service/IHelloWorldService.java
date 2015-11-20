package com.iss.expense.demo.chapter6.service;


/**
 *	
 * @author wangwei
 * @date 2015年8月29日  下午5:08:56
 * @version	v1.0
 */
public interface IHelloWorldService {
	public void sayHello();
	
	public void print(String message);
	
	public boolean sayAfterReturning();
	
	public void sayAfterThrowing();

	public boolean sayAfterFinally();
	
	public void sayAround(String param);
	
	public void sayAdvisorBefore(String param);
	
	public void beforeAdvice(String param);
}
