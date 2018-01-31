/**
 * 
 */
package com.ismt.simulatedbankmachine.backend.dbutils;

/**
 * @author ZERO BYTE
 *
 */
public class SQLConstant {

	/*
	 * The following query is to get all user name,password,account_no,user_type
	 * from tbl_login
	 */
	public static final String GETUSERNAMES = "SELECT tl.user_name,tl.user_type,"
			+ "tl.password,tl.account_no,tc.status FROM " + TableConstant.LOGIN_TABLE + " tl JOIN "
			+ TableConstant.CUSTOMER_TABLE + " tc ON tl.account_no=tc.account_no where user_name=? and password=?";

	public static final String ADDACCOUNTDETAIL = "INSERT INTO " + TableConstant.ACCOUNT_DETAIL
			+ "(account_no,opened_date,branch_name,account_type) VALUES(?,?,?,?)";

	public static final String ADDCUSTOMERDETAILS = "INSERT INTO " + TableConstant.CUSTOMER_TABLE
			+ "(c_name,dob,gender) VALUES(?,?,?)";

	public static final String ADDCONTACT = "INSERT INTO " + TableConstant.CONTACT_TABLE
			+ "(account_no,phone,email,address) VALUES(?,?,?,?)";

	public static final String ADDRESOURCES = "INSERT INTO " + TableConstant.RESOURCES_TABLE
			+ "(account_no,img_url) VALUES(?,?)";

	public static final String ADDAMOUNT = "INSERT INTO " + TableConstant.AMOUNT_TABLE
			+ "(account_no,amount) VALUES(?,?)";

	public static final String ADDTRANSACTION = "INSERT INTO " + TableConstant.TRANSACTION_TABLE
			+ "(date,account_no,amount,operation) VALUES(?,?,?,?)";

	public static final String BALANCECHECK = "SELECT amount FROM " + TableConstant.AMOUNT_TABLE
			+ " WHERE account_no=?";

	public static final String TEMPCLOSEACCOUNT = "UPDATE " + TableConstant.CUSTOMER_TABLE
			+ " SET status=? WHERE account_no=?";

	public static final String UPDATETYPE = "UPDATE " + TableConstant.ACCOUNT_DETAIL
			+ " SET account_type=? WHERE account_no=?";

	public static final String GETALLTRANSACTION = "SELECT * FROM " + TableConstant.TRANSACTION_TABLE
			+ " WHERE account_no=? && date BETWEEN ? AND ? ";

	public static final String GETAMOUNTLIST = "SELECT * FROM " + TableConstant.AMOUNT_TABLE;

	public static final String GETAMOUNTBYACCOUNTNO = "SELECT amount FROM " + TableConstant.AMOUNT_TABLE
			+ " WHERE account_no=?";

	public static final String UPDATEAMOUNT = "UPDATE " + TableConstant.AMOUNT_TABLE
			+ " SET amount=? WHERE account_no=?";

	public static final String INSERTUSER = "INSERT INTO " + TableConstant.LOGIN_TABLE
			+ "(account_no,user_name,password,user_type) VALUES(?,?,?,?)";

	public static final String GETCUSTOMERBYUNAME = "SELECT * FROM " + TableConstant.CUSTOMER_TABLE
			+ "WHERE user_name=?";

	public static final String GETALLACCOUNTS = "SELECT tc.account_no,c_name,gender,phone,account_type,opened_date,status FROM "
			+ TableConstant.CUSTOMER_TABLE + " tc join " + TableConstant.ACCOUNT_DETAIL
			+ " tad on tc.account_no=tad.account_no join " + TableConstant.CONTACT_TABLE
			+ " tco on tc.account_no=tco.account_no join " + TableConstant.LOGIN_TABLE
			+ " tl on tc.account_no=tl.account_no where user_type='CUSTOMER'";

}
