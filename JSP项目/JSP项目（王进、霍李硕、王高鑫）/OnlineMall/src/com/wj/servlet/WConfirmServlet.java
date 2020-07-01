package com.wj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wj.bean.GoodsMark;
import com.wj.bean.Order;
import com.wj.bean.User;
import com.wj.service.LoginUserService;
import com.wj.service.MyMarkService;
import com.wj.service.MyOrderService;
import com.wj.service.OrderOperationService;
import com.wj.service.PersonalService;

public class WConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oid=Integer.valueOf(request.getParameter("oid"));
		OrderOperationService.confirm(oid);
		response.sendRedirect("WMyOrderServlet");
		
	}
}
