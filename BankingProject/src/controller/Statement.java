package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.CustomerDao;
import daopack.TransactionDao;
import pojopack.Transaction;

/**
 * Servlet implementation class Statement
 */
@WebServlet("/Statement")
public class Statement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc_type = (String) request.getParameter("type");
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		CustomerDao cd = new CustomerDao();
		long acc = cd.getAccNum(acc_type, username);
		TransactionDao td = new TransactionDao();
		
		ArrayList<Transaction> al = td.viewStatement(acc);
//		for (Transaction transaction : al) {
//			System.out.println(transaction);
//		}
		RequestDispatcher rd = request.getRequestDispatcher("statement.jsp");
		request.setAttribute("statement", al);
		
		rd.forward(request, response);
		
	}

}
