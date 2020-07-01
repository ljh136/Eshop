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

public class paid extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String[] buygoods=request.getParameterValues("buygoods");
		String bid1 =  request.getParameter("bid1");
		Buycat buycar1 =new Buycat();
		String buycar =request.getParameter("buycar");
		//Buycat buycar2=;
		String list1 =  request.getParameter("list");
		
		System.out.println(bid1);
		System.out.println(buycar);
		System.out.println(list1);
		/*List list=new ArrayList();
		if(buycar!=null){
			int bid=Integer.valueOf(bid1);
			DaoDB db = new DaoDB();
			 int uid=buycar.getUid();
			 int gid=buycar.getGid();
			 int otype=1;
			 int bnum=buycar.getBnum();
			 String bdate=new Date().toLocaleString();
			 db.insertorder(uid, gid, otype, bnum, bdate);
			request.getRequestDispatcher("WMyOrderServlet").forward(request, response);
				
		}
		else{
			for(int i=0;i<buygoods.length;i++){
				DaoDB db = new DaoDB();
				int bid2 =  Integer.valueOf(buygoods[i]);
				Buycat buycar=(Buycat)db.querybuycarBybid(bid2);
				 int uid=buycar.getUid();
				 int gid=buycar.getGid();
				 int otype=1;
				 int bnum=buycar.getBnum();
				 String bdate=new Date().toLocaleString();
				 db.insertorder(uid, gid, otype, bnum, bdate);
			}
	
			request.getRequestDispatcher("WMyOrderServlet").forward(request, response);	
		}*/


	}
		
	}


