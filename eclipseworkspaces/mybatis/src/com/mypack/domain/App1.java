package com.mypack.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App1 {
	@Test
	public void test1() throws Exception {
		//1.从classpath根路径去加载mybatis全局配置文件:mybatis-config.xml
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//构建SQLSessionFactory对象，好比是DataSource
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//构建SQLsession对象，好比是connection
		SqlSession session = factory.openSession();
		//具体的操作(增删改查)
		User u  = session.selectOne("com.mypack.domain.UserMapper.get", 2L);
		//关闭SQLsession
		session.close();
		System.out.println(u);
	}
	@Test
	public void test2() throws Exception {
		//1.从classpath根路径去加载mybatis全局配置文件:mybatis-config.xml
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//构建SQLSessionFactory对象，好比是DataSource
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//构建SQLsession对象，好比是connection
		SqlSession session = factory.openSession();
		//具体的操作(增删改查)
		List<User> u  = session.selectList("com.mypack.domain.UserMapper.listAll");
		//关闭SQLsession
		session.close();
		for (User user : u) {
			System.out.println(user);
		}
	}
}
