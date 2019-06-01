package com._01.hello;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
	@Test
	public void testName() throws Exception {
		//通过xml解析技术，得到类的全限定名
		Class clz = Class.forName("com._01.hello.HelloWorld");
		//创建对象
		Constructor con = clz.getConstructor();
		con.setAccessible(true);
		Object obj = con.newInstance();
		//给username设置属性值
		BeanInfo beaninfo = Introspector.getBeanInfo(clz,Object.class);
		PropertyDescriptor[] pds = beaninfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if("username".equals(pd.getName())) {
				pd.getWriteMethod().invoke(obj, "will");
			}
		}
		HelloWorld helloworld = (HelloWorld)obj;
		helloworld.sayHello();
		
	}
	@Test
	public void testName1() throws Exception {
		//创建Sping容器
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		HelloWorld h = null;
		h =  beanFactory.getBean("helloworld",HelloWorld.class);
		h.sayHello();
	}
}
