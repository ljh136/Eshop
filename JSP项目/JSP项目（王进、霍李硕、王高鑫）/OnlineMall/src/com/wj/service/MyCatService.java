package com.wj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wj.bean.Buycat;
import com.wj.bean.Goods;
import com.wj.dao.DBCon;

public class MyCatService {

	//根据uid查询对应购物车表内容
	public static List<Buycat> queryBuycat(int uid){
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		List<Buycat> list= new ArrayList<Buycat>();
		con = DBCon.getConnection();
		
		try {
			pt =  con.prepareStatement("select * from buycar where uid='"+uid+"'");
			rs =  pt.executeQuery();
			while(rs!=null&&rs.next()){
				Buycat buycat = new Buycat(rs.getInt("bid"),rs.getInt("uid"),rs.getInt("gid"),rs.getInt("bnum"),rs.getString("bdate"));
				list.add(buycat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		return list;
	}
	
	
	
	//通过gid查询数据
	public static Goods getGoodBygid(int gid) {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		con = DBCon.getConnection();
		Goods good = null;
		try {
			pt =   con.prepareStatement("select * from goods where gid = ?");
			pt.setInt(1, gid);
			rs =  pt.executeQuery();
			if(rs!=null&&rs.next()){
				good = new  Goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
						rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		return good;
	}


	
	//删除购物车商品
	public static void deleteCat(int bid) {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		con = DBCon.getConnection();
		con = DBCon.getConnection();
		try {
			   		pt =con.prepareStatement("delete from buycar where bid=?");
					pt.setInt(1, bid);
					pt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		
	}
	
	
	
}
