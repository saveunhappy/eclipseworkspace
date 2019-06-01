package com.mypack.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory = null;
	static {
		try {
			//创建SqlSessionFactory对象
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//返回一个SqlSession对象
	public static SqlSession getSession() {
		return factory.openSession();
	}
	public static <T>T getMapper(Class<T> mapperClass){
		return getSession().getMapper(mapperClass);
	}
}
