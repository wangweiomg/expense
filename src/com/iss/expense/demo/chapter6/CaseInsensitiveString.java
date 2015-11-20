package com.iss.expense.demo.chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 *	
 * @author wangwei
 * @date 2015年8月30日  下午4:06:37
 * @version	v1.0
 */
public final class CaseInsensitiveString {
	private final String s;
	public CaseInsensitiveString(String s){
		if(s == null)
			throw new NullPointerException();
		this.s = s;
	}
	@Override
	public boolean equals(Object obj) {
//		if (obj instanceof CaseInsensitiveString) {
//			return s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
//		}
//		if (obj instanceof String) {
//			return s.equalsIgnoreCase((String)obj);
//		}
//		return false;
		return obj instanceof CaseInsensitiveString &&
				((CaseInsensitiveString)obj).s.equalsIgnoreCase(s);
	}
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
		list.add(cis);
		System.out.println(list.contains(s));
	}
}
