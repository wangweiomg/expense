package com.iss.expense.demo.chapter3.bean;

/**
 *	
 * @author wangwei
 * @date 2015年8月26日  下午4:15:13
 * @version	v1.0
 */
public class Singleton {
	// 1. 私有化构造器
	private Singleton(){}
	// 2. 单例缓存者，惰性初始化，第一次使用时初始化
	private static class InstanceHolder{
		private static final Singleton INISTANCE = new Singleton();
	}
	// 3. 提供全局访问点
	public static Singleton getInstance(){
		return InstanceHolder.INISTANCE;
	}
	// 4. 提供一个计数器来验证一个ClassLoader 一个实例
	private int counter = 0;
}
