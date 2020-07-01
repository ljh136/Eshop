package com.hls.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hls.bean.leaveword;
import com.hls.dao.DaoDB;

public class DBDao {

	boolean flag = false;
	Connection con = null;
	PreparedStatement pt = null;
	Statement st = null;
	ResultSet rs = null;
	
	//登录验证
	public static boolean login(String admin_name,String admin_password) {
		
		
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/onlinemall";
			connection =DriverManager.getConnection(url,"root", "root");
			
			if(connection!= null){
				statement =  connection.createStatement();
				resultSet = statement.executeQuery("select * from admin where admin_name='"+admin_name+"' and admin_password='"+admin_password+"'");
				if(resultSet!=null){
					return true;
				}else{
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				resultSet.close();
				statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
		} 
		return false;
	}
	
	
	
	//添加购物车
	public static boolean insertShop(String uname,ArrayList<String> bookname){
		Connection con = null;
		PreparedStatement pst=null;
		String url = "jdbc:mysql://localhost:3306/scit?useUnicode=true&amp;characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "123456");
			
			String sql = "insert into shopcat(uname,shopname) values ('" + uname +"', '"+ bookname +"')";		
			
			pst = con.prepareStatement(sql); 
			int result = pst.executeUpdate(sql);
			
			if(result >0){
				return true;
			}
			pst.close();
			con.close();
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		return false;		
	}
	
	
	
	//读取购物车信息
	public static String readShop(String uname){
		Connection connection =null;
		Statement statement = null;
		ResultSet re = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/scit";
			connection =DriverManager.getConnection(url,"root", "123456");
			if(connection!= null){
				statement =  connection.createStatement();
				
				re = statement.executeQuery("select group_concat(shopname) from shopcat where uname='"+uname+"'");
				if(re!=null&&re.next()){
					return re.getString(1);
				}else{
					return "0";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				re.close();
				statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
		} 
		return "0";	
	}
	
	
	//注册
	public static boolean userAdd(String uname,String password){
		Boolean flag=false;
		Connection con = null;
		PreparedStatement pst=null;

		String url = "jdbc:mysql://localhost:3306/scit";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");
			
			String sql = "insert into user(uname, upassword) values ('" + uname +"', '"+password+"')";		
	
			pst = con.prepareStatement(sql);
			int result = pst.executeUpdate(sql);
			
			if(result >0){
				flag=true;
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return flag;
	}
	
	
	//查询所有商品
	public List queryGoods(){
		List list= new ArrayList();
		con = DBC.getConnection();
		
		try {
			pt =  con.prepareStatement("select * from goods");
			rs =  pt.executeQuery();
			while(rs!=null&&rs.next()){
				leaveword good = new leaveword(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
						rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
				list.add(good);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBC.closeAll(con, pt,st, rs);
		}
		return list;
	}



	//按商品编号查询对应的商品名称
	public List GidGname(String readShop) {
		List list = new ArrayList();
		int value1;
		con = DBC.getConnection();
		String[] value = readShop.split(", |\\[|\\],\\[|\\]");
		try {
			for(int i=1;i<value.length;i++){
			pt =  con.prepareStatement("select * from goods");
			rs =  pt.executeQuery();
			while(rs!=null&&rs.next()){
				 value1= Integer.valueOf(value[i]);
				if(value1==(rs.getInt(1))){
					list.add(rs.getString(2));
					}
				}	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBC.closeAll(con, pt,st, rs);
		}
		return list;
	}
	
	
	
	//通过商品编号查询商品
	public leaveword queryByGid(int gid) {
		//List list= new ArrayList();
		
 		con = DBC.getConnection();
		try {
			pt =  con.prepareStatement("select * from goods where gid=?");
			pt.setInt(1, gid);
			rs =  pt.executeQuery();
			while(rs!=null&&rs.next()){
				leaveword good = new leaveword(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
						rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
				return good;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBC.closeAll(con, pt,st, rs);
		}
		return null;
	}
}
