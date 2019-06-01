package com.api;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.mypack.domain.User;
/**
 * Configuration对象：
 * hibernate的配置对象，只要用于解析hibernate配置文件和持久化映射文件中的信息
 * 最重要的功能，是用来创建SeesionFactory对象,(配置文件都要存放在CLASSPATH根路径)
 * 
 *
 */
@SuppressWarnings("all")
public class ConfigurationTest {
	
	@Test
	public void testName() throws Exception {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		System.out.println(sf.openSession().get(User.class, 3L));
	}
}
