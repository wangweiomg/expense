package com.iss.expense.demo.chapter9;

import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;

/**
 *	
 * @author wangwei
 * @date 2015年10月21日  下午5:33:08
 * @version	v1.0
 */
public interface TransactionStatus extends SavepointManager {
	boolean isNewTransaction();
	boolean hasSavepoint();
	void setRollbackOnly();
	boolean isRollbackOnly();
	void flush();
	boolean isCompleted();
}
