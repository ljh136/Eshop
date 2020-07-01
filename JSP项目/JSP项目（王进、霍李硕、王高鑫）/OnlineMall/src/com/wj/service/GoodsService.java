package com.wj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wj.bean.Goods;
import com.wj.dao.DBCon;

public class GoodsService {
	//查询商品表中的所有数据
		public static List queryGoods(){
			Connection con =null;
			ResultSet rs = null;
			PreparedStatement pt = null;
			List list= new ArrayList();
			con = DBCon.getConnection();
			try {
				pt =  con.prepareStatement("select * from goods");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					Goods good = new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
							rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
					list.add(good);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBCon.closeAll(con, pt,null, rs);
			}
			return list;
		}
		
		
		
		//根据关键字搜索商品
		public static List<Goods> query(String keyword){
			Connection con =null;
			ResultSet rs = null;
			PreparedStatement pt = null;
			List<Goods> list= new ArrayList<Goods>();
			con = DBCon.getConnection();
			try {
				pt =  con.prepareStatement("SELECT * FROM goods where gname like '%"+keyword+"%'");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					Goods good = new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
							rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
					list.add(good);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBCon.closeAll(con, pt,null, rs);
			}
			return list;
		}
		
		
}
