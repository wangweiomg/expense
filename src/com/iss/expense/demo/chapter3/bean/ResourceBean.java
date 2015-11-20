package com.iss.expense.demo.chapter3.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *	
 * @author wangwei
 * @date 2015年8月25日  上午10:11:27
 * @version	v1.0
 */
public class ResourceBean {
	private FileOutputStream fos;
	private File file;
	public void init(){
		System.out.println("ResourceBean:===初始化");
		// 加载资源
		System.out.println("======加载资源");
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 销毁资源方法
	public void destroy(){
		System.out.println("ReourceBean：===销毁");
		System.out.println("释放资源");
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FileOutputStream getFos(){
		return fos;
	}
	public void setFile(File file){
		this.file = file;
	}
}
