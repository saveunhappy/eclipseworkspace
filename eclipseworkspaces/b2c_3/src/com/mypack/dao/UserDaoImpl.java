package com.mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypack.entity.User;

public class UserDaoImpl extends BaseDao implements UserDaoIF {

	@Override
	public User queryUserByUsername(User user)  {

		String sql="select * from user where username=?";//? 占位符
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User u=null;
		try {
			pstmt = conn.prepareStatement(sql);
			//执行查询之前一定要给sql语句中参数设置值  
			//第一个参数表示?位置 从1开始   第二个参数是要设置的值
			pstmt.setString(1, user.getUsername());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				String username=rs.getString(1);
				String password=rs.getString(2);
				u=new User(username, password);   
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
		
			close(rs, pstmt, conn);
		}
		return u;
	}

	@Override
	public boolean addUser(User user) {

		boolean flag=false;
		String sql="insert into user values(?,?,?)";//? 占位符
		
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql); 
			
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getTel());
			
			// ResultSet executeQuery()  执行查询  int executeUpdate() 执行增删改
			int row=pstmt.executeUpdate();
			if(row>0){
				System.out.println("添加了"+row+"行");
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//增删改没有结果集对象
			close(pstmt, conn);
		}
		return flag;
	}

}
