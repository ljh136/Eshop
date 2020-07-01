package com.wj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.wj.bean.User;
import com.wj.dao.DBCon;

public class AddUserService {
	
	//添加用户方法
	public static void adduser(User user){
		
			Connection con =null;
			PreparedStatement st = null;
			con = DBCon.getConnection();
			String sql = "insert into user (ulogo,uname,utel,upassword,uemail,uregtime) values(?,?,?,?,?,?)";
			try {
				st = con.prepareStatement(sql);
				st.setString(1, user.getUlogo());
				st.setString(2, user.getUname());
				st.setString(3, user.getUtel());
				st.setString(4, user.getUpassword());
				st.setString(5, user.getUemail());
				st.setString(6, user.getUregtime());
				
				st.execute();
				DBCon.closeAll(con, null, st, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
}
