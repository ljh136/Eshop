package com.wj.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.wj.bean.User;
import com.wj.service.AddUserService;
import com.wj.service.LoginUserService;
import com.wj.service.PersonalService;
import com.wj.service.UpdatePasswordService;
import com.wj.service.UpdateUserService;

public class WUpdatePasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.valueOf(request.getParameter("uid"));
		String upassword = request.getParameter("upassword");
		String uanswer = request.getParameter("uanswer");
		String unpassword = request.getParameter("unpassword");
		String unpassword1 = request.getParameter("unpassword1");
		if(unpassword==unpassword1||unpassword.equals(unpassword1)){
			if(UpdatePasswordService.query(uid,upassword,uanswer)){
				UpdatePasswordService.newpassword(uid,unpassword);
				request.setAttribute("type","2");
				request.getRequestDispatcher("./login.jsp").forward(request, response);
			}
			else{
				response.sendRedirect("./paserror.jsp");
			}
		}
		else{
			response.sendRedirect("./paserror.jsp");
		}
	}
		
}
