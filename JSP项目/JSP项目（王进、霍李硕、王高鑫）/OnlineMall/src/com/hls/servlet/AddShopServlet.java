package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hls.dao.DBDao;
import com.hls.dao.DaoDB;


public class AddShopServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("uname");
		String [] booksname = request.getParameterValues("gid");

		ArrayList  arrs = new ArrayList();
		for(String bookname : booksname){
			arrs.add(bookname);
		}
		
		if(DBDao.insertShop(uname,arrs)){
			
			String readShop = DBDao.readShop(uname);
			if("0".equals(readShop)){
				response.sendRedirect("./error.jsp");
			}else{
				DBDao db=new DBDao();
				List list=db.GidGname(readShop);
		    
				request.setAttribute("listbook",list);
				request.getRequestDispatcher("shopcat.jsp").forward(request, response);
			}
		}else{	
			response.sendRedirect("./error.jsp");
			}
	}
}
