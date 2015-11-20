package com.iss.expense.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.iss.expense.constant.ConstValues;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action基类
 * @author wangwei
 * @date 2015年7月18日  上午11:09:03
 * @version	v1.0
 */
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -6439094322086430291L;
	
	public Logger logger = Logger.getLogger(this.getClass());
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public BaseAction() {
		this.request = ServletActionContext.getRequest();
		this.response = ServletActionContext.getResponse();
		// 中文字符支持
		response.setCharacterEncoding(ConstValues.ENCODING_UTF8);
		response.setContentType("text/html;charset="+ConstValues.ENCODING_UTF8);
	}
	
	/**
	 * 返回前台 字符串
	 */
	protected void writer(String str) {
		PrintWriter  out = null;
		try {
			out = response.getWriter();
			out.write(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
}
