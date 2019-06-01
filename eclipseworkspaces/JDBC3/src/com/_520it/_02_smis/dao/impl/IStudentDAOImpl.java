package com._520it._02_smis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com._520it._02_smis.dao.IStudentDAO;
import com._520it._02_smis.domain.Student;
import com._520it.util.JdbcUtil;
//璐剧悘娆叉墽浜�
public class IStudentDAOImpl implements IStudentDAO{

	@Override
	public void save(Student stu) {
		String sql = "INSERT INTO t_student (name,age) VALUES(?,?)";
		Connection conn = null;
		PreparedStatement ps= null;
		
		try {
			//璐剧悘
			 conn = JdbcUtil.getConnection();
			//娆�
			 ps = conn.prepareStatement(sql);
			 //鎵�
			 ps.setString(1, stu.getName());
			 ps.setInt(2, stu.getAge());
			 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_student  where id=?";
		Connection conn = null;
		PreparedStatement ps= null;
		
		try {
			//璐剧悘
			 conn = JdbcUtil.getConnection();
			//娆�
			 ps = conn.prepareStatement(sql);
			 //鎵�
			 ps.setLong(1, id);
			 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
		
	}

	@Override
	public void update(Long id, Student stu) {
		String sql = "UPDATE t_student SET id =?,age =? where id=?";
		Connection conn = null;
		PreparedStatement ps= null;
		
		try {
			//璐剧悘
			 conn = JdbcUtil.getConnection();
			//娆�
			 ps = conn.prepareStatement(sql);
			 //鎵�
			 ps.setString(1, stu.getName());
			 ps.setInt(2, stu.getAge());
			 ps.setLong(3, id);
			 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try {
			//璐剧悘
			 conn = JdbcUtil.getConnection();
			//娆�
			 ps = conn.prepareStatement(sql);
			 //鎵�
			 ps.setLong(1, id);
			 rs = ps.executeQuery();
			 if(rs.next()) {
				 Student stu = new Student();
				 stu.setId(rs.getLong("id"));
				 stu.setName(rs.getString("name"));
				 stu.setAge(rs.getInt("age"));
				 
				 return stu;
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Student> listAll() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM t_student";
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			//璐剧悘
			 conn = JdbcUtil.getConnection();
			//娆�
			 ps = conn.prepareStatement(sql);
			 //鎵�
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 Student stu = new Student();
				 stu.setId(rs.getLong("id"));
				 stu.setName(rs.getString("name"));
				 stu.setAge(rs.getInt("age"));
				 
				 list.add(stu);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
	}

}
