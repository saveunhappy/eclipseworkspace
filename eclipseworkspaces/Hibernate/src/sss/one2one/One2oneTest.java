package sss.one2one;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.util.HibernateUtil;

public class One2oneTest {
	@Before
	public void testSave() throws Exception {
		QQNumber number = new QQNumber();
		number.setNumber("11");
		QQZone zone = new QQZone();
		zone.setTitle("title");
		number.setZone(zone);
		zone.setNumber(number);
		
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(number);
		session.save(zone);
		
		session.getTransaction().commit();
		session.close();
	}
	/**
	 * 从QQNumber拿QQZone
	 */
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		QQNumber number = (QQNumber)session.get(QQNumber.class, 1L);
		QQZone zone = number.getZone();
		System.out.println(number);
		System.out.println(zone);
		session.close();
	}
	/**
	 *从QQZone拿QQNumber 
	 */
	@Test
	public void testGet2() throws Exception {
		Session session = HibernateUtil.getSession();
		QQZone zone = (QQZone)session.get(QQZone.class, 1L);
		QQNumber number = zone.getNumber(); 
		System.out.println(zone);
		System.out.println(number);
		session.close();
	}
}
