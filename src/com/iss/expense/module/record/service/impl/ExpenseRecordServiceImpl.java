package com.iss.expense.module.record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iss.expense.base.BaseDao;
import com.iss.expense.module.record.entity.ExpenseRecord;
import com.iss.expense.module.record.service.ExpenseRecordService;

/**
 * 消费纪录接口实现
 * @author wangwei
 * @date 2015年8月11日  下午4:20:21
 * @version	v1.0
 */
@Service
public class ExpenseRecordServiceImpl implements ExpenseRecordService {
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<ExpenseRecord> queryRecordByUserId(String userId) {
		return baseDao.selectList("expense.expenseRecord.queryRecordByUserId", userId);
	}
	
}

