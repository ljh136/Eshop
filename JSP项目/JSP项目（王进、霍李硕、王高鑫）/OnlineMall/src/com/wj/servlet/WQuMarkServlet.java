package com.wj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wj.bean.Goods;
import com.wj.bean.GoodsMark;
import com.wj.bean.Order;
import com.wj.bean.User;
import com.wj.service.LoginUserService;
import com.wj.service.MyCatService;
import com.wj.service.MyMarkService;
import com.wj.service.MyOrderService;
import com.wj.service.OrderOperationService;
import com.wj.service.PersonalService;

public class WQuMarkServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gid=Integer.valueOf(request.getParameter("gid"));
		Goods good=MyCatService.getGoodBygid(gid);
		response.sendRedirect("WMyOrderServlet");
		request.setAttribute("good",good);
		request.getRequestDispatcher("./mark.jsp").forward(request, response);
	}
}
