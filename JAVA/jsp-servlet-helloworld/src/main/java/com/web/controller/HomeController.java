package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Hello;

@WebServlet(urlPatterns = "/hello")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Hello hello = new Hello();
		hello.setSaySomething("Hello World");
		
		req.setAttribute("hello", hello); //khoá 
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/index.jsp");
		requestDispatcher.forward(req, resp);
	}
	
}