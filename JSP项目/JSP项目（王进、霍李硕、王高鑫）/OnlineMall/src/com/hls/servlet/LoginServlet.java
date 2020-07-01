package com.hls.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hls.dao.DBDao;
import com.hls.dao.DaoDB;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		DaoDB db = new DaoDB();
		String admin_name = request.getParameter("admin_name");
		String admin_password = request.getParameter("admin_password");
		//request.setAttribute("admin_name", admin_name);
		HttpSession session = request.getSession();
		if(db.admin_login(admin_name, admin_password)){
			session.setAttribute("admin_name", admin_name);
			response.sendRedirect("./Hbuju1.jsp");
		}else{
			response.sendRedirect("./loginerror.jsp");
		}
		
		
	}
}
