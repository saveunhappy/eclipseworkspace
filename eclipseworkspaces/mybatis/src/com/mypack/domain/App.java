package com.mypack.domain;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mypack.util.MybatisUtil;

public class App {
	@Test
	public void testName() throws Exception {
		//
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session  = factory.openSession();
		User u = session.selectOne("com.mypack.domain.UserMapper.get",1L);
		session.close();
		System.out.println(u);
	}
	@Test
	public void test1() throws Exception {
		//
//		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = null;
		try {
			
			 session  = MybatisUtil.getSession();
			List<User> list = session.selectList("com.mypack.domain.UserMapper.listAll");
			for (User user : list) {
				System.out.println(user);
			}
		}finally {
		session.close();
		}
		
	}
	@Test
	public void test2() throws Exception {
		//
//		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		try (
				SqlSession session = MybatisUtil.getSession();
				){
			
			List<User> list = session.selectList("com.mypack.domain.UserMapper.listAll");
			for (User user : list) {
				System.out.println(user);
			}
		}
		
	}
	@Test	 
	public void testUpdate() throws Exception {
		//
		//修改id为4的用户信息
		User u = new User();
		u.setName("叶孤城");
		u.setSalary(new BigDecimal("900"));
		u.setId(4L);
		
		SqlSession session = MybatisUtil.getSession();
		session.update("com.mypack.domain.UserMapper.update", u);
		//提交事物
		session.commit();
		session.close();
	}
	@Test	 
	public void testDelete() throws Exception {
		//
		//修改id为4的用户信息
		User u = new User();
		
		u.setId(4L);
		
		SqlSession session = MybatisUtil.getSession();
		session.update("com.mypack.domain.UserMapper.delete", u);
		//提交事物
		session.commit();
		session.close();
	}
	@Test	 
	public void testSave() throws Exception {
		//
		//修改id为4的用户信息
		User u = new User();
		u.setName("楚留香");
		u.setSalary(new BigDecimal("800"));
		System.out.println(u);
		
		SqlSession session = MybatisUtil.getSession();
		session.update("com.mypack.domain.UserMapper.save", u);
		//提交事物
		session.commit();
		session.close();
		System.out.println(u);
	}
}
