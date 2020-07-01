package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.GoodsMark;
import com.hls.bean.Order;
import com.hls.bean.User;
import com.hls.dao.DaoDB;

public class HGoodsMarkservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HGoodsMarkservlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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
		
		int gid =  Integer.valueOf(request.getParameter("gid"));
		request.setAttribute("gid", gid);
		request.getRequestDispatcher("Hintroduce.jsp").forward(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
