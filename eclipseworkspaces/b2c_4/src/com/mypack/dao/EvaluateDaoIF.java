package com.mypack.dao;

import java.util.List;

import com.mypack.entity.Evaluate;


public interface EvaluateDaoIF {

	
	public boolean addEvaluate(Evaluate evaluate);
	//一个商品对应对个评价内容
	public List<Evaluate> queryAllEvaluateByGoodsId(int goodsId);

	
}