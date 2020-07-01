package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.leaveword;
import com.hls.service.Insertservice;

public class Insertservlet extends HttpServlet {

	public Insertservlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int gid = Integer.valueOf(request.getParameter("gid"));
		String gname = request.getParameter("gname");
		String gprice = request.getParameter("gprice");
		String gpic = request.getParameter("gpic");
		String gintroduce = request.getParameter("gintroduce");
		int gtypeid = Integer.valueOf(request.getParameter("gtypeid"));
		int gnum = Integer.valueOf(request.getParameter("gnum"));
		int gsales = Integer.valueOf(request.getParameter("gsales"));
		String gdate = new Date().toLocaleString();
		
		//封装管理员传过来的商品数据
		leaveword lea = new leaveword(gid, gname, gpic, gprice, gnum, gtypeid, gintroduce, gdate, gsales);
		lea.setGid(gid);
		lea.setGname(gname);
		lea.setGprice(gprice);
		lea.setGpic(gpic);
		lea.setGintroduce(gintroduce);
		lea.setGtypeid(gtypeid);
		lea.setGnum(gnum);
		lea.setGdate(gdate);
		lea.setGsales(gsales);
		
		Insertservice.insertleave(lea);
		
	}

	
	public void init() throws ServletException {
		
	}

}
