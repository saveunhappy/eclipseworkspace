package com.mypack.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.LoginVO;
import com.mypack.mapper.ClientMapper;
import com.mypack.util.MybatisUtil;

public class App {
	@Test
	public void testLogin1() throws Exception {
		LoginVO vo = new LoginVO("will","1111");
		SqlSession session = MybatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		Client client = clientMapper.login1(vo);
		session.close();
		System.out.println(client);
	}
	@Test
	public void testLogin2() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>(){
			{
				this.put("username", "will");
				this.put("password", "1111");
			}
		};
		LoginVO vo = new LoginVO("will","1111");
		SqlSession session = MybatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		Client client = clientMapper.login2(map);
		session.close();
		System.out.println(client);
	}
	@Test
	public void testLogin3() throws Exception {
		
		SqlSession session = MybatisUtil.getSession();
		ClientMapper clientMapper = session.getMapper(ClientMapper.class);
		Client client = clientMapper.login3("will","1111");
		session.close();
		System.out.println(client);
	}
	
	
	
	
}
