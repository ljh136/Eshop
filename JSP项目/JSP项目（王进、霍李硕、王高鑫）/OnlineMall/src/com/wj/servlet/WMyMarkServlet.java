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
import com.wj.service.PersonalService;

public class WMyMarkServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uid1 = String.valueOf(session.getAttribute("uid"));
		if((session.getAttribute("uid"))==null||"".equals(session.getAttribute("uid"))){
			request.setAttribute("type", "3");
			   request.getRequestDispatcher("./login.jsp").forward(request, response);
		}else{
		int uid = Integer.valueOf(uid1);
		
		List<GoodsMark> list= MyMarkService.queryMark(uid);
		request.setAttribute("list",list);
		request.getRequestDispatcher("./mymark.jsp").forward(request, response);
		}
	}
}
