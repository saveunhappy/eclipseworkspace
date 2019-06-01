package properties;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

public class Demo4 {
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
		PrintWriter pw = null;
		try {//这个就是输出到控制台
		 pw = new PrintWriter("propertise1.txt");
		 pro.list(pw);
		 
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pw!=null) {
				pw.close();
			}
		}
		
	}
}
