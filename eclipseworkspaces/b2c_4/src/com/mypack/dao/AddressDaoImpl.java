package com.mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mypack.entity.Address;
import com.mypack.entity.Goods;
import com.mypack.entity.Item;
import com.mypack.entity.User;

public class AddressDaoImpl extends BaseDao implements AddressDaoIF {

	@Override
	public boolean addAddress(Address addr) {
		
		boolean flag=false;
		String sql="insert into address(receiver,region,detailAddr,tel,username) values(?,?,?,?,?)";//? 占位符
		
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql); 
			
			
			pstmt.setString(1, addr.getReceiver());
			pstmt.setString(2, addr.getRegion());
			pstmt.setString(3, addr.getDetailAddr());
			pstmt.setString(4, addr.getTel());
			pstmt.setString(5, addr.getUser().getUsername());
			
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
	public List<Address> queryAllAddr(User user) {


		
		String sql="select * from address where username=?";
		List<Address> addrLst=new ArrayList<Address>();
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				int addressId=rs.getInt(1);
				String receiver=rs.getString(2);
				String region=rs.getString(3);
				String detailAddr=rs.getString(4);
				String tel=rs.getString(5);
				String username=rs.getString(6);
				Address addr=new Address(addressId, receiver, region, detailAddr, tel, user);
				addrLst.add(addr);
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			close(rs, pstmt, conn);
		}
		return addrLst;
	}


	@Override
	public boolean updateAddress(Address addr){
		boolean flag=false;
		String sql="update address set receiver=?,region=?,detailAddr=?,tel=? where addressId=?";
		Connection conn=getConn();
		PreparedStatement pstmt=null;
		try {
			
			pstmt.setString(1, addr.getReceiver());
			pstmt.setString(2, addr.getRegion());
			pstmt.setString(3, addr.getDetailAddr());
			pstmt.setString(4, addr.getTel());
			pstmt.setInt(5, addr.getAddressId());
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
	public boolean deleteAddressById(int addressId) {
		boolean flag=false;
		String sql="delete from address where addressId=?";
		Connection conn=getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, addressId);
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

	@Override
	public Address queryAddressById(int addressId) {

		String sql="select * from address where addressId=?";
		
		
		Connection conn=getConn();
		//sql语句被预处理
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Address addr=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addressId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				int addrId=rs.getInt(1);
				String receiver=rs.getString(2);
				String region=rs.getString(3);
				String detailAddr=rs.getString(4);
				String tel=rs.getString(5);
				String username=rs.getString(6);
				addr=new Address(addressId, receiver, region, detailAddr, tel);
				
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			close(rs, pstmt, conn);
		}
		return addr;
	}

}
