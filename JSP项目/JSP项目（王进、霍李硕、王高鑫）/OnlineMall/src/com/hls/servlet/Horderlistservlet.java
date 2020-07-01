package com.hls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.Order;
import com.hls.bean.leaveword;
import com.hls.dao.DaoDB;

public class Horderlistservlet extends HttpServlet {

	public Horderlistservlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int oid =  Integer.valueOf(request.getParameter("oid"));
		DaoDB db = new DaoDB();
		Order order = db.getOrderByid(oid); 
		request.setAttribute("order", order);
		request.getRequestDispatcher("Horderlistservlet2").forward(request, response);
	}

	public void init() throws ServletException {
		
	}

}
