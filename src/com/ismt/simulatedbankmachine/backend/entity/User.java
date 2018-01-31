
package com.ismt.simulatedbankmachine.backend.entity;

import java.util.Date;

/**
 * @author ZERO BYTE
 *
 */
public class User {
	private String user_name, phone, user_type, password, image_url, branch_name, account_type, c_name, gender, address,
			email, status, operation,uname;
	private double amount, old_amount;
	private int account_no,temp_ac;
	private Date opened_date, dob, date, from_date, to_Date;
/**
 * 
 */
public User() {
	// TODO Auto-generated constructor stub
}
	/**
	 * @param user_name
	 * @param phone
	 * @param user_type
	 * @param password
	 * @param image_url
	 * @param branch_name
	 * @param account_type
	 * @param c_name
	 * @param gender
	 * @param address
	 * @param email
	 * @param status
	 * @param operation
	 * @param uname
	 * @param amount
	 * @param old_amount
	 * @param account_no
	 * @param temp_ac
	 */
	public User(String user_name, String phone, String user_type, String password, String image_url, String branch_name,
			String account_type, String c_name, String gender, String address, String email, String status,
			String operation, String uname, double amount, double old_amount, int account_no, int temp_ac) {
		super();
		this.user_name = user_name;
		this.phone = phone;
		this.user_type = user_type;
		this.password = password;
		this.image_url = image_url;
		this.branch_name = branch_name;
		this.account_type = account_type;
		this.c_name = c_name;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.status = status;
		this.operation = operation;
		this.uname = uname;
		this.amount = amount;
		this.old_amount = old_amount;
		this.account_no = account_no;
		this.temp_ac = temp_ac;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getAmount() {
		return amount;
	}
	public double setAmount(double amount) {
		return this.amount = amount;
	}
	public double getOld_amount() {
		return old_amount;
	}
	public void setOld_amount(double old_amount) {
		this.old_amount = old_amount;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getTemp_ac() {
		return temp_ac;
	}
	public void setTemp_ac(int temp_ac) {
		this.temp_ac = temp_ac;
	}
	public Date getOpened_date() {
		return opened_date;
	}
	public void setOpened_date(Date opened_date) {
		this.opened_date = opened_date;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_Date() {
		return to_Date;
	}
	public void setTo_Date(Date to_Date) {
		this.to_Date = to_Date;
	}

}