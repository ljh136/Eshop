package com.wj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wj.bean.Buycat;
import com.wj.bean.Goods;
import com.wj.bean.User;
import com.wj.service.LoginUserService;
import com.wj.service.MyCatService;
import com.wj.service.PersonalService;

public class WMyCatServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uid1 = String.valueOf(session.getAttribute("uid"));
		if((session.getAttribute("uid"))==null||"".equals(session.getAttribute("uid"))){
			request.setAttribute("type", "3");
			   request.getRequestDispatcher("./login.jsp").forward(request, response);
		}else{
		int uid = Integer.valueOf(uid1);
		//集合list存放自己购物车的数据
		List<Buycat> list= MyCatService.queryBuycat(uid);
		//集合listg存放自己购物车商品的商品详细
		//List<Goods> listg= new ArrayList<Goods>();
		//for(int i=0;i<list.size();i++){
			//根据list的gid获取商品详细
			//listg.add(MyCatService.getGoodBygid(list.get(i).getGid()));
				
		//}
		request.setAttribute("list",list);
		//request.setAttribute("listg",listg);
		request.getRequestDispatcher("./mycat.jsp").forward(request, response);
		}
	}
}
