package com.iss.expense.demo.chapter2;

/**
 *
 * @author wangwei
 * @date 2015年8月19日 下午3:53:23
 * @version v1.0
 */
public class HelloImpl3 implements HelloApi {

	private String message;
	private int index;

	public HelloImpl3(String message, int index) {
		super();
		this.message = message;
		this.index = index;
	}

	@Override
	public void sayHello() {
		System.out.println(index + ":" + message);
	}

}
