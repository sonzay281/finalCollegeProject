/**
 * 
 */
package com.ismt.simulatedbankmachine.ui.bank.options;

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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public class ListAccounts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public ListAccounts() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setTitle("Transaction List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ACCOUNT LIST",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(255, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(10, 310, 472, 2);
		contentPane.add(separator);

		JLabel label = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 316, 472, 14);
		contentPane.add(label);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDashboard.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-exit.png")));
		btnDashboard.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDashboard.setBounds(347, 11, 135, 25);
		contentPane.add(btnDashboard);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 102));
		separator_1.setBounds(10, 47, 472, 2);
		contentPane.add(separator_1);
		String[] columnNames = { "AC NO", "NAME", "GENDER", "PHONE", "TYPE", "OPENED DATE", "STATUS" };
		table = new JTable();
		table.setBounds(133, 119, 1, 1);
		DefaultTableModel tbl = new DefaultTableModel(columnNames, 0);
		table.setModel(tbl);
		UserDAO userDAO = new UserDAOImpl();
		try {
			for (User u : userDAO.getAllAccounts()) {
				tbl.addRow(new Object[] { u.getAccount_no(), u.getC_name(), u.getGender(), u.getPhone(),
						u.getAccount_type(), u.getOpened_date(), u.getStatus() });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 60, 472, 239);
		contentPane.add(scrollPane);
	}
}
