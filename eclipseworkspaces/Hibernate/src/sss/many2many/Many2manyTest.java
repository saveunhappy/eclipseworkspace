package sss.many2many;

import static org.junit.Assert.*;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.util.HibernateUtil;

public class Many2manyTest {
	@Test
	public void testSave() throws Exception {
		Teacher t1 = new Teacher("t1");
		Teacher t2 = new Teacher("t2");
		
		Student s1 = new Student("s1");
		Student s2 = new Student("s2");
		//维护关系
		t1.getStus().add(s1);
		t1.getStus().add(s2);
		t2.getStus().add(s1);
		t2.getStus().add(s2);
		
		s1.getTeas().add(t1);
		s1.getTeas().add(t2);
		s2.getTeas().add(t1);
		s2.getTeas().add(t2);
		
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(t1);
		session.save(t2);
		session.save(s1);
		session.save(s2);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		Teacher t = (Teacher)session.get(Teacher.class, 1L);
		Set<Student> stus = t.getStus();
		System.out.println(t);
		System.out.println(stus);
		
		session.close();
	}
}
