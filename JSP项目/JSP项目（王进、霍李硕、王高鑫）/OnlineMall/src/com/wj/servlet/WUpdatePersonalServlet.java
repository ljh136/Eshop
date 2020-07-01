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
import com.wj.service.UpdateUserService;

public class WUpdatePersonalServlet extends HttpServlet {

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
			String nulogo = su.getRequest().getParameter("nulogo");
			if(ulogo==null||"".equals(ulogo)){
				ulogo=nulogo;
			}
			int uid = Integer.valueOf(su.getRequest().getParameter("uid")) ;
			String uname = su.getRequest().getParameter("uname");
		   String uemail = su.getRequest().getParameter("uemail") ;
		   String uquestion = su.getRequest().getParameter("uquestion");
		   String uanswer = su.getRequest().getParameter("uanswer");
		   String address = su.getRequest().getParameter("address");
		   String ustel = su.getRequest().getParameter("ustel");
			 
		   if(uquestion!=null){
			   UpdateUserService.updateUser1(uid,ulogo,uname,uemail,uquestion,uanswer,address,ustel);
		   }
		   if(uquestion==null){
			   UpdateUserService.updateUser2(uid,ulogo,uname,uemail,address,ustel);
		   }
			   response.sendRedirect("WPersonalServlet");
				
			} catch (SmartUploadException e) {
				e.printStackTrace();
				}
		}
		
}
