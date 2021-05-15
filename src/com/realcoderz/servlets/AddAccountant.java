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
import com.realcoderz.service.AccountantService;

@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet {
	private static final Logger logger=Logger.getLogger(AddAccountant.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Added</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		String name=request.getParameter("name"); 
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean(name, email, password, address, contact);
		AccountantService as = new AccountantService();	

		
		int status=as.save(bean);	

		
		logger.info("account login saved");
		out.print("<h1>Add Accountant Form</h1>");
		out.println("<p>Accountant is added successfully!</p>");
		request.getRequestDispatcher("AddAccountantForm.html").include(request, response);
		
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
