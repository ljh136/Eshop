package com.hls.service;

import java.sql.Connection;

import com.hls.bean.leaveword;
import com.hls.dao.DBC;
import com.mysql.jdbc.PreparedStatement;

public class Insertservice {

	//…Ã∆∑≤Â»Î
	public static void insertleave(leaveword lea){
		Connection con = null;
		PreparedStatement st = null;
		con = DBC.getConnection();
		String sql = "insert into leaveword(gid,gname,gprice,gpic,gintroduce,gtypeid,gnum,gdate)"
				+"value(?,?,?,?,?,?,?,?)";
		try {
			st = (PreparedStatement) con.prepareStatement(sql);
			st.setInt(1, lea.getGid());
			st.setString(2, lea.getGname());
			st.setString(3, lea.getGprice());
			st.setString(4, lea.getGpic());
			st.setString(5, lea.getGintroduce());
			st.setInt(6, lea.getGtypeid());
			st.setInt(7, lea.getGnum());
			st.setString(8, lea.getGdate());
			st.execute();
			DBC.closeAll(con, null, st, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
