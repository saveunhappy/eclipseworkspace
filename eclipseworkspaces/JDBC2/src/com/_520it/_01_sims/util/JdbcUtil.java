package com._520it._01_sims.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//JDBC的工具类
public class JdbcUtil {
	// 连接数据库的四要素
	/*
	 * private static String drvierClassName = null; private static String url =
	 * null; private static String username = null; private static String password =
	 * null; !!已经不需要了
	 */
	private static Properties p = new Properties();
	static {// 当jdbcUtil这份字节码对象加载进JVM的时候就执行这里的静态代码块，而且只执行一次

		try {
			// 加载和读取db.properties文件
			InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			p.load(inStream);
			Class.forName(p.getProperty("driverClassName"));// 1: 加载注册驱动
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 返回一个connection对象
	public static Connection getConnection() {
		try {
			// 2:��ȡ���Ӷ���
			return DriverManager.getConnection(//
					//通过key来拿value 底层是一个map
					p.getProperty("url")//获取URL的值
					, p.getProperty("username"), //获取用户名的值
					p.getProperty("password"));//获取密码的值
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		}
	}
}
