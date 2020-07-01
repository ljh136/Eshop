package com.wj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wj.bean.User;
import com.wj.dao.DBCon;

public class UpdateUserService {
	
	
	//修改个人信息，并且设置密保问题
	public static void updateUser1(int uid,String ulogo,String uname,String uemail,String uquestion,String uanswer,String address,String ustel){
		Connection con = null;
		PreparedStatement pt = null;
		con = DBCon.getConnection();
		try {
			pt =con.prepareStatement("update user set ulogo=?,uname=?,uemail=?,uquestion=?,uanswer=?,address=?,ustel=? where uid=?");
			pt.setString(1, ulogo);
			pt.setString(2, uname);
			pt.setString(3, uemail);
			pt.setString(4, uquestion);
			pt.setString(5, uanswer);
			pt.setString(6, address);
			pt.setString(7, ustel);
			pt.setInt(8, uid);
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, null);
		}
		
	}
	
	
	
	//修改个人信息。
	public static void updateUser2(int uid,String ulogo,String uname,String uemail,String address,String ustel){
		Connection con = null;
		PreparedStatement pt = null;
		con = DBCon.getConnection();
		try {
			pt =con.prepareStatement("update user set ulogo=?,uname=?,uemail=?,address=?,ustel=? where uid=?");
			pt.setString(1, ulogo);
			pt.setString(2, uname);
			pt.setString(3, uemail);
			pt.setString(4, address);
			pt.setString(5, ustel);
			pt.setInt(6, uid);
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, null);
		}	
	}
}
