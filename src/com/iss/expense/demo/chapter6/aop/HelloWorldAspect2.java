package com.iss.expense.demo.chapter6.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.core.annotation.Order;


/**
 *	
 * @author wangwei
 * @date 2015年9月7日  上午8:54:11
 * @version	v1.0
 */
@Aspect
public class HelloWorldAspect2 {
	@Pointcut(value="execution(* com..*.sayAdvisorBefore(..)) && args(param)", argNames="param")
	public void beforePointcut(String param){}
	
	@Pointcut(value="execution(* com..*.sayAfterReturning(..))")
	public void afterReturningPointcut(){}
	
	@Pointcut(value="execution(* com..*.sayAfterThrowing(..))")
	public void afterThrowingPointcut(){}
	
	@Pointcut(value="execution(* com..*.sayAfterFinally(..))")
	public void afterFinallyPointcut(){}
	
	@Around(value="execution(* com..*.sayAround(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("=====around before advice");
		Object retVal = pjp.proceed(new Object[]{"replace"});
		System.out.println("=====around after advice");
		return retVal;
	}
	
//	@After(value="afterFinallyPointcut()")
	@After(value="execution(* com..*.sayAfterFinally(..))")
	public void sayAfterFinally(){
		System.out.println("====after finally:");
	}
	
	@AfterThrowing(value="afterThrowingPointcut()")
	public void  afterThrowing(){
		System.out.println("====after throwing ");
	}
	
	@Before(value="beforePointcut(param)", argNames="param")
	public void beforeAdvice(String param){
		System.out.println("============before advice param:" + param);
	}
	
//	@AfterReturning(value="afterReturningPointcut()", argNames="retVal", returning="retVal")
	@AfterReturning(value="execution(* com..*.sayAdvisorBefore(..))",
			pointcut="execution(* com..*.sayAfterReturning(..))",
			argNames="retVal",
			returning="retVal")
	public void afterReturningAdvice(Object retVal){
		System.out.println("==========after returning advice retVal:" + retVal);
	}
	
}
