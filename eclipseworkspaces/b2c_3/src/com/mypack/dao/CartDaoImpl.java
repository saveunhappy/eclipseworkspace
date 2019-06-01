package com.mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mypack.entity.Goods;
import com.mypack.entity.Item;
import com.mypack.entity.User;

public class CartDaoImpl extends BaseDao implements CartDaoIF {

	@Override
	public boolean addCart(Item item) {
		
		boolean flag=false;
		String sql="insert into cart(goodsId,nums,username) values(?,?,?)";//? 占位符
		
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql); 
			
			
			pstmt.setInt(1, item.getGood().getGoodsId());
			pstmt.setInt(2, item.getNums());
			pstmt.setString(3, item.getUser().getUsername());
			
			// ResultSet executeQuery()  执行查询  int executeUpdate() 执行增删改
			int row=pstmt.executeUpdate();
			if(row>0){
				System.out.println("添加了"+row+"行");
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//增删改没有结果集对象
			close(pstmt, conn);
		}
		return flag;
		
	}

	@Override
	public List<Item> queryAllCart(User user) {


		/*String sql="select c.itemId,c.goodsId,c.nums,"
				+ " g.goodsName,g.price,g.kucun,g.spec,"
				+ "g.imgPath,g.bak from cart c,goods g "
				+ "where c.goodsId=g.goodsId "
				+ "and c.username=?";//? 占位符
*/		
		String sql="select c.itemId,c.goodsId, sum(c.nums), g.goodsName,g.price,g.kucun,g.spec,g.imgPath,g.bak from cart c,goods g where c.goodsId=g.goodsId and c.username=? group by c.goodsId";
		List<Item> itemLst=new ArrayList<Item>();
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				int itemId=rs.getInt(1);
				int goodsId=rs.getInt(2);
				int nums=rs.getInt(3);//购买数量
				String goodsName=rs.getString(4);
				double price=rs.getDouble(5);
				int kucun=rs.getInt(6);
				String spec=rs.getString(7);
				String imgPath=rs.getString(8);
				String bak=rs.getString(9);
				
				
				Goods good=new Goods(goodsId, goodsName, price, kucun, spec, imgPath, bak);
				
				Item item=new Item(itemId, good, nums, user);
				itemLst.add(item);
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			close(rs, pstmt, conn);
		}
		return itemLst;
	}


	@Override
	public boolean updateCart(Item item) {
		boolean flag=false;
		String sql="update cart set nums=? where itemId=?";
		Connection conn=getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, item.getNums());
			pstmt.setInt(2, item.getItemId());
			int row=pstmt.executeUpdate();
			if(row>0){
				System.out.println("修改了"+row+"行");
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt, conn);
		}
		return flag;
	}

	@Override
	public boolean deleteCartById(int goodsId) {
		boolean flag=false;
		String sql="delete from cart where goodsId=?";
		Connection conn=getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, goodsId);
			int row=pstmt.executeUpdate();
			if(row>0){
				System.out.println("删除了"+row+"行");
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt, conn);
		}
		return flag;
	}

}
