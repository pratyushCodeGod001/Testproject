package com.realcoderz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.dao.AccountantDao;
import com.realcoderz.service.AccountantService;
//@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {
	private static final Logger logger=Logger.getLogger(AccountantLogin.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>Accountant Panel</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
		AccountantService as = new AccountantService();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean status=as.validate(email, password);
		if(status){
			
			
			HttpSession session=request.getSession();
			session.setAttribute("accountant","true");
			session.setAttribute("ref_id", as.getId(email,password));
			logger.info("account login success");
			request.getRequestDispatcher("accountanthome.html").include(request, response);
		}else{
			
			
			out.println("<h1>Accountant Login Form</h1>");
			out.println("<p>Sorry, username or password error!</p>");
			request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
			logger.info("account login failure");
		}
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
