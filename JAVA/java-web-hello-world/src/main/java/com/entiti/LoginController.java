package com.entiti;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		response.setContentType("text/html");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Loginbean bean = new Loginbean();
		bean.setUsername(name);
		bean.setPassword(password);
		
		request.setAttribute("bean", bean);
		
		boolean status = bean.validate();
		
		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}
		
		
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
