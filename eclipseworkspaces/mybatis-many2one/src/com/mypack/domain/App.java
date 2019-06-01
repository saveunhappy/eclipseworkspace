package com.mypack.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.mapper.DepartmentMapper;
import com.mypack.mapper.EmployeeMapper;
import com.mypack.util.MybatisUtil;

public class App {
	//保存一个部门和两个员工
	@Test
	public void testName() throws Exception {
		Department d = new Department();
		d.setName("开发部");
		Employee e1 = new Employee();
		e1.setName("张三");
		Employee e2 = new Employee();
		e2.setName("李四");
		//维护对象的关系
		 e1.setDept(d);
		 e2.setDept(d);
		 
		 SqlSession session = MybatisUtil.getSession();
		 EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		 DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 //保存操作
		 departmentMapper.save(d);
		 employeeMapper.save(e1);
		 employeeMapper.save(e2);
		 session.commit();
	}
	@Test
	public void testGet() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		 EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		 DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		 Employee e = employeeMapper.get(1L);
		 //现在已经拥有员工所在部门的ID，但是期望得到的是department对象
		 //解决方案：根据部门的ID，再额外的发送一条SQL，查出部门对象，把部门对象设置给员工
		 /**
		  * 这个不应该让我们开发者来写，应该让mybatis来写
		  *  Long id = e.getDept().getId();
		 	Department d = departmentMapper.get(id);
		 	e.setDept(d);
		  */
		//System.out.println(e.getName());
		//System.out.println(e);
		 System.out.println(e.getDept());
		 
	}
	
	@Test
	public void test3() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		List<Employee> es = mapper.ListAll();
		for (Employee e : es) {
			System.out.println(e);
		}
		
		
	}
	
}
