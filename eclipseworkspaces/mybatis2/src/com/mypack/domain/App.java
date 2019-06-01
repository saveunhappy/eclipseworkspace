package com.mypack.domain;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mypack.mapper.UserMapper;
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
	public void testListAll() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		//以前：
		//List<User> list = session.selectList("com.mypack.domain.UserMapper.listAll");
		//Mapper接口
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> all = userMapper.listAll();
		for (User user : all) {
			System.out.println(user);
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
	@Test	 
	public void testGetCount() throws Exception {
	
		//查询t_user表中的结果总数
		SqlSession session = MybatisUtil.getSession();
		int rows = session.selectOne("com.mypack.domain.UserMapper.queryForCount");
		
		session.close();
		System.out.println(rows);
	}
	@Test	 
	public void testGetMap() throws Exception {
		
		//查询t_user表中的结果总数
		SqlSession session = MybatisUtil.getSession();
		List<Map<String,Object>> us = session.selectList("com.mypack.domain.UserMapper.queryForMap",1L);
		
		session.close();
		for (Map<String, Object> map : us) {
			System.out.println(map);
		}
	}
	
	
	
	
}
