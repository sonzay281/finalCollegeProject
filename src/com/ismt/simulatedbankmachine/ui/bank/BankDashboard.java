/**
 * 
 */
package com.ismt.simulatedbankmachine.ui.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.ui.Program;
import com.ismt.simulatedbankmachine.ui.bank.options.CloseAccount;
import com.ismt.simulatedbankmachine.ui.bank.options.ListAccounts;
import com.ismt.simulatedbankmachine.ui.bank.options.ListTransaction;
import com.ismt.simulatedbankmachine.ui.bank.options.NewAccount;
import com.ismt.simulatedbankmachine.ui.bank.options.Update;

/**
 * @author ZERO BYTE
 *
 */
public class BankDashboard extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public BankDashboard(String user_name) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setBackground(new Color(0, 153, 153));
		setResizable(false);
		setTitle("User Dashboard");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(480, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "Welcome " + user_name, TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 14), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(10, 290, 454, 2);
		contentPane.add(separator);

		JLabel label = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 296, 454, 14);
		contentPane.add(label);

		JButton btnOpenAccount = new JButton("OPEN ACCOUNT");
		btnOpenAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewAccount().setVisible(true);
			}
		});
		btnOpenAccount.setIcon(new ImageIcon(BankDashboard.class.getResource("/icons/icons8-add-list.png")));
		btnOpenAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOpenAccount.setBounds(10, 199, 135, 35);
		contentPane.add(btnOpenAccount);

		JButton btnUpdateType = new JButton("UPDATE TYPE");
		btnUpdateType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Update().setVisible(true);
			}
		});
		btnUpdateType.setIcon(new ImageIcon(BankDashboard.class.getResource("/icons/icons8-support.png")));
		btnUpdateType.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateType.setBounds(316, 199, 148, 35);
		contentPane.add(btnUpdateType);

		JButton btnCloseAccount = new JButton("CLOSE ACCOUNT");
		btnCloseAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CloseAccount().setVisible(true);
			}
		});
		btnCloseAccount.setIcon(new ImageIcon(BankDashboard.class.getResource("/icons/icons8-close-window.png")));
		btnCloseAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCloseAccount.setBounds(155, 199, 151, 35);
		contentPane.add(btnCloseAccount);

		JButton btnBankStmt = new JButton("BANK STMT");
		btnBankStmt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListTransaction().setVisible(true);
			}
		});
		btnBankStmt.setIcon(new ImageIcon(BankDashboard.class.getResource("/icons/icons8-list.png")));
		btnBankStmt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBankStmt.setBounds(10, 244, 135, 35);
		contentPane.add(btnBankStmt);

		JButton btnAddStaff = new JButton("LIST ACCOUNTS");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ListAccounts().setVisible(true);
			}
		});
		btnAddStaff.setIcon(new ImageIcon(BankDashboard.class.getResource("/icons/icons8-user-menu-male.png")));
		btnAddStaff.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddStaff.setBounds(155, 244, 151, 35);
		contentPane.add(btnAddStaff);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Program().setVisible(true);
			}
		});
		btnLogout.setIcon(new ImageIcon(BankDashboard.class.getResource("/icons/icons8-logout.png")));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBounds(316, 244, 148, 35);
		contentPane.add(btnLogout);

		JPanel panel = new JPanel();
		panel.setBounds(10, 18, 455, 175);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\BankHeader.jpg"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 455, 175);
		panel.add(label_1);
	}
}
