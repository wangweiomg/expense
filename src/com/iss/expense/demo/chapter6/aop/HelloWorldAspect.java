package com.iss.expense.demo.chapter6.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *	
 * @author wangwei
 * @date 2015年8月29日  下午5:13:42
 * @version	v1.0
 */
public class HelloWorldAspect {
	// 前置通知
	public void beforeAdvice(){
		System.out.println("=====before advice");
	}
	
	// 前置通知
	public void beforeAdvice(String param){
		System.out.println("=====before advice param:" + param);
	}
	
	// 后置最终通知
	public void afterFinalAdvice(){
		System.out.println("=====after finally advice");
	}
	
	public void afterReturningAdvice(Object retVal){
		System.out.println("======after returning advice retVal:" + retVal);
	}
	
	public void afterThrowingAdvice(Exception exp){
		System.out.println("====after throwing advice exp:" + exp);
	}
	
	public void afterFinallyAdvice(){
		System.out.println("====after finally advice");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("===around before advice:");
		Object retVal = pjp.proceed(new Object[]{"replace"});
		System.out.println("=====around after advice");
		return retVal;
		
	}
}
