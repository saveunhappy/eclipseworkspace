package com.mypack.dao;

import java.util.List;

import com.mypack.entity.Item;
import com.mypack.entity.User;

public interface CartDaoIF {
	
	
	public boolean addCart(Item item);	//添加到购物车
	public List<Item> queryAllCart(User user);//查询购物车信息 用户只能查询该用户名下的商品信息
	public boolean updateCart(Item item);
	public boolean deleteCartById(int goodsId);

}
