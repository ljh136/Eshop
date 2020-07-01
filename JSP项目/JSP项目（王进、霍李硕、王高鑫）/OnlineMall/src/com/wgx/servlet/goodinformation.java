package com.wgx.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgx.bean.GoodsMark;
import com.wgx.bean.goods;
import com.wgx.dao.DaoDB;

public class goodinformation extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gid =  Integer.valueOf(request.getParameter("gid"));
		DaoDB db = new DaoDB();
		goods good =db.getGoodByid(gid);
		List list= db.querymarkByGid(gid);
		request.setAttribute("good", good);
		request.setAttribute("list", list);
		request.getRequestDispatcher("goodinfor.jsp").forward(request, response);
		
	}

}
