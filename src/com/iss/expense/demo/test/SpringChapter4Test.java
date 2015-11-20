package com.iss.expense.demo.test;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.iss.expense.demo.chapter4.bean.ResourceBean3;


/**
 *	
 * @author wangwei
 * @date 2015年8月27日  下午4:33:33
 * @version	v1.0
 */
public class SpringChapter4Test {
	@Test
	public void testVariableExpression(){
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("variable", "haha");
		context.setVariable("variable", "haha");
		String result1 = parser.parseExpression("#variable").getValue(context, String.class);
		System.out.println(result1);
		
		context = new StandardEvaluationContext("haha");
		String result2 = parser.parseExpression("#root").getValue(context, String.class);
		System.out.println(result2);
		
		String result3 = parser.parseExpression("#this").getValue(context, String.class);
		System.out.println(result3);
		
	}
	public void testConstructorExpression(){
		ExpressionParser parser = new SpelExpressionParser();
		String result1 = parser.parseExpression("new String('haha')").getValue(String.class);
		System.out.println(result1);
		Date date = parser.parseExpression("new java.util.Date()").getValue(Date.class);
		System.out.println(date);
	}
	public void testClassTypeExpression(){
		ExpressionParser parser = new SpelExpressionParser();
		// java.lang包类访问
		Class<String> result1 = parser.parseExpression("T<String>").getValue(Class.class);
		Assert.assertEquals(String.class, result1);
		// 其他包类访问
		String expression2 = "T(com.iss.expense.demo.test.SpringChapter4Test)";
		Class<String> result2 = parser.parseExpression(expression2).getValue(Class.class);
		int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
		System.out.println(result3);
	}
	public void testAri(){
		ExpressionParser parser = new SpelExpressionParser();
		int result  = parser.parseExpression("2^10").getValue(Integer.class);
		System.out.println(result);
		boolean result2 = parser.parseExpression("2>1 and (!true or !false)").getValue(boolean.class);
		System.out.println(result2);
	}
	public void helloWorld(){
		ExpressionParser parser = new SpelExpressionParser();
		int result1 = parser.parseExpression("1+3+4").getValue(Integer.class);
		System.out.println(result1);
		Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end");
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("end", "!");
		Assert.assertEquals("Hello World!", expression.getValue(context));
		
	}
	public void test(){
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("config/spring-config/spring-chapter4.xml");
		ResourceBean3 resourceBean1 = ctx.getBean("resourceBean1", ResourceBean3.class);
		ResourceBean3 resourceBean2 = ctx.getBean("resourceBean2", ResourceBean3.class);
		Assert.assertTrue(resourceBean1.getResource() instanceof ClassPathResource);
		Assert.assertTrue(resourceBean2.getResource() instanceof ClassPathResource);
	}
}
