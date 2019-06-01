package moniJuit4;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {
		//获得字节码对象
		Class clz = EmployeDao.class;
		//测试类对象
		Object obj = clz.newInstance();
		//获得所有方法
		Method[] ms = clz.getMethods();
		List<Method> beforeList = new ArrayList<>();
		List<Method> afterList = new ArrayList<>();
		List<Method> testList = new ArrayList<>();
		for (Method method : ms) {
			if(method.isAnnotationPresent(MyBefore.class)) {
				beforeList.add(method);
			}else if(method.isAnnotationPresent(MyAfter.class)) {
				afterList.add(method);
			}else if(method.isAnnotationPresent(MyTest.class)) {
				testList.add(method);
			}
		}
		for (Method m : testList) {
			for (Method bm : beforeList) {
				bm.invoke(obj);
			}
			m.invoke(obj);
			for (Method am : afterList) {
				am.invoke(obj);
			}
		}
	}
}
