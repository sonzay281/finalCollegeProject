/**
 * 
 */
package com.ismt.simulatedbankmachine.ui.customer.options;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public class Deposit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNo;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	/***
	 * 
	 * This class will be call from CustomerDashboard
	 * 
	 * 
	 */

	/**
	 * Create the frame.
	 */
	public Deposit(int accountNo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setResizable(false);
		setTitle("Deposit Amount");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "Account Deposit Form", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccountNumber = new JLabel("ACCOUNT NUMBER:");
		lblAccountNumber.setIcon(new ImageIcon(Deposit.class.getResource("/icons/icons8-pincode-keyboard-20.png")));
		lblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccountNumber.setBounds(10, 166, 145, 35);
		contentPane.add(lblAccountNumber);

		JLabel lblAmount = new JLabel("AMOUNT:");
		lblAmount.setIcon(new ImageIcon(Deposit.class.getResource("/icons/icons8-paper-money.png")));
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount.setBounds(10, 207, 130, 35);
		contentPane.add(lblAmount);

		txtAccountNo = new JTextField();
		txtAccountNo.setText(String.valueOf(accountNo));
		txtAccountNo.setEditable(false);
		txtAccountNo.setBounds(179, 166, 305, 35);
		contentPane.add(txtAccountNo);
		txtAccountNo.setColumns(10);

		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(179, 207, 305, 35);
		contentPane.add(txtAmount);

		JButton btnDeposit = new JButton("DEPOSITE");
		btnDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					u.setAccount_no(accountNo);
					u.setAmount(Double.parseDouble(txtAmount.getText()));
					u.setStatus("CREDITED");
					u.setDate(new Date());
					int saved = (int) userDAO.updateByAccountNo(u);
					if (saved > 0) {
						JOptionPane.showMessageDialog(null, Double.parseDouble(txtAmount.getText())
								+ " successfully deposited to your account.Your new balance is:" + u.getAmount());
					} else {
						JOptionPane.showMessageDialog(null, "Amount could not be deposited.Please try again.");
					}
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
		btnDeposit.setIcon(new ImageIcon(Deposit.class.getResource("/icons/icons8-input.png")));
		btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeposit.setBounds(179, 254, 145, 45);
		contentPane.add(btnDeposit);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Deposit.class.getResource("/icons/icons8-exit.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(339, 253, 145, 45);
		contentPane.add(btnCancel);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(12, 310, 472, 2);
		contentPane.add(separator);

		JLabel label = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(12, 316, 472, 14);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 475, 130);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\deposit.jpg"));
		label_1.setBounds(0, 0, 475, 130);
		panel.add(label_1);
	}
}
