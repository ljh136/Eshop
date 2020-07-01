package com.wgx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wgx.bean.Buycat;
import com.wgx.bean.GoodsMark;
import com.wgx.bean.Order;
import com.wgx.bean.User;
import com.wgx.bean.goods;
public class DaoDB {
	boolean flag = false;
	Connection con = null;
	PreparedStatement pt = null;
	Statement st = null;
	ResultSet rs = null;
	
	//查询商品表中的所有数据
		public List queryGoods(){
			List list= new ArrayList();
			con = DBC.getConnection();
			
			try {
				pt =  con.prepareStatement("select * from goods");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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
		public List queryclothes(){
			List list= new ArrayList();
			con = DBC.getConnection();
			
			try {
				pt =  con.prepareStatement("select * from goods where gtypeid='1'");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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
		public List querydeliciousfood(){
			List list= new ArrayList();
			con = DBC.getConnection();
			
			try {
				pt =  con.prepareStatement("select * from goods where gtypeid='2'");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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
		public List querylifeneeds(){
			List list= new ArrayList();
			con = DBC.getConnection();
			
			try {
				pt =  con.prepareStatement("select * from goods where gtypeid='3'");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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
		public List querysmarttoys(){
			List list= new ArrayList();
			con = DBC.getConnection();
			
			try {
				pt =  con.prepareStatement("select * from goods where gtypeid='4'");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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
		
		
		
		//通过id查询数据
		public goods getGoodByid(int gid) {
			con = DBC.getConnection();
			goods good = null;
			try {
				pt =   con.prepareStatement("select * from goods where gid = ?");
				pt.setInt(1, gid);
				rs =  pt.executeQuery();
				if(rs!=null&&rs.next()){
					System.out.println("sss");
					good = new  goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
							rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
			return good;
		}

		
		
		//修改商品
		public boolean updateGood(int gid, String gname,String gpic, String gprice, int gnum, String gintroduce,
				String gdate,int gtypeid) {
			con = DBC.getConnection();
			try {
				pt =con.prepareStatement("update goods set gname=?,gpic=?,gprice=?,gnum=?,gintroduce=?,gdate=?,gtypeid=? where gid=?");
				pt.setString(1, gname);
				pt.setString(2, gpic);
				pt.setString(3, gprice);
				pt.setInt(4, gnum);
				pt.setString(5, gintroduce);
				pt.setString(6, gdate);
				pt.setInt(7, gtypeid);
				pt.setInt(8, gid);
				int re =pt.executeUpdate();
				if(re>0) 
					flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
			return flag;
		}


		
		//添加商品
		public boolean AddShop(String gname,List list,String gprice, int gnum, String gintroduce,String gdate,int gtypeid) {
			con = DBC.getConnection();
			try {
				/*pt =con.prepareStatement("insert into goods(gname,pic,price,num,introduce,date) values (?,?,?,?,?,?) ");
				pt.setString(1, gname);
				pt.setArray(2, arr);
				pt.setFloat(3, price);
				pt.setInt(4, num);
				pt.setString(5, introduce);
				pt.setString(6, date);*/
				pt =con.prepareStatement("insert into goods(gname,gpic,gprice,gnum,gintroduce,gdate,gtypeid) values"
						+ " ('"+gname+"','"+list+"','"+gprice+"','"+gnum+"','"+gintroduce+"','"+gdate+"','"+gtypeid+"')");
				int re=pt.executeUpdate(); 
				if(re>0){
					flag=true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
			return flag;
		}


		
		//删除商品	
		public void deleteShop(int gid) {
			con = DBC.getConnection();
			try {
				pt =  con.prepareStatement("select * from goods");
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					if(gid==rs.getInt(1)){	
				   		pt =con.prepareStatement("delete from goods where gid=?");
						pt.setInt(1, gid);
						pt.executeUpdate(); 
				   	}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
		}


		
		//通过商品编号查询商品
		public List queryByGid(int gid) {
			List list= new ArrayList();
			con = DBC.getConnection();
			try {
				pt =  con.prepareStatement("select * from goods where gid=?");
				pt.setInt(1, gid);
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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


		
		//通过商品名称查询商品
		public List queryByGname(String gname) {
			List list= new ArrayList();
			con = DBC.getConnection();
			try {
				pt =  con.prepareStatement("select * from goods where gname=?");
				pt.setString(1, gname);
				rs =  pt.executeQuery();
				while(rs!=null&&rs.next()){
					goods good = new goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
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


//添加购物车
public boolean insertbuycargood(int uid,int gid,int bnum,String bdate) {
	con = DBC.getConnection();
	try {
		pt =con.prepareStatement("insert into buycar(uid,gid,bnum,bdate) values (?,?,?,?) ");
		pt.setInt(1, uid);
		pt.setInt(2, gid);
		pt.setInt(3, bnum);
		pt.setString(4, bdate);
		/*pt =con.prepareStatement("insert into goods(gname,gpic,gprice,gnum,gintroduce,gdate,gtypeid) values"
				+ " ('"+gname+"','"+list+"','"+gprice+"','"+gnum+"','"+gintroduce+"','"+gdate+"','"+gtypeid+"')");*/
		int re=pt.executeUpdate(); 
		if(re>0){
			flag=true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBC.closeAll(con, pt,st, rs);
	}
	return flag;
}
//通过用户id获取购物车信息
public Buycat querybuycarBybid(int bid) {
	con = DBC.getConnection();
	try {
		pt =  con.prepareStatement("select * from buycar where bid=?");
		pt.setInt(1, bid);
		rs =  pt.executeQuery();
		while(rs!=null&&rs.next()){
			Buycat buycar = new Buycat(rs.getInt("bid"),rs.getInt("uid"),rs.getInt("gid"),
					rs.getInt("bnum"),rs.getString("bdate"));
			return buycar;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBC.closeAll(con, pt,st, rs);
	}
	return null;
}

		//通过货物id获取评价信息
				public List querymarkByGid(int gid) {
					List list= new ArrayList();
					con = DBC.getConnection();
					try {
						pt =  con.prepareStatement("select * from goodsmark where gid=?");
						pt.setInt(1, gid);
						rs =  pt.executeQuery();
						while(rs!=null&&rs.next()){
							GoodsMark goodmark = new GoodsMark(rs.getInt("mid"),rs.getInt("gid"),rs.getInt("uid"),
									rs.getString("gmark"),rs.getString("gdate"));
							list.add(goodmark);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return list;
				}
				//通过用户id获取用户信息
				public User getUserByid(int uid) {
					con = DBC.getConnection();
					User user = null;
					try {
						pt =   con.prepareStatement("select * from user where uid = ?");
						pt.setInt(1, uid);
						rs =  pt.executeQuery();
						if(rs!=null&&rs.next()){
							user = new  User(rs.getInt("uid"),rs.getString("ulogo"),rs.getString("uname"),
									rs.getString("utel"),rs.getString("upassword"),rs.getString("uemail"), rs.getString("address"),rs.getString("uquestion"),rs.getString("uanswer"),rs.getString("uregtime"),rs.getString("ustel"));
							return user;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return null;
				}
				public boolean insertgoodmark(int uid,int gid,String gmark,String gdate) {
					con = DBC.getConnection();
					try {
						pt =con.prepareStatement("insert into goodsmark(uid,gid,gmark,gdate) values (?,?,?,?) ");
						pt.setInt(1, uid);
						pt.setInt(2, gid);
						pt.setString(3, gmark);
						pt.setString(4, gdate);
						/*pt =con.prepareStatement("insert into goods(gname,gpic,gprice,gnum,gintroduce,gdate,gtypeid) values"
								+ " ('"+gname+"','"+list+"','"+gprice+"','"+gnum+"','"+gintroduce+"','"+gdate+"','"+gtypeid+"')");*/
						int re=pt.executeUpdate(); 
						if(re>0){
							flag=true;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return flag;
				}
				//通过订单id获取购物车信息
				public Order queryorderByid(int oid) {
					con = DBC.getConnection();
					try {
						pt =  con.prepareStatement("select * from `order` where oid=?");
						pt.setInt(1, oid);
						rs =  pt.executeQuery();
						while(rs!=null&&rs.next()){
							Order order = new Order(rs.getInt("oid"),rs.getInt("uid"),rs.getInt("gid"),
									rs.getInt("otype"),rs.getInt("bnum"),rs.getString("bdate"));
							return order;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return null;
				}
				
				
				
				public boolean insertorder(int uid,int gid,int otype,int bnum,String bdate) {
					con = DBC.getConnection();
					try {
						pt =con.prepareStatement("insert into `order`(uid,gid,otype,bnum,bdate) values (?,?,?,?,?)");
						pt.setInt(1, uid);
						pt.setInt(2, gid);
						pt.setInt(3, otype);
						pt.setInt(4, bnum);
						pt.setString(5, bdate);
						/*pt =con.prepareStatement("insert into goods(gname,gpic,gprice,gnum,gintroduce,gdate,gtypeid) values"
								+ " ('"+gname+"','"+list+"','"+gprice+"','"+gnum+"','"+gintroduce+"','"+gdate+"','"+gtypeid+"')");*/
						int re=pt.executeUpdate(); 
						if(re>0){
							flag=true;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return flag;
				}
				
				
}