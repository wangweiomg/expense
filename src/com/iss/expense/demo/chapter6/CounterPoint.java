package com.iss.expense.demo.chapter6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *	
 * @author wangwei
 * @date 2015年9月1日  下午2:33:49
 * @version	v1.0
 */
public class CounterPoint extends Point {

	private static  final AtomicInteger counter = new AtomicInteger();
	
	/**
	 * @param x
	 * @param y
	 */
	public CounterPoint(int x, int y) {
		super(x, y);
		counter.incrementAndGet();
	}
	public int numberCreated(){return counter.get();}

}
