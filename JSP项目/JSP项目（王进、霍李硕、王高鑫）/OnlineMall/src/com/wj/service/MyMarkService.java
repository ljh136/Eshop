package com.wj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wj.bean.GoodsMark;
import com.wj.bean.Order;
import com.wj.dao.DBCon;

public class MyMarkService {

	//根据uid查询对应商品评论表里的内容
	public static List<GoodsMark> queryMark(int uid){
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		List<GoodsMark> list= new ArrayList<GoodsMark>();
		con = DBCon.getConnection();
		
		try {
			pt =  con.prepareStatement("select * from goodsmark where uid='"+uid+"'");
			rs =  pt.executeQuery();
			while(rs!=null&&rs.next()){
				GoodsMark goodsMark = new GoodsMark(rs.getInt("mid"),rs.getInt("gid"),rs.getInt("uid"),rs.getString("gmark"),rs.getString("gdate"));
				list.add(goodsMark);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeAll(con, pt,null, rs);
		}
		return list;
	}
		
		
	
}
