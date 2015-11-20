package com.iss.expense.demo.chapter3.bean;

import java.util.Map;

/**
 *	
 * @author wangwei
 * @date 2015年8月20日  下午2:58:45
 * @version	v1.0
 */
public class MapTestBean {
	private Map<String, Integer> values;
	public void setValues(Map<String, Integer> values){
		this.values = values;
	}
	public Map<String, Integer> getValues(){
		return values;
	}
}
