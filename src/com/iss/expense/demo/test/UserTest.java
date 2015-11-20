package com.iss.expense.demo.test;

import org.junit.Test;

/**
 *	
 * @author wangwei
 * @date 2015年9月23日  下午12:57:07
 * @version	v1.0
 */
public class UserTest {
	@Test
	public void test(){
		User user = new User.Builder("ww", "123").age(14).build();
		System.out.println(user);
	}
}
