package com.hls.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.hls.bean.Page;
import com.hls.bean.leaveword;
import com.hls.dao.DBC;
import com.mysql.jdbc.PreparedStatement;

public class Getgoodservice {

	public static ArrayList<leaveword>queryLeaveWords(Page page){
		ArrayList<leaveword> list = new ArrayList<leaveword>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		con = DBC.getConnection();
		String sql = "select * from goods limit ?,?";
		try {
			st = (PreparedStatement)con.prepareCall(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
	}
	public static int getCount(){
		int count=0;
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		con = DBC.getConnection();
		String sql = "select count(*) from goods";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs!=null&&rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
		
	}
}
