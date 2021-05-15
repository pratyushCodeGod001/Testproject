package com.realcoderz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realcoderz.service.AccountantService;

/**
 * Servlet implementation class AccountantCheck
 */
@WebServlet("/AccountantCheck")
public class AccountantCheck extends HttpServlet {
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		String email = request.getParameter("var");
		 AccountantService ac = new AccountantService();
		 if(ac.Check(email)) {
		 out.println("valid Accountant");
	    }else {
	    	out.print("Invalid Accountant");
	    }
	}

}
