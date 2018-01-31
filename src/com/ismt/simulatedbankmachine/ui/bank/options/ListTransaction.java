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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNo;
	private JTable table;
	private User u = new User();

	public ListTransaction() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setTitle("Transaction List");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(
				new TitledBorder(null, "BANK STATEMENT", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
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

		JLabel label_1 = new JLabel("A/C NO.");
		label_1.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-menu.png")));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 23, 71, 25);
		contentPane.add(label_1);

		txtAccountNo = new JTextField();
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(78, 23, 145, 25);
		contentPane.add(txtAccountNo);

		JLabel label_2 = new JLabel("FROM");
		label_2.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-date-from.png")));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(256, 23, 88, 25);
		contentPane.add(label_2);

		JDateChooser dateChooserStart = new JDateChooser();
		dateChooserStart.setBounds(347, 24, 135, 24);
		contentPane.add(dateChooserStart);

		JButton button_1 = new JButton("CANCEL");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-exit.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(377, 59, 105, 25);
		contentPane.add(button_1);

		JDateChooser dateChooserEnd = new JDateChooser();
		dateChooserEnd.setBounds(78, 59, 145, 25);
		contentPane.add(dateChooserEnd);

		JLabel label_3 = new JLabel("TO");
		label_3.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-date-to.png")));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(10, 59, 58, 25);
		contentPane.add(label_3);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 102));
		separator_1.setBounds(10, 93, 472, 2);
		contentPane.add(separator_1);
		String[] columnNames = { "Date", "Account No.", "Amount", "Status" };
		table = new JTable();
		table.setBounds(133, 119, 1, 1);
		DefaultTableModel tbl = new DefaultTableModel(columnNames, 0);
		table.setModel(tbl);
		UserDAO userDAO = new UserDAOImpl();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 106, 472, 193);
		contentPane.add(scrollPane);
		JButton button = new JButton("BANK STMT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
				try {

					u.setAccount_no(Integer.parseInt(txtAccountNo.getText()));
					u.setFrom_date(dateChooserStart.getDate());
					u.setTo_Date(dateChooserEnd.getDate());
					userDAO.getAllTransaction(u);

					for (User u : userDAO.getAllTransaction(u)) {
						if (u.getAccount_no() == Integer.parseInt(txtAccountNo.getText())) {
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
		button.setIcon(new ImageIcon(ListTransaction.class.getResource("/icons/icons8-list.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(237, 59, 127, 25);
		contentPane.add(button);

	}
}
