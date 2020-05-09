package daopack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojopack.Log;

public class CustomerDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public String validUser(Log log) // passing constructor as argument
	{
		String type = "";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();

			ps = con.prepareStatement("select*from user_login where username=? and password=?");
			ps.setString(1, log.getUsername()); // calling getter from pojo class
			ps.setString(2, log.getPassword());
			ResultSet rs = ps.executeQuery(); // executing query
			if (rs.next()) {
				type = rs.getString(3);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return type;
	}

	public long getAccNum(String acc_type,String username) {
		long acc=0l;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			
			ps = con.prepareStatement("select acc_num from cust_details where username=? and acc_type=?");
			ps.setString(1, username); 
			ps.setString(2, acc_type);
			ResultSet rs = ps.executeQuery(); // executing query
			while (rs.next()) {
				acc = rs.getLong(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acc;
	}
	
	public void updateTransPass(String trans_pass, String username) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement("update cust_details set trans_pwd =? where username=?");
			ps.setString(1, trans_pass); // calling getter from pojo class
			ps.setString(2, username); // calling getter from pojo class
			ps.executeQuery(); // executing query

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

	public void updatePhone(long phone, String username) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement("update cust_details set  phone_num =? where username=?");
			ps.setLong(1, phone);
			ps.setString(2, username);
			ps.executeQuery(); // executing query

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

	public void updateAddress(String address, int pincode, long acc_num) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement("update cust_details set  phone_num =?, pincode=? where acc_num=?");
			ps.setString(1, address);
			ps.setInt(2, pincode);
			ps.setLong(3, acc_num);
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
	public String getName(String username) {
		String cusName="";
		PreparedStatement ps = null;
		Connection con = null;
		
		
		try {
			con = getConnection();
			ps = con.prepareStatement("select fname from cust_details where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cusName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cusName;
	}
}
