package com.iss.expense.demo.chapter3.bean;

import com.iss.expense.demo.chapter2.HelloApi;

/**
 *	
 * @author wangwei
 * @date 2015年8月25日  下午4:47:56
 * @version	v1.0
 */
public abstract class HelloImpl5 implements HelloApi {
	private Printer printer;
	public void sayHello(){
		printer.print("setter");
		createPrototypePrinter().print("prototype");
		createSingletonPrinter().print("singleton");
	}
	public abstract Printer createPrototypePrinter();
	public Printer createSingletonPrinter(){
		System.out.println("该方法不会被执行，如果输出就错了");
		return new Printer();
	}
	public void setPrinter(Printer printer){
		this.printer = printer;
	}
}
