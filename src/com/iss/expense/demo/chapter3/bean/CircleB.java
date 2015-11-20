package com.iss.expense.demo.chapter3.bean;

/**
 *	
 * @author wangwei
 * @date 2015年8月24日  上午10:25:09
 * @version	v1.0
 */
public class CircleB {
	private CircleC circleC;
	public CircleB(){}
	public CircleB(CircleC circleC){
		this.circleC = circleC;
	}
	public void setCircleC(CircleC circleC){
		this.circleC = circleC;
	}
	public void b(){
		circleC.c();
	}
}
