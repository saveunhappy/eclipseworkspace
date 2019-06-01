package com._520it._05introspactor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class Beanutils {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setAge(18);
		user.setMan(true);
		user.setName("张三");
		Map<String,Object> map = bean2map(user);
		System.out.println(map);
		User obj = map2bean(map, User.class);
		System.out.println(obj);
	}
	public static Map<String,Object> bean2map(Object bean) throws Exception{
		Map<String,Object> map = new HashMap<>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(),Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String name = pd.getName();
			//invoke第一个参数是所属对象，第二个是传入的参数，没有就不传了read方法就是getter方法。
			//然后再用invoke来调用
			Object value = pd.getReadMethod().invoke(bean);
			map.put(name, value);
		}
		return map;
	}
	
	public static <T>T map2bean(Map<String,Object> map,Class<T> beanType) throws Exception {
		//创建一个javaBean对象
		Object obj = beanType.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(beanType,Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Object value = map.get(pd.getName());
			pd.getWriteMethod().invoke(obj, value);
		}
		return (T) obj;
		
	}
}
