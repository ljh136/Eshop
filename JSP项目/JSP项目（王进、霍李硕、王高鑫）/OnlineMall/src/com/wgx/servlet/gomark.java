package com.wgx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgx.bean.Order;
import com.wgx.bean.goods;
import com.wgx.dao.DaoDB;

public class gomark extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oid =  Integer.valueOf(request.getParameter("oid"));
		DaoDB db = new DaoDB();
		Order order=db.queryorderByid(oid);
		goods good =db.getGoodByid(order.getGid());
		request.setAttribute("good", good);
		request.setAttribute("order", order);
		request.getRequestDispatcher("mark.jsp").forward(request, response);
	
	}

}
