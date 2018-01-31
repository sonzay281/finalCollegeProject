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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;
import com.toedter.calendar.JDateChooser;

/**
 * @author ZERO BYTE
 *
 */
public class ListTransaction extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAOImpl();
	private JPanel contentPane;
	private JTable table;
	private User u = new User();

	/**
	 * Launch the application.
	 */

	/***
	 * 
	 * This class is being called from Customer Dashboard
	 * 
	 */
	/**
	 * Create the frame.
	 */
	public ListTransaction(int accountNo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setTitle("User Statement");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "User Statement", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JButton button_1 = new JButton("CANCEL");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-cancel.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(379, 57, 105, 25);
		contentPane.add(button_1);

		JLabel lblStartDate = new JLabel("FROM");
		lblStartDate.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-date-from.png")));
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStartDate.setBounds(12, 21, 88, 25);
		contentPane.add(lblStartDate);

		JLabel lblEndDate = new JLabel("TO");
		lblEndDate.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-date-to.png")));
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndDate.setBounds(273, 21, 58, 25);
		contentPane.add(lblEndDate);

		JDateChooser dateChooserEnd = new JDateChooser();
		dateChooserEnd.setBounds(341, 21, 145, 25);
		contentPane.add(dateChooserEnd);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 102));
		separator_1.setBounds(12, 93, 472, 2);
		contentPane.add(separator_1);
		String[] columnName = { "Date", "Amount", "Operation" };

		table = new JTable();
		table.setBounds(133, 119, 1, 1);
		DefaultTableModel tbl = new DefaultTableModel(columnName, 0);
		table.setModel(tbl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 106, 472, 193);
		contentPane.add(scrollPane);

		JDateChooser dateChooserStart = new JDateChooser();
		dateChooserStart.setBounds(88, 21, 145, 25);
		contentPane.add(dateChooserStart);
		JButton btnBankStmt = new JButton("BANK STMT");
		btnBankStmt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
				try {
					u.setAccount_no(accountNo);
					u.setFrom_date(dateChooserStart.getDate());
					u.setTo_Date(dateChooserEnd.getDate());
					userDAO.getAllTransaction(u);
					for (User u : userDAO.getAllTransaction(u)) {
						if (u.getAccount_no() == accountNo) {
							tbl.addRow(new Object[] { u.getDate(), u.getAmount(), u.getOperation() });
						} else {
							table.setModel(new DefaultTableModel());
						}
					}
				} catch (ClassNotFoundException | SQLException cs1) {
					System.out.println(cs1.getMessage());
					cs1.printStackTrace();
				}
			}
		});
		btnBankStmt.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-list.png")));
		btnBankStmt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBankStmt.setBounds(246, 57, 120, 25);
		contentPane.add(btnBankStmt);

	}

}
