package com.wj.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.wj.bean.User;
import com.wj.service.AddUserService;

public class WAddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(super.getServletConfig(), request, response);
		su.setAllowedFilesList("jpg,JGP,PNG,png");
		try {
			su.upload();
			File f=su.getFiles().getFile(0);
			String path = request.getSession().getServletContext().getRealPath("upload");
		
			String ulogo=null;
			if(!f.isMissing()){
				f.saveAs(path+"/"+f.getFileName());
				ulogo="upload/"+f.getFileName();
			}
			
			if(ulogo==null){
				ulogo="upload/ulogo.jpg";
			}
			
			String uname = su.getRequest().getParameter("uname");
		   String utel = su.getRequest().getParameter("utel") ;
		   String upassword = su.getRequest().getParameter("upassword") ;
		   String uemail = su.getRequest().getParameter("uemail");
			 
		   User user = new User();
		   user.setUlogo(ulogo);
		   user.setUname(uname);
		   user.setUtel(utel);
		   user.setUpassword(upassword);
		   user.setUemail(uemail);
		   user.setUregtime(new Date().toLocaleString());

			   AddUserService.adduser(user);
			   request.setAttribute("type","4");
				request.getRequestDispatcher("./login.jsp").forward(request, response);
				
			} catch (SmartUploadException e) {
				e.printStackTrace();
				}
		}				
	
}
