package com._zz._it.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{
	private Class<T> classType;
	
	public BeanListHandler() {
	}
	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}
	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		
		while(rs.next()) {
			//每一行，封装成一个数据
			T obj = classType.newInstance();
			list.add(obj);
			BeanInfo beanInfo = Introspector.getBeanInfo(classType,Object.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
				for (PropertyDescriptor ps : propertyDescriptors) {
					//获取对象的属性名。和列名一致
					String column = ps.getName();
					Object val = rs.getObject(column);
					//调用setter方法吧某一列的值给设置进去
					ps.getWriteMethod().invoke(obj, val);
					//把每一行对应的对象，存储到list集合中
				}
		}
		
		return list;
	}

}
