/**
 * 
 */
package com.ismt.simulatedbankmachine.backend.daoImpl;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.dbutils.DBConnection;
import com.ismt.simulatedbankmachine.backend.dbutils.SQLConstant;
import com.ismt.simulatedbankmachine.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public class UserDAOImpl implements UserDAO {
	private DBConnection db = new DBConnection();
	private ResultSet rs = null;
	private PreparedStatement stmt = null;

	@Override
	public int closeAccount(User u) throws ClassNotFoundException, SQLException {
		db.connect();
		stmt = db.initStatement(SQLConstant.TEMPCLOSEACCOUNT);
		stmt.setString(1, u.getStatus());
		stmt.setInt(2, u.getAccount_no());
		int closed = 0;
		closed = db.update();
		db.close();

		return closed;
	}

	@Override
	public int createAccount(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		stmt = db.initStatement(SQLConstant.ADDCUSTOMERDETAILS);
		stmt.setString(1, u.getC_name());
		stmt.setDate(2, new java.sql.Date(u.getDob().getTime()));
		stmt.setString(3, u.getGender());
		db.update();
		int accountNo = db.getInsertId();

		stmt = db.initStatement(SQLConstant.ADDRESOURCES);
		stmt.setInt(1, accountNo);
		stmt.setString(2, u.getImage_url());
		db.update();

		stmt = db.initStatement(SQLConstant.ADDACCOUNTDETAIL);
		stmt.setInt(1, accountNo);
		java.sql.Date date = new java.sql.Date(u.getOpened_date().getTime());
		stmt.setDate(2, date);
		stmt.setString(3, u.getBranch_name());
		stmt.setString(4, u.getAccount_type());
		db.update();

		stmt = db.initStatement(SQLConstant.ADDCONTACT);
		stmt.setInt(1, accountNo);
		stmt.setString(2, u.getPhone());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getAddress());
		db.update();

		stmt = db.initStatement(SQLConstant.ADDAMOUNT);
		stmt.setInt(1, accountNo);
		stmt.setDouble(2, u.getAmount());
		db.update();

		stmt = db.initStatement(SQLConstant.INSERTUSER);
		stmt.setInt(1, accountNo);
		stmt.setString(2, u.getUser_name());
		stmt.setString(3, u.getPassword());
		stmt.setString(4, u.getUser_type());
		db.update();

		stmt = db.initStatement(SQLConstant.ADDTRANSACTION);
		stmt.setDate(1, date);
		stmt.setInt(2, accountNo);
		stmt.setDouble(3, u.getAmount());
		stmt.setString(4, "CREDITED");
		int saved = db.update();
		db.close();
		return saved;

	}

	@Override
	public int updateByAccountNo(User u) throws ClassNotFoundException, SQLException {
		double oldAmt = 0;
		double changeAmt = u.getAmount();
		int saved = 0;
		double newAmt = 0;
		db.connect();
		stmt = db.initStatement(SQLConstant.GETAMOUNTBYACCOUNTNO);
		stmt.setInt(1, u.getAccount_no());
		ResultSet rs = db.query();
		while (rs.next()) {
			oldAmt = u.setAmount(rs.getDouble("amount"));
		}
		u.setOld_amount(oldAmt);
		if (u.getStatus().equals("CREDITED")) {
			newAmt = changeAmt + oldAmt;
			stmt = db.initStatement(SQLConstant.UPDATEAMOUNT);
			stmt.setDouble(1, newAmt);
			stmt.setInt(2, u.getAccount_no());
			u.setAmount(newAmt);
			saved = db.update();

			stmt = db.initStatement(SQLConstant.ADDTRANSACTION);
			stmt.setDate(1, new java.sql.Date(u.getDate().getTime()));
			stmt.setInt(2, u.getAccount_no());
			stmt.setDouble(3, changeAmt);
			stmt.setString(4, "CREDITED");

			saved = db.update();
		} else if (oldAmt >= changeAmt) {
			newAmt = oldAmt - changeAmt;
			stmt = db.initStatement(SQLConstant.UPDATEAMOUNT);
			stmt.setDouble(1, newAmt);
			stmt.setInt(2, u.getAccount_no());
			u.setAmount(newAmt);
			saved = db.update();

			stmt = db.initStatement(SQLConstant.ADDTRANSACTION);
			stmt.setDate(1, new Date(u.getDate().getTime()));
			stmt.setInt(2, u.getAccount_no());
			stmt.setDouble(3, changeAmt);
			stmt.setString(4, "DEBITED");
			saved = db.update();
		} else {
			saved = 0;
		}
		db.close();
		return saved;
	}

	@Override
	public List<User> getAllTransaction(User u) throws ClassNotFoundException, SQLException {
		List<User> transList = new ArrayList<>();
		db.connect();

		try {

			PreparedStatement stmt = db.initStatement(SQLConstant.GETALLTRANSACTION);
			stmt.setInt(1, u.getAccount_no());
			stmt.setDate(2, new java.sql.Date(u.getFrom_date().getTime()));
			stmt.setDate(3, new java.sql.Date(u.getTo_Date().getTime()));
			rs = db.query();
			while (rs.next()) {
				User a = new User();
				a.setAccount_no(rs.getInt("account_no"));
				a.setDate(rs.getDate("date"));
				a.setAmount(rs.getDouble("amount"));
				a.setOperation(rs.getString("operation"));
				transList.add(a);
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		db.close();
		return transList;
	}

	@Override
	public double balanceInquery(User u) throws ClassNotFoundException, SQLException {
		db.connect();
		double total_amount = 0;
		try {
			stmt = db.initStatement(SQLConstant.GETAMOUNTBYACCOUNTNO);
			stmt.setInt(1, u.getAccount_no());
			rs = db.query();
			while (rs.next()) {
				total_amount = u.setAmount(rs.getDouble("amount"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		db.close();
		return total_amount;

	}

	@Override
	public int updateType(User u) throws ClassNotFoundException, SQLException {
		db.connect();
		stmt = db.initStatement(SQLConstant.UPDATETYPE);
		stmt.setString(1, u.getAccount_type());
		stmt.setInt(2, u.getAccount_no());
		int updated = db.update();
		db.close();
		return updated;
	}

	@Override
	public List<User> getAllAccounts() throws ClassNotFoundException, SQLException {
		List<User> accountList = new ArrayList<>();
		db.connect();
		stmt = db.initStatement(SQLConstant.GETALLACCOUNTS);
		rs = db.query();
		while (rs.next()) {
			User u = new User();
			u.setAccount_no(rs.getInt("account_no"));
			u.setC_name(rs.getString("c_name"));
			u.setGender(rs.getString("gender"));
			u.setAccount_type(rs.getString("account_type"));
			u.setOpened_date(rs.getDate("opened_date"));
			u.setPhone(rs.getString("phone"));
			u.setStatus(rs.getString("status"));
			accountList.add(u);
		}
		db.close();
		return accountList;
	}

	@Override
	public int balanceTransfer(User u) throws ClassNotFoundException, SQLException {
		double newAmt = 0;
		int saved = 0;
		double changeAmt = u.getAmount();
		db.connect();

		// get Amount from first account
		stmt = db.initStatement(SQLConstant.GETAMOUNTBYACCOUNTNO);
		stmt.setInt(1, u.getAccount_no());
		rs = db.query();
		System.out.println(u.getAccount_no());
		while (rs.next()) {
			double oldAmt = u.setAmount(rs.getDouble("amount"));
			u.setOld_amount(oldAmt);
		}
		if (u.getOld_amount() >= changeAmt) {

			newAmt = u.getOld_amount() - changeAmt;
			stmt = db.initStatement(SQLConstant.UPDATEAMOUNT);
			System.out.println(u.getAccount_no());
			stmt.setDouble(1, newAmt);
			stmt.setInt(2, u.getAccount_no());
			System.out.println(u.getAccount_no());
			u.setAmount(newAmt);
			db.update();

			stmt = db.initStatement(SQLConstant.ADDTRANSACTION);
			stmt.setDate(1, new java.sql.Date(u.getDate().getTime()));
			stmt.setInt(2, u.getAccount_no());
			stmt.setDouble(3, changeAmt);
			stmt.setString(4, "DEBITED");
			saved = db.update();
		}

		stmt = db.initStatement(SQLConstant.GETAMOUNTBYACCOUNTNO);
		stmt.setInt(1, u.getTemp_ac());
		rs = db.query();
		while (rs.next()) {
			u.setAmount(rs.getDouble("amount"));
		}
		newAmt = changeAmt + u.getAmount();
		stmt = db.initStatement(SQLConstant.UPDATEAMOUNT);
		stmt.setDouble(1, newAmt);
		stmt.setInt(2, u.getTemp_ac());
		u.setAmount(newAmt);
		db.update();

		stmt = db.initStatement(SQLConstant.ADDTRANSACTION);
		stmt.setDate(1, new Date(u.getDate().getTime()));
		stmt.setInt(2, u.getTemp_ac());
		stmt.setDouble(3, changeAmt);
		stmt.setString(4, "CREDITED");

		saved = db.update();

		db.close();
		return saved;
	}

	@Override
	public List<User> getUserName(User u) throws ClassNotFoundException, SQLException {
		List<User> usrList = new ArrayList<>();

		db.connect();
		PreparedStatement stmt = db.initStatement(SQLConstant.GETUSERNAMES);
		stmt.setString(1, u.getUser_name());
		stmt.setString(2, u.getPassword());

		ResultSet rs = db.query();
		while (rs.next()) {
			u.setUser_name(rs.getString("user_name"));
			u.setPassword(rs.getString("password"));
			u.setUser_type(rs.getString("user_type"));
			u.setAccount_no(rs.getInt("account_no"));
			u.setStatus(rs.getString("status"));
			usrList.add(u);

		}
		db.close();
		return usrList;
	}
}
