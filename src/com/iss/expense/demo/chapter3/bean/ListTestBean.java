package com.iss.expense.demo.chapter3.bean;

import java.util.List;
import java.util.Set;

/**
 *	
 * @author wangwei
 * @date 2015年8月20日  上午9:38:51
 * @version	v1.0
 */
public class ListTestBean {
	private List<String> values;
	private Set<Integer> values2;
	public List<String> getValues(){
		return values;
	}
	public void setValues(List<String> values){
		this.values = values;
	}
	public Set<Integer> getValues2() {
		return values2;
	}
	public void setValues2(Set<Integer> values2) {
		this.values2 = values2;
	}
	
}
