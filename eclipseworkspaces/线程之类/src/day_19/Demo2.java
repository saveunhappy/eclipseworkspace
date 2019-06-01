package day_19;

import java.io.File;
import java.io.FilenameFilter;

public class Demo2 {
	public static void main(String[] args) {
		//文件过滤器
		File dir = new File("C:\\Users\\侯江涛\\Desktop\\123");
//		String[] str = dir.list();
		File[] fs = dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				//第二个参数name就是list()，里面都是列表的文件，前面的是路径，这样结合起来就相当于是一个路径了
				//当它是文件而且是以.avi结尾就返回true 否则返回false  返回true就返回了列表，false就不返回
				return new File(dir,name).isFile()&&name.endsWith(".avi");
			}
		});
		for (File file : fs) {
			System.out.println(file);
		}
	}
}
