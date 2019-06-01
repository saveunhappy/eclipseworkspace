package com.mypack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	String driverClassName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/text";//
	String username="root";
	String password="root";
	
	public Connection getConn(){
		Connection conn=null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement pstmt,Connection conn){
		try {			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
