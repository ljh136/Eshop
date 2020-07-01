package com.wj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wj.bean.User;
import com.wj.dao.DBCon;

public class PersonalService {
	
	//通过uid查询用户所有信息
	public static User GetUserByUid(int uid) {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		
		con = DBCon.getConnection();
		User user = null;
		try {
			pt =   con.prepareStatement("select * from user where uid = ?");
			pt.setInt(1, uid);
			rs =  pt.executeQuery();
			if(rs!=null&&rs.next()){
				user = new User(rs.getInt("uid"),rs.getString("ulogo"),rs.getString("uname"),rs.getString("utel"),
						rs.getString("upassword"), rs.getString("uemail"),rs.getString("address"),
						rs.getString("uquestion"),rs.getString("uanswer"),rs.getString("uregtime"),rs.getString("ustel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		return user;
	}
	
	
		
}
