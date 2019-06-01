package annotation;

import java.util.HashSet;
import java.util.Set;

public class Demo1 {
	/*
	 * 
	 java5开始，java开始对元数据的支持，也就是annotation(注解/标签)
	 所有的annotation是java.lang.annotation.Annotation接口的子接口，所以Annotation是一种特殊的接口(
	 枚举也是特殊的类)
	 使用注解，标签Annotation都是一体。
	 使用注解被用来为程序元素(类，方法，成员变量等)设置元数据
	 注解，标签，Annotation都是一体
	 -------------------------------
	 使用注解需要注意，必须有第三方参与才有意义
	 1：得有注解标签；
	 2：被帖的	程序元素(类，字段，方法，构造器等)
	 3：由第三方的程序来赋予注解特殊的功能(也就是java代码)
	 */
	/*
	 * @Override 限定复写父类的方法
	 * @Deprecated 标记以过时 不推荐使用
	 * @SuppressWarnings(Value = "all")抑制发出的警告
	 */
	
	public static void main(String[] args) {
		@SuppressWarnings(value ="all")
		Set set = new HashSet();
	}
}
