package com.realcoderz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.beans.StudentBean;
import com.realcoderz.dao.StudentDao;
import com.realcoderz.service.StudentService;
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final Logger logger=Logger.getLogger(AccountantLogin.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService student = new StudentService();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String course=request.getParameter("course");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int paid=Integer.parseInt(request.getParameter("paid"));
		int due=Integer.parseInt(request.getParameter("due"));
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		StudentBean bean=new StudentBean(rollno,name, email, sex, course, fee, paid, due, address, contact);
		int status=student.update(bean);
		response.sendRedirect("ViewStudent");
		logger.info("view Student");
		out.close();
	}

}
