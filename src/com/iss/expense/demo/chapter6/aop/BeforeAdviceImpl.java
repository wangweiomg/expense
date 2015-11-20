package com.iss.expense.demo.chapter6.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 *	
 * @author wangwei
 * @date 2015年9月6日  下午3:57:52
 * @version	v1.0
 */
public class BeforeAdviceImpl implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("======before advice");
	}

}
