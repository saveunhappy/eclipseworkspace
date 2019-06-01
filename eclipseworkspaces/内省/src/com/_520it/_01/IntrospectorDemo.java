package com._520it._01;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectorDemo {
	public static void main(String[] args) throws Exception{
		//获取javaBean的描述对象
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		//获取javaBean中的属性的描述器
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor p : propertyDescriptors) {
			System.out.println("属性名"+p.getName());
			System.out.println("getter"+p.getReadMethod());
			System.out.println("setter"+p.getWriteMethod());
		}
	}
}
