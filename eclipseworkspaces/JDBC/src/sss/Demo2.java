package sss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo2 {
	//贾琏欲执事
	
	@Test
	public void testName() throws Exception {
		String sql = "create table t_student (id bigint(20) primary key auto_increment,name varchar(20),age int(11));";
		//1:加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
//		2:获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
//		3:创建语句对象
		Statement st = conn.createStatement();
		
//		4:执行SQL语句
//		5:关闭资源
		st.close();
		conn.close();
	}
	@Test
	public void testName1() throws Exception {
		String sql = "SELECT count(id) from t_student";
		//1:加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
//		2:获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
		
//		3:创建语句对象
		Statement st = conn.createStatement();
		
//		4:执行SQL语句
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			long total = rs.getLong("count(id)");
			System.out.println(total);
		}
		rs.close();
		st.close();
		conn.close();
//		5:关闭资源
	}

	@Test
	public void testName3() throws Exception {
		String sql = "SELECT * FROM t_student WHERE id = 1";
		//1:加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
//		2:获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
		
//		3:创建语句对象
		Statement st = conn.createStatement();
		
//		4:执行SQL语句
		ResultSet re = st.executeQuery(sql);
		while(re.next()) {
			long id = re.getLong("id");
			String name = re.getString("name");
			int age = re.getInt("age");
			System.out.println(id+","+name+","+age);
			
		}
//		5:关闭资源
		re.close();
		st.close();
		conn.close();
	}
}
