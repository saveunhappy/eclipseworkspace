package com.mypack.dao;

import com.mypack.entity.User;

public interface UserDaoIF {
	
	public User queryUserByUsername(User user);//查询单个 登录
	public boolean addUser(User user) ;//添加单个 注册

}
