package com.iss.expense.demo.myspring;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 自己实现spring getBean
 * @author wangwei
 * @date 2015年8月22日  上午10:30:34
 * @version	v1.0
 */
public class ApplicationContext {
	private SAXReader reader;
	private Document doc;
	public ApplicationContext(String fileName) throws DocumentException {
		reader = new SAXReader();
		doc = reader.read(fileName);
	}
	public <T> Object getBean(String beanName) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Element root = doc.getRootElement();
		List<Element> beanList = root.elements();
		for (Element element : beanList) {
			String id = element.attribute("id").getValue();
			if (beanName.equals(id)) {
				String className = element.attribute("class").getValue();
				Class obj = Class.forName(className);
				return obj.newInstance();
			}
		}
		return null;
	}
	public <T> Object getBean(String beanName, Class<T> className){
		return null;
	}
}
