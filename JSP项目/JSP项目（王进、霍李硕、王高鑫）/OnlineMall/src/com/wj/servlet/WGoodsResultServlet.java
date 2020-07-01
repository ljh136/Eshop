package com.wj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wj.bean.Goods;
import com.wj.bean.Order;
import com.wj.service.GoodsService;
import com.wj.service.MyOrderService;

public class WGoodsResultServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword=request.getParameter("keyword");
		
		List<Goods> list= GoodsService.query(keyword);
		request.setAttribute("list",list);
		request.getRequestDispatcher("./goodsresult.jsp").forward(request, response);
		
	}
}
