package sss;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class Demo1 {
	
@Test

	
	public void test1() throws Exception {
		//加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection con = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
//		先睡一小下下，否则看不到mysql的进行
		Thread.sleep(5000);
	}
}
