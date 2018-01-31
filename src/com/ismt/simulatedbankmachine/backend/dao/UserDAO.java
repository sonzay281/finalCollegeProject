/**
 * 
 */
package com.ismt.simulatedbankmachine.backend.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ismt.simulatedbankmachine.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public interface UserDAO {
	int closeAccount(User u) throws ClassNotFoundException, SQLException;

	int createAccount(User u) throws ClassNotFoundException, SQLException, IOException;

	List<User> getUserName(User u) throws ClassNotFoundException, SQLException;

	List<User> getAllTransaction(User u) throws ClassNotFoundException, SQLException;

	double balanceInquery(User u) throws ClassNotFoundException, SQLException;

	int updateByAccountNo(User u) throws ClassNotFoundException, SQLException;

	int updateType(User u) throws ClassNotFoundException, SQLException;

	List<User> getAllAccounts() throws ClassNotFoundException, SQLException;

	int balanceTransfer(User u) throws ClassNotFoundException, SQLException;
	
}
