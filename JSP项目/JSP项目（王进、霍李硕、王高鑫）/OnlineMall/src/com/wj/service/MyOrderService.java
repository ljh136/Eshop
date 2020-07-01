package com.wj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wj.bean.Order;
import com.wj.dao.DBCon;

public class MyOrderService {

	//根据uid查询对应订单表里的内容
	public static List<Order> queryOrder(int uid){
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		List<Order> list= new ArrayList<Order>();
		con = DBCon.getConnection();
		
		try {
			pt =  con.prepareStatement("select * from `order` where uid='"+uid+"'");
			rs =  pt.executeQuery();
			while(rs!=null&&rs.next()){
				Order order = new Order(rs.getInt("oid"),rs.getInt("uid"),rs.getInt("gid"),rs.getInt("otype"),rs.getInt("bnum"),rs.getString("bdate"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		return list;
	}
		
	
	
	//删除订单
	public static void deleteOrder(int oid) {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		con = DBCon.getConnection();
		con = DBCon.getConnection();
		try {
			   		pt =con.prepareStatement("delete from `order` where oid=?");
					pt.setInt(1, oid);
					pt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		
	}
	
}
