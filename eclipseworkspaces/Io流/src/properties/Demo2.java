package properties;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

public class Demo2 {
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
		try {
		 pw = new PrintWriter(new FileWriter("properties.txt"),true);
		 Set<Object> keys = pro.keySet();
		 for(Object obj:keys) {
			 String key = (String) obj; 
			 String value = pro.getProperty(key);
			 pw.println(key+"======"+value);
		 }
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pw!=null) {
				pw.close();
			}
		}
		
	}
}
