package com._520it._03_xt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com._520it.util.JdbcUtil;

public class TxDemo {
	// 银行转账案例
	@Test
	public void test1() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from account where name = ? and balance >= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "张无忌");
		ps.setInt(2, 1000);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			throw new RuntimeException("余额不足");

		}
		// 减少张无忌1000
		sql = "update account set balance = balance - ? where name = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "张无忌");
		ps.executeUpdate();

		//int a = 1 / 0;
		// 增加赵敏1000
		sql = "update account set balance = balance + ? where name = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "赵敏");
		ps.executeUpdate();
		JdbcUtil.close(conn, ps, rs);

	}

	@Test
	public void test2() {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select * from account where name = ? and balance >= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张无忌");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("余额不足");

			}
			// 减少张无忌1000
			sql = "update account set balance = balance - ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "张无忌");
			ps.executeUpdate();

			int a = 1 / 0;
			// 增加赵敏1000
			sql = "update account set balance = balance + ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "赵敏");
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			JdbcUtil.close(conn, ps, rs);
		}

	}
}
