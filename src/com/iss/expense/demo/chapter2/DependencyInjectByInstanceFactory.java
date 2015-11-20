package com.iss.expense.demo.chapter2;

/**
 *	
 * @author wangwei
 * @date 2015年8月19日  下午4:13:31
 * @version	v1.0
 */
public class DependencyInjectByInstanceFactory {
	public HelloApi newInstance(String message, int index){
		return new HelloImpl3(message, index);
	}
}
