package daopack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojopack.Customer;


public class AdminDao {

	public void insertUser(Customer cust) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = CustomerDao.getConnection();
			ps = con.prepareStatement(
					"insert into cust_details(username,fname,lname,acc_num,dob,address,pincode,acc_type,trans_pwd,phone_num) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, cust.getUsername());
			ps.setString(2, cust.getFname());
			ps.setString(3, cust.getLname());
			ps.setLong(4, cust.getAcc_num());
			ps.setDate(5, (Date) cust.getDob());
			ps.setString(6, cust.getAddress());
			ps.setInt(7, cust.getPincode());
			ps.setString(8, cust.getAcc_type());
			ps.setString(9, cust.getTrans_pwd());
			ps.setLong(10, cust.getPhone_num());
			ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean deleteCustomer(long acc_num) {
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		boolean flag = false;
		try {
			double bal = 0;
			con = CustomerDao.getConnection();
			ps = con.prepareStatement("select balance from cust_details where acc_num=?");
			ps.setLong(1, acc_num);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bal = rs.getDouble(1);
			}
			if(bal==0) {
				ps2 = con.prepareStatement("delete from cust_details where acc_num=? ");
				ps2.setLong(1, acc_num);
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				ps2.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;

	}
	public ArrayList<Customer> viewCustomer(String username){
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<Customer> al = new ArrayList<Customer>();
		try {
		con = CustomerDao.getConnection();
		ps = con.prepareStatement("select*from customer where acc_no = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Customer c = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDouble(9), rs.getString(10), rs.getLong(11));
			al.add(c);
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
	
}
