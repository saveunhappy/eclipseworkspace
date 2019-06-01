package com.mypack.domain;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.mapper.TeacherMapper;
import com.mypack.util.MybatisUtil;

public class App {
	@Test
	public void test1() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.get(1L);
		session.close();
		System.out.println("----------------------------");
		session = MybatisUtil.getSession();
		mapper = session.getMapper(TeacherMapper.class);
		teacher = mapper.get(1L);
		session.close();
	}

}
