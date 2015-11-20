package com.iss.expense.demo.chapter2;

/**
 *	
 * @author wangwei
 * @date 2015年8月18日  下午2:20:58
 * @version	v1.0
 */
public class HelloApiInstanceFactory {
	public HelloApi newInstance(String message){
		return new HelloImpl2(message);
	}
}
