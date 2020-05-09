package pojopack;

import java.util.Date;

public class Transaction {
private int trans_id;
private long acc_num;
private String fname;
private String lname;
private String trans_type;
private double trans_amt;
private Date date_time;
	public Transaction() {
	
}
	public Transaction(int trans_id, long acc_num, String fname, String lname, String trans_type, double trans_amt,
			Date date_time) {
		super();
		this.trans_id = trans_id;
		this.acc_num = acc_num;
		this.fname = fname;
		this.lname = lname;
		this.trans_type = trans_type;
		this.trans_amt = trans_amt;
		this.date_time = date_time;
	}
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id++;
	}
	public long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
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
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public double getTrans_amt() {
		return trans_amt;
	}
	public void setTrans_amt(double trans_amt) {
		this.trans_amt = trans_amt;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", acc_num=" + acc_num + ", fname=" + fname + ", lname=" + lname
				+ ", trans_type=" + trans_type + ", trans_amt=" + trans_amt + ", date_time=" + date_time + "]";
	}


	
}
