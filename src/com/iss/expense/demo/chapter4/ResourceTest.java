package com.iss.expense.demo.chapter4;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 *
 * @author wangwei
 * @date 2015年8月27日 上午11:20:19
 * @version v1.0
 */
public class ResourceTest {
	@Test
	public void testClasspathAsteriskPrefixLimit() throws IOException{
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();	// 将首先通过ClassLoader.getResource()加载目录
		//将只返回文件系统的类路径不返回jar的根路径
		// 然后进行遍历模式匹配
		Resource[] resources = resolver.getResources("classpath*:asm-*.txt");
		Assert.assertTrue(resources.length == 0);
		// 将通过ClassLoader.getResource("asm-license.txt")加载
		// asm-license.txt存在于com.spring.net.sf.cglib-2.2.0.jar
		resources = resolver.getResources("classpath*:asm-license.txt");
		Assert.assertTrue(resources.length > 0);
		// 将只加载文件系统类路径匹配 的Resource
		resources = resolver.getResources("classpath*:LICENS*");
		Assert.assertTrue(resources.length == 1);
	}
	public void testClasspathAsteriskPrefix() throws IOException{
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 将加载多个绝对匹配 的所有Resource
		// 将首先通过ClassLoader.getResource("META-INF")加载非模式路径部分
		// 然后进行遍历模式匹配
		Resource[] resources = resolver.getResources("classpath*:META-INF/INDEX.LIST");
		Assert.assertTrue(resources.length > 1);
		// 将加载多个模式匹配的Resource
		resources = resolver.getResources("classpath*:META-INF/*.LIST");
		Assert.assertTrue(resources.length > 1);
	}
	public void testClasspathPrefix() throws IOException{
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 只加载一个绝对匹配Resource，且通过ResourceLoader.getResource进行加载
		Resource[] resources = resolver.getResources("classpath:META-INF/INDEX.LIST");
		Assert.assertEquals(1, resources.length);
		// 只加载一个匹配的Resource，且通过ResourceLoader.getResource进行加载
		resources = resolver.getResources("classpath:META-INF/*.LIST");
		Assert.assertTrue(resources.length==1);
	}
	public void testResourceLoad(){
		ResourceLoader loader = new DefaultResourceLoader();
		Resource resource = loader.getResource("classpath:com/iss/expense/demo/chapter4/test1.properties");
		//验证返回的是ClassPathResource
		Assert.assertEquals(ClassPathResource.class, resource.getClass());
		Resource resource2 = loader.getResource("file:com/iss/expense/demo/chapter4/test1.properties");
		//验证返回的是ClassPathResource
		Assert.assertEquals(UrlResource.class, resource2.getClass());
		Resource resource3 = loader.getResource("com/iss/expense/demo/chapter4/test1.properties");
		//验证返默认可以加载ClasspathResource
		Assert.assertTrue(resource3 instanceof ClassPathResource);
	}

	public void testClasspathResourceByClassLoader() throws IOException {
		ClassLoader c1 = this.getClass().getClassLoader();
		Resource resource = new ClassPathResource(
				"com/iss/expense/demo/chapter4/test1.properties", c1);
		if (resource.exists()) {
			dumpStream(resource);
		}
		System.out.println("path:--->" + resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());

	}

	public void testClasspathResourceByDefaultClassLoader() throws IOException {
		Resource resource = new ClassPathResource(
				"com/iss/expense/demo/chapter4/test1.properties");
		if (resource.exists()) {
			dumpStream(resource);
		}
		System.out.println("path:--->" + resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
	}

	public void testFileResource() {
		File file = new File("d:/test.txt");
		Resource resource = new FileSystemResource(file);
		if (resource.exists()) {
			dumpStream(resource);
		}
		Assert.assertEquals(false, resource.isOpen());
	}

	public void testInputStreamResource() {
		ByteArrayInputStream bis = new ByteArrayInputStream(
				"Hello World!".getBytes());
		Resource resource = new InputStreamResource(bis);
		if (resource.exists()) {
			dumpStream(resource);
		}
		Assert.assertEquals(true, resource.isOpen());
	}

	public void testByteArrayResource() {
		Resource resource = new ByteArrayResource("Hello world!".getBytes());
		if (resource.exists()) {
			dumpStream(resource);
		}
	}

	/**
	 * @param resource
	 */
	private void dumpStream(Resource resource) {
		// TODO Auto-generated method stub
		InputStream is = null;
		try {
			// 1. 获取文件资源
			is = resource.getInputStream();
			// 2. 读取资源
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);
			System.out.println(new String(descBytes));

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}

		}

	}
}
