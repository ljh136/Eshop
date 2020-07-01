package com.wgx.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgx.dao.DaoDB;

public class godeliciousfood extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoDB db = new DaoDB();
		List list =db.queryGoods();
		request.setAttribute("list", list);
		request.getRequestDispatcher("deliciousfood.jsp").forward(request, response);
	}

}
