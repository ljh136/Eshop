package com.wj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBCon {

	//连接数据
	public static Connection getConnection(){
		try {
			//加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/onlinemall";
			//驱动管理程序  建立连接
			Connection conn= DriverManager.getConnection(url, "root", "123456");
			if(conn!=null){
				//连接成功
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//关闭资源
	public static void closeAll(Connection con,PreparedStatement pt, Statement st,ResultSet rs){
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
			e.printStackTrace();
		}
	}
}
