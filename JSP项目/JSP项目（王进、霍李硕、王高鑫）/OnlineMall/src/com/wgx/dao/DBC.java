package com.wgx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBC{
	//连接数据库
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/onlinemall";
			Connection con = DriverManager.getConnection(url, "root", "123456");
			if(con!=null){
				return con;
			}
		} catch (Exception e) {}
		return null;
	}
	//关闭数据库
	public static void closeAll(Connection con,PreparedStatement pt,Statement st,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(pt!=null){
				pt.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

