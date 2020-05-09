package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import daopack.CustomerDao;
import pojopack.Log;

@WebServlet("/Log")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		
		PrintWriter pw = response.getWriter();
		Log l = new Log(user,pass);
		CustomerDao cd = new CustomerDao();
		String type = cd.validUser(l);
		if(type.equals("customer")) {
			String name = cd.getName(user);
			name = name.toUpperCase();
//			System.out.println(name);
			HttpSession session = request.getSession();
			session.setAttribute("username", user);
			session.setAttribute("name", name);
			response.sendRedirect("customer.jsp");
		}
		else if(type.equals("admin")) {
			pw.println("Logged in as admin");
		}
		else
			pw.println("invalid user/password");
	}

}
