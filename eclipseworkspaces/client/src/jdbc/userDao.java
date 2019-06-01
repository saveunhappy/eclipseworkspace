package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import User.UserBean;
import car.book;

public class userDao {
	
	public boolean findAll(String username){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean f = false;
		try {
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("username").equals(username)){
					f = true;
				}
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return f;
	}
	
	public book get_Book(String book_id){		//根据书籍id从数据库获取书籍信息；
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			book_id = "\'"+book_id+"\'";
			String sql = "select * from book where book_id = " + book_id +";";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String book_name = rs.getString("book_name");
				String book_writer = rs.getString("book_writer");
				double book_price = rs.getDouble("book_price");
				int book_kucun = rs.getInt("book_kucun");
				String book_img_path = rs.getString("book_img_path");
				
				book onebook = new book();
				onebook.setBook_name(book_name);
				onebook.setBook_writer(book_writer);
				onebook.setBook_kucun(book_kucun);
				onebook.setBook_price(book_price);
				onebook.setBook_img_path(book_img_path);
				return onebook;
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
	
		return null;
	}
	
	
	public boolean ch_User(String username,String password){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean f = false;
		try {
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
					f = true;
				}
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return f;
	}

	public boolean inset(UserBean user){
		PreparedStatement pst = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getconnection();
			String sql = "insert into user(username,password,email,sex,telephone,introduce) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getSex());
			pst.setString(5, user.getTelephone());
			pst.setString(6, user.getIntroduce());
			int n = pst.executeUpdate();
			boolean b = findAll(user.getUsername());
			if(n>0 && b){
				return true;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst, conn);
		}
		return false;
		
	}
	
	/*****提交订单*****************/
	public boolean inset_order(String order_id,String book_id,int number){
		PreparedStatement pst = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getconnection();
			String sql = "insert into order_xq(order_id,book_id,number) values(?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, order_id);
			pst.setString(2, book_id);
			pst.setInt(3, number);
			int n = pst.executeUpdate();

			if(n>0){
				return true;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst, conn);
		}
		return false;
	}
	
	/*****提交用户与订单对应表（user_order)*****************/
	public boolean inset_user_order(String user_id,String order_id,String address,String phone,double sum){
		PreparedStatement pst = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getconnection();
			String sql = "insert into user_order(user_id,order_id,address,phone,sum) values(?,?,?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			pst.setString(2, order_id);
			pst.setString(3, address);
			pst.setString(4, phone);
			pst.setDouble(5, sum);
			int n = pst.executeUpdate();

			if(n>0){
				return true;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pst, conn);
		}
		return false;
	}
	
	
}
