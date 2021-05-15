package com.realcoderz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.dao.StudentDao;
import com.realcoderz.service.StudentService;
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final Logger logger=Logger.getLogger(AccountantLogin.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService student = new StudentService();
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		student.delete(rollno);
		response.sendRedirect("ViewStudent");
		logger.info("ViewStudent");
	}
}
