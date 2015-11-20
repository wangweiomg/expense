package com.iss.expense.demo.chapter7;

/**
 *
 * @author wangwei
 * @date 2015年9月11日 上午9:18:06
 * @version v1.0
 */
public class UserModel {
	private int id;
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + "]";
	}

}
