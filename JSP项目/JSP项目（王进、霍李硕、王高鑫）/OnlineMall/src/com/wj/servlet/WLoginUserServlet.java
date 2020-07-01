package com.wj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wj.bean.User;
import com.wj.service.LoginUserService;
import com.wj.service.PersonalService;

public class WLoginUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		
		HttpSession session = request.getSession();
		int uid=LoginUserService.loginuser(uname, upassword);
		if(uid!=0){
			String name=LoginUserService.uidtouname(uid);
			User user=PersonalService.GetUserByUid(uid);
			session.setAttribute("user", user);
			session.setAttribute("uid", uid);
			session.setAttribute("uname", name);
			response.sendRedirect("main.jsp");
		}else{
			request.setAttribute("type","1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
