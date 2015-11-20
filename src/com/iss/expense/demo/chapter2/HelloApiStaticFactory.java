package com.iss.expense.demo.chapter2;

/**
 *	
 * @author wangwei
 * @date 2015年8月18日  下午12:45:06
 * @version	v1.0
 */
public class HelloApiStaticFactory{
	// 工厂方法
	public static HelloApi newInstance(String message){
		return new HelloImpl2(message);
	}
}
