package com._520it._04_return;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com._520it.util.JdbcUtil;

public class ReturnPkDemo {
	@Test
	public void test1() throws Exception {
		String sql = "insert into t_student (name,age) values('aa',22)";
		Connection conn = JdbcUtil.getConnection();
		Statement st = conn.createStatement();
		st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.getGeneratedKeys();
		if(rs.next()) {
			Long id = rs.getLong(1);
			System.out.println(id);
		}
		JdbcUtil.close(conn, st, null);
	}
	@Test
	public void test2() throws Exception {
		String sql = "insert into t_student (name,age) values(?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "bb");
		ps.setInt(2, 12);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			Long id = rs.getLong(1);
			System.out.println(id);
		}
		JdbcUtil.close(conn, ps, rs);
	}
}
