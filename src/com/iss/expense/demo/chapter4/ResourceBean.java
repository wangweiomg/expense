package com.iss.expense.demo.chapter4;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 *	
 * @author wangwei
 * @date 2015年8月27日  下午4:27:09
 * @version	v1.0
 */
public class ResourceBean implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		this.resourceLoader = resourceLoader;
	}
	public ResourceLoader getResourceLoader(){
		return resourceLoader;
	}

}
