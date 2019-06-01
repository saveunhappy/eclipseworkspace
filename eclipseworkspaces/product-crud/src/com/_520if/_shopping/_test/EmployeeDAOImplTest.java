package com._520if._shopping._test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com._520if._shopping._dao.IEmployeeDAO;
import com._520if._shopping._dao._Impl.EmployeeDAOImpl;
import com._520if._shopping._domain.Employee;

public class EmployeeDAOImplTest {
	private IEmployeeDAO dao = new EmployeeDAOImpl();
	@Test
	public void testSave() {
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testGet() {
		Employee employee = dao.get(2L);
		System.out.println(employee);
	}
	@Test
	public void testList() {
		 List<Employee> list = dao.list();
		 for (Employee employee : list) {
			System.out.println(employee);
		}
	}


	@Test
	public void testQuery() {
	}

}
