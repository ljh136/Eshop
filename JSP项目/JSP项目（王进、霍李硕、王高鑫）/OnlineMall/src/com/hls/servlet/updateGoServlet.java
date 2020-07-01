package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.hls.dao.*;

public class updateGoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//图片上传处理
		SmartUpload su = new SmartUpload();
		su.initialize(super.getServletConfig(), request, response);
		su.setAllowedFilesList("jpg,JGP,PNG,png");
		try {
			su.upload();
			long fn = su.getFiles().getCount();
			File[] f=new File[8];
			for(int i=0;i<fn;i++){
				f[i]=su.getFiles().getFile(i);
			}
			String path = request.getSession().getServletContext().getRealPath("upload");
			List list =new ArrayList();
			for(int i=0;i<fn;i++){
				if(!f[i].isMissing()){
					f[i].saveAs(path+"/"+f[i].getFileName());
					list.add("upload/"+f[i].getFileName());				
				}
			}
					
			
			//获取其他表单值
			String gg = su.getRequest().getParameter("gid");
			int gid = Integer.valueOf(gg);
			String gname = su.getRequest().getParameter("gname");
			String gprice = su.getRequest().getParameter("gprice");
			String num = su.getRequest().getParameter("gnum");
			int gnum = Integer.valueOf(num) ;
			String gintroduce = su.getRequest().getParameter("gintroduce");
			int gtypeid = Integer.valueOf(su.getRequest().getParameter("gtypeid"));
			
					
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			java.util.Date now = new java.util.Date();
			String dat = date.format(now);
			String gdate = dat;
			
			DaoDB db = new DaoDB();   
			if(db.updateGood(gid,gname,list,gprice,gnum,gintroduce,gdate,gtypeid)){
				response.sendRedirect("./Goodall.jsp");
			}else response.sendRedirect("./error.jsp");
						
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("图片上传失败");
			}

	}

}
