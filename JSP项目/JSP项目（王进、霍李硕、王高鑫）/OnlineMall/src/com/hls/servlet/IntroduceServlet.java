package com.hls.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hls.dao.DaoDB;
import com.hls.bean.leaveword;

public class IntroduceServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		int gid = Integer.valueOf(request.getParameter("gid")) ;
		DaoDB db= new DaoDB();
		leaveword goods=(leaveword) db.queryByGid(gid);

		request.setAttribute("goods",goods);
		request.getRequestDispatcher("introduce.jsp").forward(request, response);
		
	}
}
