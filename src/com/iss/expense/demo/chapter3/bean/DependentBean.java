package com.iss.expense.demo.chapter3.bean;

import java.io.IOException;

/**
 *	
 * @author wangwei
 * @date 2015年8月25日  下午12:40:34
 * @version	v1.0
 */
public class DependentBean {
	ResourceBean resourceBean;
	public void write(String ss) throws IOException{
		System.out.println("DependentBean:====写资源");
		resourceBean.getFos().write(ss.getBytes());
	}
	// 初始化方法
	public void init() throws IOException{
		System.out.println("DependentBean:====初始化");
		resourceBean.getFos().write("DependentBean:====初始化".getBytes());
	}
	// 销毁方法
	public void destroy() throws IOException{
		System.out.println("DependentBean:====销毁");
		// 销毁之前需要往文件中写销毁内容
		resourceBean.getFos().write("DependentBean:====销毁".getBytes());
	}
	public void setResourceBean(ResourceBean resourceBean){
		this.resourceBean = resourceBean;
	}
	
}
