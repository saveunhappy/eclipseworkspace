package com.mypack.dao;

import java.util.List;

import com.mypack.entity.Address;
import com.mypack.entity.Item;
import com.mypack.entity.User;

public interface AddressDaoIF {
	
	
	public boolean addAddress(Address addr);	//添加到购物车
	public List<Address> queryAllAddr(User user);//用户只能查询该用户名下的地址信息
	public boolean updateAddress(Address addr);
	public boolean deleteAddressById(int addressId);
	public Address queryAddressById(int addressId);

}
