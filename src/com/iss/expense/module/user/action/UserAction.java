package com.iss.expense.module.user.action;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.iss.expense.base.BaseAction;
import com.iss.expense.module.record.entity.ExpenseRecord;
import com.iss.expense.module.record.service.ExpenseRecordService;
import com.iss.expense.module.user.entity.TicketInfo;
import com.iss.expense.module.user.service.UserService;

/**
 * 用户管理action
 * 
 * @author wangwei
 * @date 2015年8月7日 下午12:41:55
 * @version v1.0
 */
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 8421119753278726726L;

	@Autowired
	private UserService userService;
	@Autowired
	private ExpenseRecordService recordService;

	public String userLogin() {
		return "login";
	}

	/**
	 * 跳转主页
	 * 
	 * @return
	 */
	public String toMainPage() {
		try {
			String userId = request.getParameter("userId");
			if (StringUtils.isBlank(userId)) {
				logger.warn("用户id为空");
				return "";
			}
			List<ExpenseRecord> userRecords = recordService
					.queryRecordByUserId("1");
			request.setAttribute("userRecords", userRecords);
		} catch (Exception e) {
			logger.error("查询用户消费纪录异常", e);
		}
		return "mainPage";
	}
}
