package com._zz._shoppingcart;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class CartItem {
	private String id;//唯一的ID
	private String name;//商品的名字
	private BigDecimal price;//商品的价格
	private Integer num;//商品的数量
	public CartItem(String id, String name, BigDecimal price, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
}
