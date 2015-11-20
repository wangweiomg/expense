package com.iss.expense.demo.chapter3.bean;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 *	
 * @author wangwei
 * @date 2015年8月26日  下午3:53:26
 * @version	v1.0
 */
public class PrinterReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println("Print Replacer");
		// 注意此处不能再通过反射调用了，否则会产生循环调用，直到内存溢出
//		method.invoke(obj, new String[]{"hhh"});
		return null;
	}

}
