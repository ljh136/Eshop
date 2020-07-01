package com.wgx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgx.bean.goods;
import com.wgx.dao.DaoDB;

public class maingoodquary extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoDB dao= new DaoDB();
		List list=dao.queryGoods();
		request.setAttribute("list", list);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
