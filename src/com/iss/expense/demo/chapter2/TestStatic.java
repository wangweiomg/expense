package com.iss.expense.demo.chapter2;

/**
 *	
 * @author wangwei
 * @date 2015年9月6日  上午11:13:01
 * @version	v1.0
 */
public class TestStatic {
	public static void main(String[] args) {
		StaticInitinal.print();
	}
}
class StaticInitinal{
	public StaticInitinal(){
		System.out.println("StaticInitinal constructor");
	}
	public static void print(){
		System.out.println("StaticInitinal.print()");
	}
}
