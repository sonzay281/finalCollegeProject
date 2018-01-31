/**
 * 
 */
package com.ismt.simulatedbankmachine.ui.customer;

import java.awt.Color;
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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;
import com.ismt.simulatedbankmachine.ui.Program;
import com.ismt.simulatedbankmachine.ui.customer.options.CloseAccount;
import com.ismt.simulatedbankmachine.ui.customer.options.Deposit;
import com.ismt.simulatedbankmachine.ui.customer.options.ListTransaction;
import com.ismt.simulatedbankmachine.ui.customer.options.Transfer;
import com.ismt.simulatedbankmachine.ui.customer.options.Update;
import com.ismt.simulatedbankmachine.ui.customer.options.Withdraw;

/**
 * @author ZERO BYTE
 *
 */
public class CustomerDashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * This class has been called from Program
	 * 
	 */

	/**
	 * Create the frame.
	 * 
	 * @param account_no
	 */

	public CustomerDashboard(int accountNo, String user_name) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setResizable(false);
		setTitle("Customer Dashboard");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Welcome " + user_name,
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Deposit(accountNo).setVisible(true);
				
			}
		});
		btnDeposit.setIcon(new ImageIcon(CustomerDashboard.class.getResource("/icons/icons8-input.png")));
		btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeposit.setBounds(12, 199, 145, 45);
		contentPane.add(btnDeposit);

		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.setIcon(new ImageIcon(CustomerDashboard.class.getResource("/icons/icons8-withdrawal.png")));
		btnWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Withdraw(accountNo).setVisible(true);
				
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWithdraw.setBounds(177, 198, 145, 45);
		contentPane.add(btnWithdraw);

		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.setIcon(new ImageIcon(CustomerDashboard.class.getResource("/icons/icons8-data-transfer.png")));
		btnTransfer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Transfer(accountNo).setVisible(true);
				
			}
		});
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTransfer.setBounds(338, 199, 145, 44);
		contentPane.add(btnTransfer);

		JButton btnCheckBalance = new JButton("CHECK BALANCE");
		btnCheckBalance.setIcon(new ImageIcon(CustomerDashboard.class.getResource("/icons/icons8-inquiry.png")));
		btnCheckBalance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					u.setAccount_no(accountNo);

					userDAO.balanceInquery(u);

					JOptionPane.showMessageDialog(CustomerDashboard.this,
							"Your Total Balance is " + u.getAmount() + " in account no.:" + accountNo);

				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheckBalance.setBounds(12, 253, 145, 45);
		contentPane.add(btnCheckBalance);

		JButton btnListTransactions = new JButton("BANK STMT");
		btnListTransactions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListTransaction(accountNo).setVisible(true);
				
			}
		});
		btnListTransactions.setIcon(new ImageIcon(CustomerDashboard.class.getResource("/icons/icons8-list.png")));
		btnListTransactions.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListTransactions.setBounds(177, 253, 145, 45);
		contentPane.add(btnListTransactions);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setIcon(new ImageIcon(CustomerDashboard.class.getResource("/icons/icons8-logout.png")));
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Program().setVisible(true);

			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(338, 253, 145, 45);
		contentPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(12, 304, 470, 2);
		contentPane.add(separator);

		JLabel label = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(12, 316, 470, 14);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBounds(12, 24, 470, 168);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox<String> moreCombo = new JComboBox<String>();
		moreCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (moreCombo.getSelectedItem().equals("REQUEST AC CLOSE")) {
					new CloseAccount(accountNo).setVisible(true);
				} else if (moreCombo.getSelectedItem().equals("REQUEST CHANGE TYPE")) {
					new Update(accountNo).setVisible(true);
				}
				
			}
		});
		moreCombo.setBackground(Color.LIGHT_GRAY);
		moreCombo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "---MORE OPTIONS---", "REQUEST CHANGE TYPE", "REQUEST AC CLOSE" }));
		moreCombo.setFont(new Font("Tahoma", Font.BOLD, 13));
		moreCombo.setBounds(313, 148, 157, 22);
		panel.add(moreCombo);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\MainNMBsmall.jpg"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 470, 170);
		panel.add(label_1);

	}
}
