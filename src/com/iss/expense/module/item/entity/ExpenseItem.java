package com.iss.expense.module.item.entity;

/**
 * 消费项目实体类
 * 
 * @author wangwei
 * @date 2015年8月11日 下午4:09:51
 * @version v1.0
 */
public class ExpenseItem {

	private Integer tid; // 主键
	private String itemName; // 项目名称
	private Integer parentId; // 父id

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
