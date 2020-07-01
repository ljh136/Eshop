package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.leaveword;
import com.hls.dao.*;


public class QueryGoodServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

	   String gname = request.getParameter("gname");

		   DaoDB db = new DaoDB();
		   List good=db.queryByGname(gname);
		   request.setAttribute("good", good);
		   request.getRequestDispatcher("./result.jsp").forward(request, response);
	   
	}

}
