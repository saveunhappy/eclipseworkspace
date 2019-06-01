package com._520it._05introspactor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

//内省机制和Javabean规范
public class IntrospectorDemo {
	public static void main(String[] args) throws Exception {
		/**
		 * javabean规范：
		 * 1：类必须使用public修饰
		 * 2：必须有公共的无参数构造器
		 * 3：包含属性的操作方法
		 */
		//1：获取javabean的描述对象 
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		//获取javabean的属性描述器
		for (PropertyDescriptor pd : descriptors) {
			String name = pd.getName();
			Method readMethod = pd.getReadMethod();
			Method writeMethod = pd.getWriteMethod();
			System.out.println(name);
			System.out.println(readMethod);
			System.out.println(writeMethod);
			System.out.println("--------------------");
		}
	}
}
