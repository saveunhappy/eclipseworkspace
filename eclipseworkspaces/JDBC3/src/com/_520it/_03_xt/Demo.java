package com._520it._03_xt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com._520it.util.JdbcUtil;

public class Demo {
	@Test
	public void testName() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 3001; i++) {
			String sql = "insert into t_student (name,age) values('aa',12)";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
	@Test
	public void test1() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		Statement st = conn.createStatement();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 3001; i++) {
			String sql = "insert into t_student (name,age) values('aa',"+i+")";
			st.addBatch(sql);
			if(i % 200 ==0) {
				st.executeBatch();
				st.clearBatch();
			}
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
	@Test
	public void test3() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		long begin = System.currentTimeMillis();
		String sql = "insert into t_student (name,age) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < 3001; i++) {
			ps.setString(1, "aa");
			ps.setInt(2, i);
			ps.addBatch();
			if(i % 200 ==0) {
				ps.executeBatch();
				ps.clearBatch();
				ps.clearParameters();
			}
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
}
