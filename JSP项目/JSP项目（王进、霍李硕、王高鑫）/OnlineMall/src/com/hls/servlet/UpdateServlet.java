package com.hls.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hls.bean.leaveword;
import com.hls.dao.*;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int gid =  Integer.valueOf(request.getParameter("gid"));
		DaoDB db = new DaoDB();
		leaveword good = db.getGoodByid(gid);
		request.setAttribute("good", good);
		request.getRequestDispatcher("updateGood.jsp").forward(request, response);
	}

}
