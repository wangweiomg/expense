package com.iss.expense.demo.chapter3.bean;

/**
 *	
 * @author wangwei
 * @date 2015年8月24日  上午10:23:33
 * @version	v1.0
 */
public class CircleA {
	private CircleB circleB;
	public CircleA(){}
	public CircleA(CircleB circleB){
		this.circleB = circleB;
	}
	public CircleB getCircleB() {
		return circleB;
	}
	public void setCircleB(CircleB circleB) {
		this.circleB = circleB;
	}
	public void a(){
		circleB.b();
	}
}
