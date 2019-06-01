package webhome;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHander<T> implements IResultSetHander<T>{
	private Class<T> classType;
	public BeanListHander(Class<T> classType) {
		this.classType = classType;
	}
	
	@Override
	public T handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while(rs.next()) {
			T obj = classType.newInstance();
			list.add(obj);
			BeanInfo beanInfo = Introspector.getBeanInfo(classType,Object.class);
			PropertyDescriptor[] p = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor ps : p) {
				String column = ps.getName();
				Object val = rs.getObject(column);
				ps.getWriteMethod().invoke(obj, val);
			}
		}
		
		return null;
	}
	
}
