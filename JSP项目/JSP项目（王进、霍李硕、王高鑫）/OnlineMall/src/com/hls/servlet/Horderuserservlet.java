package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.User;
import com.hls.dao.DaoDB;

public class Horderuserservlet extends HttpServlet {

	public Horderuserservlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int uid =  Integer.valueOf(request.getParameter("uid"));
		DaoDB db = new DaoDB();
		User user = db.getUserByid(uid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("Horderuser.jsp").forward(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
