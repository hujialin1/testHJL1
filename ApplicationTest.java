package com.zxxz.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="appliaction1",urlPatterns="/appliaction1")
public class ApplicationTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建application
		ServletContext application = req.getServletContext();
		char a = '1';
		//定义访问量
		int accessNum = 0;
		if(application.getAttribute("accessNum") != null){
			accessNum = (int) application.getAttribute("accessNum");
		}
		accessNum++;
		application.setAttribute("accessNum", accessNum);
		resp.getWriter().println("accessNum="+accessNum);
	}
}
