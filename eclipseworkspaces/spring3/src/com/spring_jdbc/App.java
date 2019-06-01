package com.spring_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_jdbc.dao.IEmployeeDAO;
import com.spring_jdbc.domain.Employee;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class App {
	@Autowired
	private IEmployeeDAO dao;
	@Test
	public void tes1() throws Exception {
		Employee e = new Employee();
		e.setName("乔峰");
		e.setAge(10);
		dao.save(e);
	}
	@Test
	public void tes12() throws Exception {
		Employee e = new Employee();
		e.setName("西门");
		e.setAge(10);
		e.setId(1L);
		dao.update(e);
	}
	@Test
	public void tes121() throws Exception {
		dao.delete(1L);
	}

}
