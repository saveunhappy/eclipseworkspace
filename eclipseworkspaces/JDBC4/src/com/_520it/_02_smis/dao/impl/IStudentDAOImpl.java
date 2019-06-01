package com._520it._02_smis.dao.impl;

import java.util.List;

import com._520it._02_smis.dao.IStudentDAO;
import com._520it._02_smis.domain.Student;
import com._520it._02_smis.handler.BeanHandler;
import com._520it._02_smis.handler.BeanListHandler;
import com._520it._02_smis.util.JdbcTemplate;
//璐剧悘娆叉墽浜�
public class IStudentDAOImpl implements IStudentDAO{

	@Override
	public void save(Student stu) {
		JdbcTemplate.update("INSERT INTO t_student (name,age) VALUES(?,?)",stu.getName(),stu.getAge());
		
	}

	@Override
	public void delete(Long id) {
		JdbcTemplate.update("DELETE FROM t_student  where id=?", id);
		
	}

	@Override
	public void update(Long id, Student stu) {
		String sql = "UPDATE t_student SET name =?,age =? where id=?";
		JdbcTemplate.update("UPDATE t_student SET name =?,age =? where id=?", stu.getName()
				,stu.getAge(),id);
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?";
		return JdbcTemplate.query("SELECT * FROM t_student WHERE id = ?",new BeanHandler<>(Student.class),id);
		
	}

	@Override
	public List<Student> listAll() {
		return JdbcTemplate.query("SELECT * FROM t_student",new BeanListHandler<>(Student.class));
	}

}
//把结果集中每一行数据封装成一个student对象 
//class StudentResultSetHandler implements IResultSetHandler<List<Student>>{
//	@Override
//	public List<Student> handle(ResultSet rs) throws Exception {
//		
//		List<Student> list = new ArrayList<>();
//		while(rs.next()) {
//			 Student stu = new Student();
//			 stu.setId(rs.getLong("id"));
//			 stu.setName(rs.getString("name"));
//			 stu.setAge(rs.getInt("age"));
//			 
//			 list.add(stu);
//		 }
//		return list;
//	}
//	
//}