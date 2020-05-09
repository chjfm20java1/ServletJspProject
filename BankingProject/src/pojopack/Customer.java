package pojopack;

import java.util.Date;

public class Customer {

	private String username;
	private String fname;
	private String lname;
	private long acc_num;
	private Date dob;
	private String address;
	private int pincode;
	private String acc_type;
	private double balance;
	private String trans_pwd;
	private long phone_num;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String username, String fname, String lname, long acc_num, Date dob, String address, int pincode,
			String acc_type, double balance, String trans_pwd,long phone_num) {
	
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.acc_num = acc_num;
		this.dob = dob;
		this.address = address;
		this.pincode = pincode;
		this.acc_type = acc_type;
		this.balance = balance;
		this.trans_pwd = trans_pwd;
		this.setPhone_num(phone_num);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTrans_pwd() {
		return trans_pwd;
	}
	public void setTrans_pwd(String trans_pwd) {
		this.trans_pwd = trans_pwd;
	}
	public long getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}
	
	
	
}
