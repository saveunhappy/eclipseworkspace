package com._520if._shopping.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T>{
	private Class<T> classType;
	public BeanHandler(Class<T> classType) {
		this.classType = classType;
	}
	@Override
	public T handle(ResultSet rs) throws Exception {
		//创建对应类的一个对象
		T obj = classType.newInstance();
		//取出结果集中当前光标所在行的某一行的数据
		BeanInfo beanInfo = Introspector.getBeanInfo(classType,Object.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if(rs.next()) {
			for (PropertyDescriptor ps : propertyDescriptors) {
				String column = ps.getName();
				Object  val = rs.getObject(column);
				ps.getWriteMethod().invoke(obj, val);
			}
			
		}
		return obj;
	}
	
}
