package com.iss.expense.demo.chapter3.bean;

/**
 *	
 * @author wangwei
 * @date 2015年8月24日  上午10:27:17
 * @version	v1.0
 */
public class CircleC {
	private CircleA circleA;
	public CircleC(){}
	public CircleC(CircleA circleA){
		this.circleA = circleA;
	}
	public void setCircleA(CircleA circleA){
		this.circleA = circleA;
	}
	public void c(){
		circleA.a();
	}
}
