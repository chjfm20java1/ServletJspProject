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
import daopack.TransactionDao;

/**
 * Servlet implementation class Current
 */
@WebServlet("/Current")
public class Current extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String acc_type = request.getParameter("type"); 
		
		String operation = request.getParameter("operation");
		
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		
		
//		pw.println(username);
//		pw.println(acc_type);
		
		
		CustomerDao cd = new CustomerDao();
		TransactionDao td = new TransactionDao();
		long acc = cd.getAccNum(acc_type, username);
		
		
//		pw.println(acc);
//		pw.println(amt);
		if (operation.equals("fundtransfer")) {
		
			double amt = Double.parseDouble(request.getParameter("amt"));	
			String transpass = request.getParameter("transpass");
			boolean flag = td.fundTransfer(amt, acc,transpass);
			if (flag) {
				RequestDispatcher rd = request.getRequestDispatcher("transsuccess.jsp");
				rd.forward(request, response);			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("transfail.jsp");
				rd.forward(request, response);			
				}
		
			
		}
		else if(operation.equals("deposit")) {
			double amount =  Double.parseDouble(request.getParameter("amnt"));
			boolean flag = td.deposit(acc, amount);
//			System.out.println(flag);
			if (!flag) {
				RequestDispatcher rd = request.getRequestDispatcher("depositsucc.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("depositfail.jsp");
				rd.forward(request, response);
			}
//			pw.println(operation);
//			pw.println(amount);
		}
		else if(operation.equals("withdraw")) {
			double amount =  Double.parseDouble(request.getParameter("amnt"));
			boolean flag = td.withdraw(acc, amount);
			pw.print(amount);
//			System.out.println(amount);
//			System.out.println(flag);
			if (flag) {
				double newbal = TransactionDao.viewBalance(acc);
				request.setAttribute("balance", newbal);
				RequestDispatcher rd = request.getRequestDispatcher("withdrawsucc.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("withdrawfail.jsp");
				rd.forward(request, response);
			}
//			pw.println(operation);
//			pw.println(amount);
		}
		else if (operation.equals("view balance")) {
			double balance = TransactionDao.viewBalance(acc);
			RequestDispatcher rd = request.getRequestDispatcher("Balance.jsp");
			request.setAttribute("balance", balance);
			rd.forward(request, response);
		}	
	}

	}


