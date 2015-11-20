package com.iss.expense.module.record.service;

import java.util.List;

import com.iss.expense.module.record.entity.ExpenseRecord;

/**
 * 消费纪录服务接口
 * @author wangwei
 * @date 2015年8月11日  下午4:19:31
 * @version	v1.0
 */
public interface ExpenseRecordService {

	/**
	 * 获得用户费用记录列表
	 * @param string
	 * @return
	 */
	public List<ExpenseRecord> queryRecordByUserId(String userId);
	
}
