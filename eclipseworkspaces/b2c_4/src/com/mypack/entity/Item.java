package com.mypack.entity;

public class Item {
	/**
	 * 购物车中商品条目信息类
	 */

	int itemId;
	Goods good;//商品信息
	int nums;//购买数量
	User user;//用户信息
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Goods good, int nums, User user) {
		super();
		this.good = good;
		this.nums = nums;
		this.user = user;
	}
	
	public Item(int itemId, Goods good, int nums, User user) {
		super();
		this.itemId = itemId;
		this.good = good;
		this.nums = nums;
		this.user = user;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
