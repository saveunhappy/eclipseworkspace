package 叩丁狼;

import java.io.File;

public class Demo1 {
	public static void main(String[] args) {
		//获得属性分隔符:
		String pathSeparator = 	File.pathSeparator;
		
		char patSeparatorChar = File.pathSeparatorChar;
		
		System.out.println(pathSeparator);
		System.out.println(patSeparatorChar);
		
		//获得路径分隔符
		String seperator = File.separator;
		char seperatorChar = File.separatorChar;
		System.out.println(seperator);
		System.out.println(seperatorChar);
		/*
		 * 
				boolean isAbsolute() 
			          测试此抽象路径名是否为绝对路径名。 
			 boolean isDirectory() 
			          测试此抽象路径名表示的文件是否是一个目录。 
			 boolean isFile() 
			          测试此抽象路径名表示的文件是否是一个标准文件。 
			 boolean isHidden() 
			          测试此抽象路径名指定的文件是否是一个隐藏文件。 
			 long lastModified() 
			          返回此抽象路径名表示的文件最后一次被修改的时间。 
			 long length() 
			          返回由此抽象路径名表示的文件的长度。 

		  */
		
		/*
		 * 
					 
			 boolean canExecute() 
			          测试应用程序是否可以执行此抽象路径名表示的文件。 
			 boolean canRead() 
			          测试应用程序是否可以读取此抽象路径名表示的文件。 
			 boolean canWrite() 
			          测试应用程序是否可以修改此抽象路径名表示的文件。 
			 int compareTo(File pathname) 
			          按字母顺序比较两个抽象路径名。 
			 boolean createNewFile() 
			          当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。 
			static File createTempFile(String prefix, String suffix) 
			          在默认临时文件目录中创建一个空文件，使用给定前缀和后缀生成其名称。 
			static File createTempFile(String prefix, String suffix, File directory) 
			           在指定目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称。 
			 boolean delete() 
			          删除此抽象路径名表示的文件或目录。 
			 void deleteOnExit() 
			          在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。 
			 boolean equals(Object obj) 
			          测试此抽象路径名与给定对象是否相等。 
			 boolean exists() 
			          测试此抽象路径名表示的文件或目录是否存在。 

		 */
		
	}
}
