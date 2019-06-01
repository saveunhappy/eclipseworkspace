package com._520it._01_proparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com._520it.util.JdbcUtil;

//预编译语句对象
public class ProparedStatmentTest {
	@Test
	public void testSaveByStatement() throws Exception{
		String sql = "insert into t_student (name,age) values('aa',18)";
		Connection conn = JdbcUtil.getConnection();//贾琏
		Statement st = conn.createStatement();//欲
		st.executeUpdate(sql);//执
		JdbcUtil.close(conn, st, null);//事
		
		
	}
	
	@Test
	public void testSaveByProparedStatement() throws Exception{
		String sql = "INSERT INTO t_student (name,age) values(?,?)";//SQl模板
		Connection conn = JdbcUtil.getConnection();//贾琏
		PreparedStatement ps = conn.prepareStatement(sql);//欲
		//-----------------------------------
		ps.setString(1, "AA");
		ps.setInt(2, 12);
		ps.executeUpdate();
		//----------------------------------------
		JdbcUtil.close(conn, ps, null);//事
	}
	
}
