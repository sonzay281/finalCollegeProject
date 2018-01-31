/**
 * 
 */
package com.ismt.simulatedbankmachine.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;
import com.ismt.simulatedbankmachine.ui.bank.BankDashboard;
import com.ismt.simulatedbankmachine.ui.customer.CustomerDashboard;

/**
 * @author ZERO BYTE
 *
 */
public class Program extends JFrame {
	User u = new User();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Program frame = new Program();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JTextField txtPin;
	private JPasswordField txtPassword;

	/**
	 * Create the frame.
	 */
	public Program() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setResizable(false);
		setTitle("Login Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Welcome to NMB User Ltd.",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13), Color.WHITE));

		JLabel lblPin = new JLabel("User Name:");
		lblPin.setIcon(new ImageIcon(Program.class.getResource("/icons/icons8-pincode-keyboard-20.png")));
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPin.setBounds(10, 164, 97, 30);
		contentPane.add(lblPin);

		txtPin = new JTextField();
		txtPin.setBounds(117, 164, 110, 30);
		contentPane.add(txtPin);
		txtPin.setColumns(10);

		JLabel lblUserType = new JLabel("USER TYPE:");
		lblUserType.setIcon(new ImageIcon(Program.class.getResource("/icons/icons8-contacts.png")));
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserType.setBounds(252, 165, 110, 30);
		contentPane.add(lblUserType);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CUSTOMER", "BANK" }));
		comboBox.setBounds(372, 165, 110, 30);
		contentPane.add(comboBox);

		JLabel label = new JLabel("PASSWORD:");
		label.setIcon(new ImageIcon(Program.class.getResource("/icons/icons8-privacy.png")));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 205, 110, 30);
		contentPane.add(label);

		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setBounds(117, 205, 110, 30);
		contentPane.add(txtPassword);

		JButton btnCancel = new JButton("EXIT");
		btnCancel.setIcon(new ImageIcon(Program.class.getResource("/icons/icons8-delete.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(372, 256, 110, 36);
		contentPane.add(btnCancel);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(10, 310, 472, 2);
		contentPane.add(separator);

		JLabel lblCopyrights = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		lblCopyrights.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyrights.setForeground(new Color(0, 0, 51));
		lblCopyrights.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCopyrights.setBounds(10, 316, 472, 14);
		contentPane.add(lblCopyrights);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(10, 23, 474, 130);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\LogonHeader.jpg"));
		label_1.setBounds(0, 0, 475, 130);
		label_1.setBackground(new Color(240, 240, 240));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					UserDAO userDAO = new UserDAOImpl();
					String user_name = txtPin.getText();
					u.setUser_name(txtPin.getText());
					String password = String.valueOf(txtPassword.getPassword());
					u.setPassword(String.valueOf(txtPassword.getPassword()));
					userDAO.getUserName(u);
					if (!user_name.isEmpty() && !password.isEmpty()) {
						System.out.println("Passed.");
						for (User u : userDAO.getUserName(u)) {
							if (u.getStatus().equals("Active")) {

								if (u.getUser_name().equals(user_name) && u.getPassword().equals(password)) {
									System.out.println(u.getUser_type());
									if (u.getUser_type().equals("CUSTOMER")
											&& comboBox.getSelectedItem().equals("CUSTOMER")) {
										int accountno = u.getAccount_no();
										JOptionPane.showMessageDialog(null, "Welcome to NMB Bank  " + user_name);
										new CustomerDashboard(accountno, user_name).setVisible(true);
										dispose();
									} else {
										JOptionPane.showMessageDialog(null, "Welcome to NMB Bank " + user_name + ".");
										new BankDashboard(user_name).setVisible(true);
										dispose();
									}

								} else {
									JOptionPane.showMessageDialog(null,
											"Something went wrong.Please check your username,password and try again.");
								}
							} else {
								JOptionPane.showMessageDialog(null, "This account is not active. ");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Please insert the user_name,password and try again.");
					}

					// for (User u : userDAO.getUserName(u)) {
					// int accountNo = u.getAccount_no();
					// if (u.getStatus().equals("Active")) {
					// if (u.getUser_name().equals(txtPin.getText())
					// &&
					// u.getPassword().equals(String.valueOf(txtPassword.getPassword())))
					// {
					// if (u.getAccount_type().equals((String)
					// comboBox.getSelectedItem())) {
					// System.out.println(u.getPassword());
					// System.out.println(u.getUser_name());
					// System.out.println(u.getAccount_type());
					// if (u.getAccount_type().equals("BANK")) {
					// BankDashboard bnk = new BankDashboard(user_name);
					// dispose();
					// bnk.setVisible(true);
					//
					// } else {
					// CustomerDashboard cst = new CustomerDashboard(accountNo,
					// user_name);
					// dispose();
					// cst.setVisible(true);
					//
					// }
					// } else {
					// JOptionPane.showMessageDialog(null, "Usertype
					// mismatched.Please try again.");
					// }
					// } else {
					// JOptionPane.showMessageDialog(null, "Username or password
					// not matched.");
					// dispose();
					// }
					// } else {
					// JOptionPane.showMessageDialog(null,
					// "Your account is not active anymore.Please contact to
					// nearest branch.");
					// }}

				} catch (SQLException | ClassNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnLogin.setIcon(new ImageIcon(Program.class.getResource("/icons/icons8-login.png")));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(252, 256, 110, 36);
		contentPane.add(btnLogin);
	}
}
