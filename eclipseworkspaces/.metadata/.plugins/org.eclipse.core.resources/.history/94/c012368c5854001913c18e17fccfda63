package test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.domain.Department;
import com.ssh.domain.Employee;
import com.ssh.service.IDepartmentService;
import com.ssh.service.IEmployeeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {
	@Autowired
	private IDepartmentService dpservice;
	@Autowired
	private IEmployeeService service;
	
	
	@Test
	public void testSave1() {
		
		Department d = new Department();
		d.setName("hehe");
		dpservice.save(d);
	}

	
	@Test
	public void testSave() {
		
		Employee e = new Employee();
		e.setName("中国厉害");
		service.save(e);
	}

	@Test
	public void testUpdate() {
		Employee e = new Employee();
		e.setName("niubi");
		e.setId(4L);
		service.update(e);
	}

	@Test
	public void testDelete() {
		Employee e = new Employee();
		e.setId(4L);
	}

	@Test
	public void testGet() {
		System.out.println(service.get(12L));
		//System.out.println(service.getUserByUsername("lisi"));
	}

	@Test
	public void testListAll() {
		/*List<Employee> em = service.listAll();
			for (Employee e : em) {
				System.out.println(e);
			}*/
			List<Department> listAll = dpservice.listAll();
			for (Department department : listAll) {
				System.out.println(department);
			}
	}

}
