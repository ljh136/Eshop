package com.hls.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hls.bean.GoodsMark;
import com.hls.bean.Order;
import com.hls.bean.User;
import com.hls.bean.leaveword;
public class DaoDB {
	boolean flag = false;
	Connection con = null;
	PreparedStatement pt = null;
	Statement st = null;
	ResultSet rs = null;
	
	
	//登陆
	public boolean admin_login(String admin_name,String admin_password) {
		con = DBC.getConnection();
		try {
		pt =con.prepareStatement("select * from admin where admin_name='"+admin_name+"' and admin_password='"+admin_password+"'");
		rs = pt.executeQuery();
		if(rs!=null) {
			flag=true;
		}
		else{
			flag=false;
		}
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBC.closeAll(con, pt,st, rs);
		}
		return flag;
	}
	//通过管理员name查询管理员表数据
	public int getadmin(String admin_name) {
		int admin_id = 0;
		con = DBC.getConnection();
		try {
			
			pt =   con.prepareStatement("select admin_id from admin where admin_name = ?");
			
			pt.setString(1, admin_name);
			rs =  pt.executeQuery();
			if(rs!=null&&rs.next()){
				admin_id = rs.getInt("admin_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBC.closeAll(con, pt,st, rs);
		}
		return admin_id;
	}
	
	//查询商品表中的所有数据
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
		
		//查询用户表的所有数据
				public List queryUser(){
					List list= new ArrayList();
					con = DBC.getConnection();
					
					try {
						pt =  con.prepareStatement("select * from user");
						rs =  pt.executeQuery();
						while(rs!=null&&rs.next()){
							User user = new User(rs.getInt("uid"), rs.getString("ulogo"), rs.getString("uname"), rs.getString("utel"),
									rs.getString("upassword"),rs.getString("uemail"), rs.getString("address"),rs.getString("uquestion"),
									rs.getString("uanswer"), rs.getString("uregtime"), rs.getString("ustel"));
							list.add(user);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return list;
				}
				//查询订单表中的所有数据
				public List queryorder(){
					List list= new ArrayList();
					con = DBC.getConnection();
					
					try {
						pt =  con.prepareStatement("select * from  `order`");
						rs =  pt.executeQuery();
						while(rs!=null&&rs.next()){
							Order order = new Order(rs.getInt("oid"),rs.getInt("uid"),rs.getInt("gid"),rs.getInt("otype"),
									rs.getInt("bnum"),rs.getString("bdate"));
							list.add(order);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return list;
				}
				//查询评价表中的所有数据
				public List querymark(){
					List list= new ArrayList();
					con = DBC.getConnection();
					
					try {
						pt =  con.prepareStatement("select * from  goodsmark");
						rs =  pt.executeQuery();
						while(rs!=null&&rs.next()){
							GoodsMark mark = new GoodsMark(rs.getInt("mid"),rs.getInt("gid"),rs.getInt("uid"),rs.getString("gmark"),rs.getString("gdate"));
							list.add(mark);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return list;
				}	
				//通过商品id查询评价表数据
				public List getGoodmarkByid(int gid) {
					List list= new ArrayList();
					con = DBC.getConnection();
					try {
						
						pt =   con.prepareStatement("select * from goodsmark where gid = ?");
						
						pt.setInt(1, gid);
						rs =  pt.executeQuery();
						if(rs!=null&&rs.next()){
							GoodsMark mark = new GoodsMark(rs.getInt("mid"),rs.getInt("gid"),rs.getInt("uid"),rs.getString("gmark"),rs.getString("gdate"));
							list.add(mark);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return list;
				}
		//通过id查询商品数据
		public leaveword getGoodByid(int gid) {
			con = DBC.getConnection();
			leaveword good = null;
			try {
				
				pt =   con.prepareStatement("select * from goods where gid = ?");
				
				pt.setInt(1, gid);
				rs =  pt.executeQuery();
				if(rs!=null&&rs.next()){
					good = new  leaveword(rs.getInt("gid"),rs.getString("gname"),rs.getString("gpic"),
							rs.getString("gprice"),rs.getInt("gnum"),rs.getInt("gtypeid"), rs.getString("gintroduce"),rs.getString("gdate"),rs.getInt("gsales"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
			return good;
		}
		//通过id查询用户数据
				public User getUserByid(int uid) {
					con = DBC.getConnection();
					User user = null;
					try {
						pt =   con.prepareStatement("select * from user where uid = ?");
						pt.setInt(1, uid);
						rs =  pt.executeQuery();
						if(rs!=null&&rs.next()){
							user =new User(rs.getInt("uid"), rs.getString("ulogo"), rs.getString("uname"), rs.getString("utel"),
									rs.getString("upassword"),rs.getString("uemail"), rs.getString("address"),rs.getString("uquestion"),
									rs.getString("uanswer"), rs.getString("uregtime"), rs.getString("ustel"));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return user;
				}

				//通过id查询订单数据
				public Order getOrderByid(int oid) {
					con = DBC.getConnection();
					Order order = null;
					try {
						pt =   con.prepareStatement("select * from `order` where oid = ?");
						pt.setInt(1, oid);
						rs =  pt.executeQuery();
						if(rs!=null&&rs.next()){
							order = new Order(rs.getInt("oid"),rs.getInt("uid"),rs.getInt("gid"),rs.getInt("otype"),
									rs.getInt("bnum"),rs.getString("bdate"));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return order;
				}		
		
		//修改商品
		public boolean updateGood(int gid, String gname,List list, String gprice, int gnum, String gintroduce,
				String gdate,int gtypeid) {
			con = DBC.getConnection();
			try {
				/*
				pt =con.prepareStatement("update goods set gname=?,gpic=?,gprice=?,gnum=?,gintroduce=?,gdate=?,gtypeid=? where gid=?");
				pt.setString(1, gname);
				pt.setString(2, list);
				pt.setString(3, gprice);
				pt.setInt(4, gnum);
				pt.setString(5, gintroduce);
				pt.setString(6, gdate);
				pt.setInt(7, gtypeid);
				pt.setInt(8, gid);
				*/
				pt =con.prepareStatement("update goods set gname='"+gname+"',gpic='"+list+"',gprice='"+gprice+"',gnum='"+gnum+"',gintroduce='"+gintroduce+"',gdate='"+gdate+"',gtypeid='"+gtypeid+"' where gid='"+gid+"'");
				int re =pt.executeUpdate();
				//if(re>0) 
					//flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
			return true;
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
				   		pt =con.prepareStatement("update goods set gnum = 0 where gid=?");
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
		//删除评论
		public boolean deletemark(int mid) {
			con = DBC.getConnection();
			try {
				
				pt =con.prepareStatement("delete from goodsmark where mid='"+mid+"'");
				int re =pt.executeUpdate();
				//if(re>0) 
					//flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBC.closeAll(con, pt,st, rs);
			}
			return true;
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


		
		//通过商品名称查询商品
		public List queryByGname(String gname) {
			List list= new ArrayList();
			con = DBC.getConnection();
			try {
				pt =  con.prepareStatement("select * from goods where gname=?");
				pt.setString(1, gname);
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
		
		//发货后修改商品
				public boolean updateorder(int gid,int gnum,int otype,int bnum,int gsales,int oid) {
					con = DBC.getConnection();
					try {
						/*
						pt =con.prepareStatement("update goods set gname=?,gpic=?,gprice=?,gnum=?,gintroduce=?,gdate=?,gtypeid=? where gid=?");
						pt.setString(1, gname);
						pt.setString(2, list);
						pt.setString(3, gprice);
						pt.setInt(4, gnum);
						pt.setString(5, gintroduce);
						pt.setString(6, gdate);
						pt.setInt(7, gtypeid);
						pt.setInt(8, gid);
						*/
						gnum = gnum-bnum;
						gsales = gsales+bnum;
						if(otype==1){
							otype=2;
						}
						else if(otype==3){
							otype=3;
						}
						else{
							otype=2;
						}
						pt =con.prepareStatement("update goods set gnum='"+gnum+"',gsales="+gsales+"'where gid='"+gid+"'");
						pt =con.prepareStatement("update `order` set otype='"+otype+"'where oid='"+oid+"'");
						int re =pt.executeUpdate();
						//if(re>0) 
							//flag=true;
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBC.closeAll(con, pt,st, rs);
					}
					return true;
				}
				
				//通过订单编号查询商品编号
				public List queryByOid(int Oid) {
					List list= new ArrayList();
					con = DBC.getConnection();
					try {
						pt =  con.prepareStatement("select * from order where Oid=?");
						pt.setInt(1, Oid);
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
				

}
