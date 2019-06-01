package reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

class Emp {
		public static void doWork(int...arr) {
			System.out.println("dowork被调用"+Arrays.toString(arr));
		}
}


public class Demo5 {
	public static void main(String[] args) throws Exception {
		//情况1：数组的元素类型是基本类型
		Class<Emp> clz = Emp.class;
		Method m = clz.getMethod("doWork", int[].class);

		Object obj = m.invoke(null, new Object[] {(new int[] {1,2,3,4,5})});
			System.out.println(obj);
		//情况2：数组的元素类型是引用类型
	}
}
