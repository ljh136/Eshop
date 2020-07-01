package com.wgx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgx.bean.Buycat;
import com.wgx.dao.DaoDB;

public class gopayforit extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] buygoods=request.getParameterValues("checkbox");
		String bid1 =  request.getParameter("bid");
		String list1 =request.getParameter("list");
		Buycat buycar = new Buycat();
		List list=new ArrayList();
		if(buygoods==null){
			int bid=Integer.valueOf(bid1);
			DaoDB db = new DaoDB();
			 buycar = db.querybuycarBybid(bid);
			 request.setAttribute("buycar", buycar);
			 request.setAttribute("buygoods", buygoods);
			request.setAttribute("bid1", bid1);
			
			 int uid=buycar.getUid();
			 int gid=buycar.getGid();
			 int bnum=buycar.getBnum();
			 int otype=1;
			String bdate=new Date().toLocaleString();
			db.insertorder(uid, gid, otype, bnum, bdate);
			
			request.getRequestDispatcher("payforit.jsp").forward(request, response);
				
		}
		else{
			for(int i=0;i<buygoods.length;i++){
				DaoDB db = new DaoDB();
				int bid2 =  Integer.valueOf(buygoods[i]);
				buycar=(Buycat)db.querybuycarBybid(bid2);
				list.add(buycar);
				
				int uid=buycar.getUid();
				 int gid=buycar.getGid();
				 int otype=1;
				 int bnum=buycar.getBnum();
				 String bdate=new Date().toLocaleString();
				 db.insertorder(uid, gid, otype, bnum, bdate);
			}
			request.setAttribute("list", list);
			 request.setAttribute("buygoods", buygoods);
			 request.setAttribute("bid1", bid1);
			request.getRequestDispatcher("payforit.jsp").forward(request, response);	
		}

			
	}

}
