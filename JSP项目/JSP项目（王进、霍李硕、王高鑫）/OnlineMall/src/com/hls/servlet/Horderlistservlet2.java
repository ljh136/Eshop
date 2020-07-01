package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.dao.DaoDB;
import com.hls.bean.Order;
import com.hls.bean.leaveword;

public class Horderlistservlet2 extends HttpServlet {

	public Horderlistservlet2() {
		super();
	}

	public void destroy() {
		super.destroy();
		// Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Order order = (Order) request.getAttribute("order");
		int oid = order.getOid();
		int gid = order.getGid();
		int otype = order.getOtype();
		int bnum = order.getBnum();
		DaoDB db = new DaoDB();
		
		
		leaveword good = db.getGoodByid(gid);
		
		int gnum = good.getGnum();
		int gsales = good.getGsales();
		
		if(db.updateorder(gid, gnum, otype, bnum, gsales,oid)){
			response.sendRedirect("Horderlist.jsp");
		}else{
			response.sendRedirect("./error.jsp");
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
