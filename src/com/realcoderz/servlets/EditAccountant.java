package com.realcoderz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.beans.AccountantBean;
import com.realcoderz.beans.StudentBean;
import com.realcoderz.dao.AccountantDao;
import com.realcoderz.dao.StudentDao;
@WebServlet("/EditAccountant")
public class EditAccountant extends HttpServlet {
	private static final Logger logger=Logger.getLogger(AccountantLogin.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean(id,name, email, password, address, contact);
		AccountantDao.update(bean);
		response.sendRedirect("ViewAccountant");
		logger.info("successfull");
		out.close();
	}

}
