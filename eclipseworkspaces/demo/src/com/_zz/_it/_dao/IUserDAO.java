package com._zz._it._dao;

import com._zz._it._domain.User;

public interface IUserDAO {
	/**
	 * 根据账号去查询账号对应的用户对象
	 * username 登录账户(唯一)
	 * 
	 */
	User getUserByUsername(String name);
}
