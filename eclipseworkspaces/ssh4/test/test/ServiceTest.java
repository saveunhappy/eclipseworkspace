package test;


import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.filter.config.ConfigTools;
import com.ssh.domain.Department;
import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;
import com.ssh.service.IDepartmentService;
import com.ssh.service.IEmployeeService;

import freemarker.template.Configuration;
import freemarker.template.Template;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {
	@Autowired
	private IDepartmentService dpservice;
	@Autowired
	private IEmployeeService service;
	
	@Test
	public void testN() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		//qo.setDeptId(1L);
		qo.setKeyword("test");
		 PageResult query = service.query(qo);
		 System.out.println(query.getTotalCount());
		for (Object employee : query.getResult()) {
			System.out.println(employee);
		}
	}
	@Test
	public void Freemark() throws Exception {
		//1.创建一个配置对象
		Configuration config = new Configuration(Configuration.VERSION_2_3_22);
		//2.设置从哪个目录去加载模板文件
		config.setDirectoryForTemplateLoading(new File("templates"));
		//3.获取模板对象
		Template template = config.getTemplate("hello.html");
		//添加数据
		Map<String,Object> dataModel = new HashMap<>();
		dataModel.put("name", "will");
		dataModel.put("age", 17);
		Writer out = new FileWriter("test.html");
		template.process(dataModel, out);
		
		
		
	}
	@Test
	public void testSave12() {
		
		String msg = "{0}是{1}";
		String format = MessageFormat.format(msg, "阿彪","帅哥");
		System.out.println(format);
		
	}
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
	public void testDelete() throws Exception {
	/*	Employee e = new Employee();
		e.setId(4L);*/
		
		String string = ConfigTools.encrypt("root");
		System.out.println(string);
	}

	@Test
	public void testGet() {
		//System.out.println(service.get(13L));
		//System.out.println(service.getUserByUsername("lisi"));
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());
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
