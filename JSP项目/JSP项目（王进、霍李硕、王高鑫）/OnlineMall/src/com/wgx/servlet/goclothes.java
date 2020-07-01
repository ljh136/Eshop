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

public class goclothes extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoDB db = new DaoDB();
		List list = db.queryGoods();
		request.setAttribute("list", list);
		request.getRequestDispatcher("clothes.jsp").forward(request, response);
	}

}
