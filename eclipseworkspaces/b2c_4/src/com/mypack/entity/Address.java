package com.mypack.entity;

public class Address {
	int addressId;
	String receiver;//收货人
	String region;//区域
	String detailAddr;//详细地址
	String tel;
	User user;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String receiver, String region,
			String detailAddr, String tel, User user) {
		super();
		this.addressId = addressId;
		this.receiver = receiver;
		this.region = region;
		this.detailAddr = detailAddr;
		this.tel = tel;
		this.user = user;
	}
	
	public Address(int addressId, String receiver, String region,
			String detailAddr, String tel) {
		super();
		this.addressId = addressId;
		this.receiver = receiver;
		this.region = region;
		this.detailAddr = detailAddr;
		this.tel = tel;
	}

	public Address(String receiver, String region, String detailAddr,
			String tel, User user) {
		super();
		this.receiver = receiver;
		this.region = region;
		this.detailAddr = detailAddr;
		this.tel = tel;
		this.user = user;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
