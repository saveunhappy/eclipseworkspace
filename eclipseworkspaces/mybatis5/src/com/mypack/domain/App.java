package com.mypack.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.mapper.UserMapper;
import com.mypack.util.MybatisUtil;

public class App {
	@Test
	public void testGet() throws Exception {
		//
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = mapper.get(5L);
		session.close();
		System.out.println(u);
	}
	@Test
	public void testListAll() throws Exception {
		//
//		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> u = mapper.listAll();
		for (User u1 : u) {
			System.out.println(u1);
		}
	}

	@Test	 
	public void testUpdate() throws Exception {
		//
		//修改id为4的用户信息
		User u = new User();
		u.setName("阿飞");
		u.setSalary(new BigDecimal("900"));
		u.setId(9L);
		
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.update(u);
		//提交事物
		session.commit();
		session.close();
	}
	@Test	 
	public void testDelete() throws Exception {
		//
		//修改id为4的用户信息
		
		
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.delete(10L);
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
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.save(u);
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
