package properties;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Demo7 {
	public static void main(String[] args) {
		
		/**
		 * java.lang.Object
  			继承者 java.util.Dictionary<K,V>
      			继承者 java.util.Hashtable<Object,Object>
          			继承者 java.util.Properties
		属性集类
		 * 这个不用指定泛型以为API中就没有指定，这个就是只能用字符串。字符串就是指定的泛型
		 */
		Properties pro = new Properties();
		/**
		 * 就把Properties当成map来使用就行了
		 */
		pro.setProperty("name", "zhangsan");
		pro.setProperty("age", "18");
		pro.setProperty("gender", "male");
		FileWriter fr = null;
		
	
		try {
			fr = new FileWriter("properties2.txt");
			//把字符流数据读到pro对象中
			pro.store(fr, null);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
