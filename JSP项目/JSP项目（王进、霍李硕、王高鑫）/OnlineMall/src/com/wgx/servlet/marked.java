package com.wgx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgx.dao.DaoDB;

public class marked extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gid =  Integer.valueOf(request.getParameter("gid"));
		int uid =  Integer.valueOf(request.getParameter("uid"));
		/*HttpSession session = request.getSession();
		String uid =  (String) session.getAttribute("uid");
		System.out.println("uid:"+uid);*/
		String gmark =request.getParameter("gmark");
		String bdate =new Date().toLocaleString();
		DaoDB db = new DaoDB();
		db.insertgoodmark(uid, gid, gmark, bdate);
		request.getRequestDispatcher("main.jsp").forward(request, response);	
	}

}
