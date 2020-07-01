package com.hls.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.hls.bean.leaveword;
import com.hls.dao.*;


public class PicDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//鍥剧墖涓嬭浇
		String filename=request.getParameter("filename");
		SmartUpload su = new SmartUpload();
		su.initialize(super.getServletConfig(),request,response);
		su.setContentDisposition(null);
		try {
			su.downloadFile(filename);
		} catch (SmartUploadException e) {
			
			e.printStackTrace();
			System.out.println("图片下载失败");
		}
	}

}
