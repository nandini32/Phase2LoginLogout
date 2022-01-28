package com.phase2.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String un = request.getParameter("username");
		String pwd = request.getParameter("password");
		
	     //Get a reference to the session
		HttpSession session = request.getSession();
//	    get a reference to the context
		ServletContext context = request.getServletContext();
//	     check whether parameter exists in the request
		if(un.trim().equals("Nandini") &&pwd.trim().equals("mycomp")) {
			session.setAttribute("username", un);
			session.setAttribute("userpass", pwd);
			
			response.sendRedirect("dashboard");
		}
		else {

			response.getWriter().println("Invalid username or password!!!");
//			Get the RequestDispatcher object
			RequestDispatcher dispatcher = request.getRequestDispatcher("Session.html");
			
//			Forward the request
			dispatcher.include(request, response);
		}
			
			
		
	
	}

}
