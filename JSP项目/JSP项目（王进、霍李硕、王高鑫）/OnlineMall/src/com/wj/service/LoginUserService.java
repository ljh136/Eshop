package com.wj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wj.bean.User;
import com.wj.dao.DBCon;

public class LoginUserService {
	
	//登录验证
		public static int loginuser(String uname,String upassword) {
			Connection con =null;
			Statement st = null;
			ResultSet rs = null;
			try {
				con = DBCon.getConnection();
					st =  con.createStatement();
					rs = st.executeQuery("select * from user where (uname='"+uname+"' or utel='"+uname+"') and upassword='"+upassword+"'");
					if(rs!=null&&rs.next()){
						int uid = rs.getInt("uid");
						return uid;
					}else{
						return 0;
					}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		
		//通过uid返回uname
		public static String uidtouname(int uid) {
			Connection con =null;
			Statement st = null;
			ResultSet rs = null;
			try {
				con = DBCon.getConnection();
					st =  con.createStatement();
					rs = st.executeQuery("select uname from user where uid='"+uid+"'");
					if(rs!=null&&rs.next()){
						String uname = rs.getString("uname");
						return uname;
					}else{
						return null;
					}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}


		
		
}
