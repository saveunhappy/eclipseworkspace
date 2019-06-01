package properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo6 {
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
		FileReader fr = null;
		
		/**
		 * 就把Properties当成map	来使用就行了
		 */
		try {
			fr = new FileReader("properties.txt");
			//把字符流数据读到pro对象中
			pro.load(fr);
			String name = pro.getProperty("行者");
			String age = pro.getProperty("鼓上蚤");
			String gender = pro.getProperty("呼保义");
			/**
			 * 输出的是键后面的东西，如果键后面有自己写的东西也会被读取出来
			 */
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fr!=null) {
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
