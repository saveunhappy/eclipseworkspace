package com.mypack.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mypack.LoginVO;
import com.mypack.domain.Client;


public interface ClientMapper {
	//方式一：把多个参数封装成JavaBean
	Client login1(LoginVO vo);
	//方式二：使用Map对象来封装多个参数
	Client login2(Map<String, Object> map);
	Client login3(@Param("username")String username, @Param("password")String password);

}
