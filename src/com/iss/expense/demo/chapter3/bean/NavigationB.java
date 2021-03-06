package com.iss.expense.demo.chapter3.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author wangwei
 * @date 2015年8月23日 下午9:10:40
 * @version v1.0
 */
public class NavigationB {
	private NavigationC navigationC;
	private List<NavigationC> list;
	private Properties properties;
	private NavigationC[] array = new NavigationC[1];
	private Map<String, NavigationC> map;

	public NavigationC getNavigationC() {
		return navigationC;
	}

	public void setNavigationC(NavigationC navigationC) {
		this.navigationC = navigationC;
	}

	public List<NavigationC> getList() {
		return list;
	}

	public void setList(List<NavigationC> list) {
		this.list = list;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public NavigationC[] getArray() {
		return array;
	}

	public void setArray(NavigationC[] array) {
		this.array = array;
	}

	public Map<String, NavigationC> getMap() {
		return map;
	}

	public void setMap(Map<String, NavigationC> map) {
		this.map = map;
	}

}
