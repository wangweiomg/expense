package com.iss.expense.demo.test;

/**
 *	
 * @author wangwei
 * @date 2015年9月23日  下午12:00:10
 * @version	v1.0
 */
public class User {
	private  String name;
	private  String password;
	private  int age;
	private  String grade;
	
	public static class Builder{
		private final String name;
		private final String password;
		public Builder(String name, String password){
			this.name = name;
			this.password = password;
		}
		private int age;
		private String grade;
		public Builder age(int val){
			this.age = val;
			return this;
		}
		public Builder grade(String val){
			this.grade = val;
			return this;
		}
		public User build(){
			return new User(this);
		}
	}
	public User(Builder builder){
		this.name = builder.name;
		this.password = builder.password;
		this.age = builder.age;
		this.grade = builder.grade;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age
				+ ", grade=" + grade + "]";
	}
	

}
