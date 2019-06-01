package com.spring_jdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.spring_jdbc.dao.IEmployeeDAO;
import com.spring_jdbc.domain.Employee;

public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployeeDAO{
	
	//private JdbcTemplate jdbcTemplate;
	
	//public void setDataSource(DataSource ds) {
	//	this.jdbcTemplate = new JdbcTemplate(ds);
	//}
	
	public void save(Employee emp) {
		//jdbcTemplate.update("INSERT INTO employee (name,age) VALUES(?,?)", emp.getName(),emp.getAge());
	}

	public void update(Employee emp) {
		super.getJdbcTemplate().update("UPDATE employee set name=?,age=? where id = ?", emp.getName(),emp.getAge(),emp.getId());
	}

	public void delete(Long id) {
	//	jdbcTemplate.update("delete from employee where id = ?",id);
	}

	public Employee get(Long id) {
		return null;
	}

	public List<Employee> listAll() {
		return null;
	}

}
