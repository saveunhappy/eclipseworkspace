package properties;

import java.util.Properties;

public class Demo1 {
	public static void main(String[] args) {
		
		/**
		 * java.lang.Object
  			继承者 java.util.Dictionary<K,V>
      			继承者 java.util.Hashtable<Object,Object>
          			继承者 java.util.Properties
		属性集类
		 * 这个不用指定泛型以为API中就没有指定
		 */
		Properties pro = new Properties();
		pro.setProperty("行者","武松");
		pro.setProperty("鼓上蚤","时迁");
		pro.setProperty("呼保义","宋江");
		System.out.println(pro);
		String xingzhe = pro.getProperty("行者");
		String gushangzao = pro.getProperty("鼓上蚤");
		String hubaoyi = pro.getProperty("呼保义");
		System.out.println(xingzhe);
		System.out.println(gushangzao);
		System.out.println(hubaoyi);
		
	}
}
