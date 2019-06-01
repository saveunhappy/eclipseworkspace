package webhome;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHander<T> implements IResultSetHander<T>{
	private Class<T> classType;

	public BeanHander() {
	}

	public BeanHander(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public T handle(ResultSet rs) throws Exception {
		T obj = classType.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(classType,Object.class);
		PropertyDescriptor[] propertyDescriptor = beanInfo.getPropertyDescriptors();
		if(rs.next()) {
		for (PropertyDescriptor ps : propertyDescriptor) {
			String column = ps.getName();
			Object val = rs.getObject(column);
			ps.getWriteMethod().invoke(obj, val);
		}
		}
		return obj;
		
		
		
		
		
	
	}

		
}
