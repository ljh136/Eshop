package com.hls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.User;
import com.hls.dao.DaoDB;

public class Hordergoodservlet extends HttpServlet {

	
	public Hordergoodservlet() {
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
		
		int gid = Integer.valueOf(request.getParameter("gid")) ;
		   DaoDB db = new DaoDB();
		   List good=db.queryByGid(gid);
		   request.setAttribute("good", good);
		   request.getRequestDispatcher("Hordergood.jsp").forward(request, response);
		   
		   
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
