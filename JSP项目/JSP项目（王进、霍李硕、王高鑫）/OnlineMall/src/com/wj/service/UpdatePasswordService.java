package com.wj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wj.bean.User;
import com.wj.dao.DBCon;

public class UpdatePasswordService {

	
	//查询用户输入的密码和密保问题答案是否正确
	public static Boolean query(int uid,String upassword,String uanswer){
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		con = DBCon.getConnection();
		try {
			pt =con.prepareStatement("select * FROM user where uid=? and upassword=? and uanswer=?");
			pt.setInt(1, uid);
			pt.setString(2, upassword);
			pt.setString(3, uanswer);
			rs =  pt.executeQuery();
			if(rs!=null&&rs.next()){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		return false;
	}
	
	
	
	//修改用户密码。
	public static void newpassword(int uid,String upassword){
		Connection con = null;
		PreparedStatement pt = null;
		con = DBCon.getConnection();
		try {
			pt =con.prepareStatement("update user set upassword=? where uid=?");
			pt.setString(1, upassword);
			pt.setInt(2, uid);
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, null);
		}	
	}
	
}
