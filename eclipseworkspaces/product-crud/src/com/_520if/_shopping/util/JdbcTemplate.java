package com._520if._shopping.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com._520if._shopping.handler.IResultSetHandler;

//Jdbc操作的模板类
public class JdbcTemplate {
	public static <T>T query(String sql,IResultSetHandler<T> rsh,Object...params){
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			 conn = JdbcUtil.getCon();
			 ps = conn.prepareStatement(sql);
			 //设置占位符参数
			 for (int index = 0; index < params.length; index++) {
				 ps.setObject(index + 1, params[index]);
			}
			 //将rs这个结果就对象传入IResultSetHandler中
			 rs = ps.executeQuery();

			 //IResultSetHandler的形参中就是传入一个结果集，传入进去之后实现类中有对应的一个结果集还是多个结果集
			 return  rsh.handle(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, rs);
		}
		throw new RuntimeException("查询有错");
	}
	
	
	public static int update(String sql,Object...params) {
 		Connection conn = null;
		PreparedStatement ps= null;
		
		try {
			 conn = JdbcUtil.getCon();
			 ps = conn.prepareStatement(sql);
			 for (int index = 0; index < params.length; index++) {
				 ps.setObject(index + 1, params[index]);
			}
			 return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
		return 0;
	}
}
