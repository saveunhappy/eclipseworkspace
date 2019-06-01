package com.mypack.dao;

import java.util.List;

import com.mypack.entity.Goods;

public interface GoodsDaoIF {
	
	public Goods queryGoodsById(int goodsId);//查询单个 
	public List<Goods> queryAllGoods() ;//查询所有

}
