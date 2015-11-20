package com.iss.expense.demo.chapter9;

/**
 *	
 * @author wangwei
 * @date 2015年10月21日  下午5:24:51
 * @version	v1.0
 */
public interface TransactionDefinition {
	int getPropagationBehavior();
	int getIsolationLevel();
	int getTimeout();
	boolean isReadOnly();
	String getName();
}
