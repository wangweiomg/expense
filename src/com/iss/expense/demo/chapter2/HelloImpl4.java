package com.iss.expense.demo.chapter2;

/**
 *	
 * @author wangwei
 * @date 2015年8月19日  下午4:28:16
 * @version	v1.0
 */
public class HelloImpl4 implements HelloApi {
	
	private String message;
	private int index;
	
	public void setMessage(String message){
		this.message = message;
	}
	public void setIndex(int index){
		this.index = index;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(index + ":" + message);
	}

}
