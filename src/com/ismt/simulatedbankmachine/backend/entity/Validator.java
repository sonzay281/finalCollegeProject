package com.ismt.simulatedbankmachine.backend.entity;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.ui.bank.BankDashboard;
import com.ismt.simulatedbankmachine.ui.customer.CustomerDashboard;

/**
 * @author ZERO BYTE
 *
 */
public class Validator {
	private User u = new User();
	public void Authentication(String user_name, String type, String password) {
		
		if (!user_name.isEmpty() && !password.isEmpty()) {
			try {
				UserDAO userDAO = new UserDAOImpl();
				System.out.println("Error");
				for (User u : userDAO.getUserName(u)) {
					if (u.getUser_name().equals(user_name) && u.getStatus().equals("Active")
							&& u.getPassword().equals(password)) {
						if (u.getUser_type().equals("CUSTOMER")) {
							int accountno = u.getAccount_no();
							JOptionPane.showMessageDialog(null, "Welcome to NMB Bank  " + user_name);
							new CustomerDashboard(accountno, user_name).setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Welcome to NMB Bank " + user_name + ".");
							new BankDashboard(user_name).setVisible(true);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong.Please try again.");
					}
				}
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please insert the user_name,password and try again.");
		}
	}
}