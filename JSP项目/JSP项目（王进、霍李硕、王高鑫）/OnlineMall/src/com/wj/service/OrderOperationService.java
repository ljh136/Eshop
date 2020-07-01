package com.wj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wj.dao.DBCon;

public class OrderOperationService {
	//订单退货。
	public static void tuihuo(int oid){
		Connection con = null;
		PreparedStatement pt = null;
		con = DBCon.getConnection();
		try {
			pt =con.prepareStatement("update `order` set otype=? where oid=?");
			pt.setInt(1, 5);
			pt.setInt(2, oid);
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, null);
		}	
	}

	
	//确认收货
	public static void confirm(int oid) {
		Connection con = null;
		PreparedStatement pt = null;
		con = DBCon.getConnection();
		try {
			pt =con.prepareStatement("update `order` set otype=? where oid=?");
			pt.setInt(1, 3);
			pt.setInt(2, oid);
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, null);
		}
		
	}
	
	
}
