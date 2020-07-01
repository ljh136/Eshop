package com.wgx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wgx.bean.Order;
import com.wgx.bean.goods;
import com.wgx.dao.DaoDB;

public class buycar extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gid =  Integer.valueOf(request.getParameter("gid"));
		int bnum =  Integer.valueOf(request.getParameter("bnum")) ;
		String bdate=new Date().toLocaleString();

		HttpSession session = request.getSession();
		String uid1 = String.valueOf(session.getAttribute("uid"));
		if((session.getAttribute("uid"))==null||"".equals(session.getAttribute("uid"))){
			request.setAttribute("type", "3");
			   request.getRequestDispatcher("./login.jsp").forward(request, response);
		}else{
		int uid = Integer.valueOf(uid1);
			DaoDB db = new DaoDB();
		db.insertbuycargood(uid, gid, bnum, bdate);
		goods good =db.getGoodByid(gid);
		List list= db.querymarkByGid(gid);
		request.setAttribute("list", list);
		request.setAttribute("good", good);
		request.getRequestDispatcher("goodinfor.jsp").forward(request, response);
		}
		
	}

}
