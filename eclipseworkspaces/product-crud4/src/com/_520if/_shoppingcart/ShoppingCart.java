package com._520if._shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;

import lombok.Data;

//购物车对象应该包含商品对象
@Data
public class ShoppingCart {
	// 购物车中的多个商品对象
	private List<CartItem> items = new ArrayList<>();

	// 购物车总价
	// private BigDecimal totalPrice;
	// 把商品添加进购物车
	public void save(CartItem newItem) {
		for (CartItem item : items) {
			if (item.getId().equals(newItem.getId())) {
				item.setNum(item.getNum() + newItem.getNum());
				return;
			}
			
		}
		items.add(newItem);
	}

	public List<CartItem> getItems() {
		return items;
	}
	public void delete(String id) {
		Iterator<CartItem> it = items.iterator();
		while(it.hasNext()) {
			CartItem item = it.next();
			if(item.getId().equals(id)) {
				it.remove();
				break;
			}
		}
	}

	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (CartItem item : items) {
			totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(item.getNum())));

		}
		return totalPrice;
	}
}
