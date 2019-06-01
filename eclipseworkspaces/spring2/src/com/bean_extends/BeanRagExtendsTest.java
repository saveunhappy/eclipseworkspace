package com.bean_extends;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanRagExtendsTest {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private DepartmentDAO departmentDAO;
	@Test
	public void testName() throws Exception {
		employeeDAO.save();
		departmentDAO.save();
	}
}
