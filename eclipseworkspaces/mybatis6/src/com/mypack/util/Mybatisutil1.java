package com.mypack.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatisutil1 {
	private static SqlSessionFactory factory = null;
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public SqlSession getSession() {
		return factory.openSession();
	}
	
}
