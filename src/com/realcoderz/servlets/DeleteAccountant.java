package com.realcoderz.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.dao.AccountantDao;
import com.realcoderz.service.AccountantService;
@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet {
	private static final Logger logger=Logger.getLogger(AccountantLogin.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountantService as = new AccountantService();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
				as.delete(id);
		response.sendRedirect("ViewAccountant");
		logger.info("Account deleted successful");
	}
}
