package com.mypack.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

//JDBC的工具类
public class JdbcUtil {
		private static DataSource ds = null;
	static {
			
		try {
			Properties  p = new Properties();
			 
			p.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties"));
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 返回一个connection对象
	public static Connection getConnection() {
		try {
			return ds.getConnection();
			
		} catch (Exception e) {

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
