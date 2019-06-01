package com.mypack.dao.impl;

import java.util.List;

import com.mypack.dao.IStudentDAO;
import com.mypack.domain.Student;
import com.mypack.handler.BeanHandler;
import com.mypack.handler.BeanListHandler;
import com.mypack.util.JdbcTemplate;
//璐剧悘娆叉墽浜�
public class IStudentDAOImpl implements IStudentDAO{

	@Override
	public void save(Student stu) {
		JdbcTemplate.update("INSERT INTO t_student (username,password) VALUES(?,?)",stu.getUsername(),stu.getPassword());
		
	}

	

	@Override
	public void delete(Long id) {
		JdbcTemplate.update("DELETE FROM t_student  where id=?", id);
		
	}

	@Override
	public void update(Student stu) {
		JdbcTemplate.update("UPDATE t_student SET username =?,password =? where id=?", stu.getUsername()
				,stu.getPassword(),stu.getId());
	}

	@Override
	public Student get(Long id) {
		return JdbcTemplate.query("SELECT * FROM t_student WHERE id = ?",new BeanHandler<>(Student.class),id);
		
	}

	@Override
	public List<Student> listAll() {
		return JdbcTemplate.query("SELECT * FROM t_student",new BeanListHandler<>(Student.class));
	}



	@Override
	public Student getUserByUsername(String username) {
		String sql = "select * from t_student where username = ?";
		return JdbcTemplate.query(sql, new BeanHandler<>(Student.class), username);
	}

}

