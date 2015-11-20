package com.iss.expense.demo.chapter3.bean;

/**
 *	
 * @author wangwei
 * @date 2015年8月23日  下午9:15:45
 * @version	v1.0
 */
public class NavigationA {
	private NavigationB navigationB;
	public void setNavigationB(NavigationB navigationB){
		this.navigationB = navigationB;
	}
	public NavigationB getNavigationB(){
		return navigationB;
	}
}
