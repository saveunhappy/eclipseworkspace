package com.mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mypack.entity.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDaoIF {

	@Override
	public Goods queryGoodsById(int goodsId) {
		String sql="select * from goods where goodsId=?";//? 占位符
		
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Goods good=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				int id=rs.getInt(1);
				String goodsName=rs.getString(2);
				double price=rs.getDouble(3);
				int kucun=rs.getInt(4);
				String spec=rs.getString(5);
				String imgPath=rs.getString(6);
				String bak=rs.getString(7);
				good=new Goods(id, goodsName, price, kucun, spec, imgPath, bak);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			close(rs, pstmt, conn);
		}
		return good;
	}

	@Override
	public List<Goods> queryAllGoods() {
		
		String sql="select * from goods";//? 占位符
		
		List<Goods> goodsLst=new ArrayList<Goods>();
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				int id=rs.getInt(1);
				String goodsName=rs.getString(2);
				double price=rs.getDouble(3);
				int kucun=rs.getInt(4);
				String spec=rs.getString(5);
				String imgPath=rs.getString(6);
				String bak=rs.getString(7);
				Goods good=new Goods(id, goodsName, price, kucun, spec, imgPath, bak);
				goodsLst.add(good);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			close(rs, pstmt, conn);
		}
		return goodsLst;
	}

	

}
