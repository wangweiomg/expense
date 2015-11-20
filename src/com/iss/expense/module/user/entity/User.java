package com.iss.expense.module.user.entity;

/**
 * 用户实体类
 * 
 * @author wangwei
 * @date 2015年8月11日 下午4:05:31
 * @version v1.0
 */
public class User {

	private Integer tid; // 用户ID，主键
	private String userName; // 用户名称
	private String password; // 用户密码
	private String roleType; // 用户角色类型 角色1：系统管理员2：运维人员3：用户
	private String status; // 用户账号状态：0：正常1：暂停使用2：注销
	private String phone; // 用户手机号
	private String mail; // 用户邮箱

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
