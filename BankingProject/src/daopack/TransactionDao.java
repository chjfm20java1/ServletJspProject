package daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojopack.Transaction;

public class TransactionDao {
	
	
	
	public ArrayList<Transaction> viewStatement(long acc){
		Connection con = null;
		
		PreparedStatement ps = null;
		ArrayList<Transaction> al = new ArrayList<Transaction>();
		try {
		con = CustomerDao.getConnection();
	
		ps = con.prepareStatement("select*from transaction where acc_num = ? order by trans_id");
		ps.setLong(1, acc);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Transaction t = new Transaction(rs.getInt(1), rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getTimestamp(7));
			al.add(t);
		}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	
public static double viewBalance(long acc) {
	double bal=0;
	Connection con = null;
	PreparedStatement ps = null;
	try {
	con = CustomerDao.getConnection();
	ps = con.prepareStatement("select balance from cust_details where acc_num = ?");
	ps.setLong(1, acc);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		bal = rs.getDouble(1);
	}
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();

	}finally {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return bal;
}
public boolean fundTransfer(double amount,long acc_num,String transpass) {
	Connection con = null;
	
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	boolean flag = false;

	try { 
		con = CustomerDao.getConnection();
		double newBalance = 0; 
		String pass="";
		ps3 = con.prepareStatement("select trans_pwd from cust_details where acc_num=?");
		ps3.setLong(1, acc_num);
		ResultSet rs = ps3.executeQuery();
		while (rs.next()) {
			pass = rs.getString(1);
		}
		if (transpass.equals(pass)) {
			double bal = viewBalance(acc_num);
			newBalance = bal-amount;
			if (newBalance>1000) {
				ps2 = con.prepareStatement("update cust_details set balance = ? where acc_num=?");
				ps2.setDouble(1, newBalance);
				ps2.setLong(2, acc_num);
				ps2.executeQuery();
				flag=true;
			}	
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			
			con.close();
			ps3.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return flag;
}
public boolean deposit(long acc, double amnt) {
	boolean flag = false;
	double bal = 0;
	Connection con = null;
	PreparedStatement ps = null;
	try {
	con = CustomerDao.getConnection();
	bal = viewBalance(acc);
//	System.out.println(acc);
//	System.out.println(bal);
//	System.out.println(amnt);
	double newbal = bal+amnt;
	ps = con.prepareStatement("update cust_details set balance = ? where acc_num= ?");
	ps.setDouble(1, newbal);
	ps.setLong(2, acc);
	flag = ps.execute();
//	System.out.println(flag);
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();

	}finally {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return flag;
}
public boolean withdraw(long acc, double amnt) {
	boolean flag = false;
	double bal = 0;
	Connection con = null;
	PreparedStatement ps = null;
	try {
	con = CustomerDao.getConnection();
	bal = viewBalance(acc);
//	System.out.println(acc);
//	System.out.println(bal);
//	System.out.println(amnt);
	double newbal = bal-amnt;
	if(newbal>=0) {
	ps = con.prepareStatement("update cust_details set balance = ? where acc_num= ?");
	ps.setDouble(1, newbal);
	ps.setLong(2, acc);
	ps.execute();
	flag = true;
	}
//	System.out.println(flag);
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();

	}finally {
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return flag;
}
}

