package com.iss.expense.demo.chapter3.bean;

/**
 *	
 * @author wangwei
 * @date 2015年8月25日  下午4:41:30
 * @version	v1.0
 */
public class Printer {
	private int counter = 0;
	public void print(String type){
		System.out.println(type + " printer:" + counter++);
	}
}
