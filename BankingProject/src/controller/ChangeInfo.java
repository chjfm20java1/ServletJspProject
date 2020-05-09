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

/**
 * Servlet implementation class ChangeInfo
 */
@WebServlet("/ChangeInfo")
public class ChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		HttpSession session = request.getSession(false);
		RequestDispatcher rd1 = request.getRequestDispatcher("passsuccess.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("mobsuccess.jsp");

		CustomerDao cd = new CustomerDao();
		String username = (String)session.getAttribute("username");
		if (type.equals("changepass")) {
			String pass = request.getParameter("newtranspass");
//			out.println(pass);
			cd.updateTransPass(pass, username);
			rd1.forward(request, response);
			
		}
		else if (type.equals("changemob")) {
			long mob = Long.parseLong(request.getParameter("newmob"));
//			out.println(mob);
//			out.println(username);
			cd.updatePhone(mob, username);
			rd2.forward(request, response);
		}
		
	}

}
