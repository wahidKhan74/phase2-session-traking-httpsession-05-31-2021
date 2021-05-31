package com.mcit.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// add nav bar
		request.getRequestDispatcher("index.html").include(request, response);

		String email = request.getParameter("email");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		if (email.equals("admin@gmail.com") && password.equals("pass@123")) {

			// create a httpsession
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", userId);
			session.setAttribute("email", email);
			
			// success message
			out.print("<h3 style='color:green'> Your are successfully logged In ! <h3>");
			out.print("<p style='color:green'> Welcome user, " + email + "</p>");

		} else {
			out.print("<h3 style='color:red'> Sorry, Invalid Credentials ! <h3>");
		}

	}

}
