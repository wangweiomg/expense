package com.iss.expense.demo.chapter9;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

/**
 *	
 * @author wangwei
 * @date 2015年10月21日  下午5:13:12
 * @version	v1.0
 */
public interface PlatformTransactionManager {
	TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;
	void commit(TransactionStatus status) throws TransactionException;
	void rollback(TransactionStatus status) throws TransactionException;
}
