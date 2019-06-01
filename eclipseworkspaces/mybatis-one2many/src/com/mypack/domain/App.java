package com.mypack.domain;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.mapper.DepartmentMapper;
import com.mypack.mapper.EmployeeMapper;
import com.mypack.util.MybatisUtil;

public class App {
	//查询10号部门信息和包含的员工
	@Test
	public void testName() throws Exception {
	
		 
		 
		 SqlSession session = MybatisUtil.getSession();
		 EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		 DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 
		 Department d = departmentMapper.get(10L);
		 System.out.println(d.getEmps());
	}
	
	
}
