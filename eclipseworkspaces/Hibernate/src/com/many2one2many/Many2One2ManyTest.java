package com.many2one2many;
/**
 * 针对单向many2one的测试
 * @author HJT
 *
 */

import java.util.Set;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.util.HibernateUtil;

public class Many2One2ManyTest {
	@Test
	public void testSave() throws Exception {
		Department dept = new Department();
		dept.setName("d");
		
		Employee e1 = new Employee();
		e1.setName("e1");
		
		Employee e2 = new Employee();
		e2.setName("e2");
		
		e1.setDept(dept);
		e2.setDept(dept);
		
		dept.getEmps().add(e1);
		dept.getEmps().add(e2);
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(dept);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}

}	
