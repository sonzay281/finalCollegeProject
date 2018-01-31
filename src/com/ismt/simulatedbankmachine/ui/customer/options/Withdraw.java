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
public class Withdraw extends JFrame {
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
	 * This class will be called from CustomerDashboard
	 * 
	 */

	/**
	 * Create the frame.
	 */
	public Withdraw(int account_no) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setResizable(false);
		setBackground(new Color(0, 153, 153));
		setTitle("Withdraw Amount");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "Withdraw Amount", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("ACCOUNT NUMBER:");
		label.setIcon(new ImageIcon(Withdraw.class.getResource("/icons/icons8-pincode-keyboard-20.png")));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 169, 130, 35);
		contentPane.add(label);

		JLabel label_1 = new JLabel("AMOUNT:");
		label_1.setIcon(new ImageIcon(Withdraw.class.getResource("/icons/icons8-paper-money.png")));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 215, 130, 35);
		contentPane.add(label_1);

		txtAccountNo = new JTextField();
		txtAccountNo.setEditable(false);
		txtAccountNo.setText(String.valueOf(account_no));
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(180, 169, 305, 35);
		contentPane.add(txtAccountNo);

		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(180, 215, 305, 35);
		contentPane.add(txtAmount);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Withdraw.class.getResource("/icons/icons8-exit.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(340, 261, 145, 45);
		contentPane.add(btnCancel);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(10, 311, 475, 2);
		contentPane.add(separator);

		JLabel label_2 = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 0, 51));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 316, 475, 14);
		contentPane.add(label_2);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 25, 475, 130);
		contentPane.add(panel);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\deposit.jpg"));
		label_3.setBounds(0, 0, 475, 130);
		panel.add(label_3);

		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					u.setAccount_no(account_no);
					u.setDate(new Date());
					System.out.println(u.getAmount());

					u.setAmount(Double.parseDouble(txtAmount.getText()));
					u.setStatus("DEBITED");
					int saved = (int) userDAO.updateByAccountNo(u);
					if (saved > 0) {
						JOptionPane.showMessageDialog(null, Double.parseDouble(txtAmount.getText())
								+ " successfully withdrawn from your account.Your new balance is:" + u.getAmount());

					} else {
						JOptionPane.showMessageDialog(null, "You do not have enough balance to withdraw.");
					}
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnWithdraw.setIcon(new ImageIcon(Withdraw.class.getResource("/icons/icons8-withdrawal.png")));
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWithdraw.setBounds(180, 262, 145, 45);
		contentPane.add(btnWithdraw);
	}
}
