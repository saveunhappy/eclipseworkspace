package file;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo3 {
	public static void main(String[] args) {
		/**
		 * 
		 */
		File file = new File("C:\\Users\\侯江涛\\Desktop\\js练习用的");

		File file1 = new File("js练习用的");
		//获取文件绝对路径的字符串
		String str = file.getAbsolutePath();
		System.out.println(str);
		String str1 = file.getPath();
		System.out.println(str1);
		
		//获取文件绝对路径的字符串
		String str2 = file1.getAbsolutePath();
		System.out.println(str2);
		//获取的就是相对路径
		String str3 = file1.getPath();
		System.out.println(str3);
//		返回相对路径的文件或者目录的名字（带后缀名）
		String str4 = file.getName();
		System.out.println(str4);
		//返回文件的长度，按照字节来计算的
		long length = file.length();
		System.out.println(length);
		//最后一次被修改的时间
		long modified = file.lastModified();
		
		Date date = new Date(modified);
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//字符串接收的
		String date1 = sdf.format(date);
		System.out.println(date1);
		
		//字符串转换为日期
		String str10 = "1999-02-12 11:11:11";
		try {//注意一定要和指定的格式匹配
			Date date2 = sdf.parse(str10);
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
