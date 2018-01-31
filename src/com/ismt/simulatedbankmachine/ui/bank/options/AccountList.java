/**
 * 
 */
package com.ismt.simulatedbankmachine.ui.bank.options;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

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

import com.toedter.calendar.JDateChooser;

/**
 * @author ZERO BYTE
 *
 */
public class AccountList extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	/****
	 * 
	 * Calling From User Dashboard
	 */

	/**
	 * Create the frame.
	 */
	public AccountList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setResizable(false);
		setTitle("Account Lists");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(
				new TitledBorder(null, "Account Lists", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccountOpened = new JLabel("ACCOUNT OPENED ");
		lblAccountOpened.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountOpened.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccountOpened.setBounds(10, 22, 474, 22);
		contentPane.add(lblAccountOpened);

		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setIcon(new ImageIcon(AccountList.class.getResource("/icons/icons8-date-from.png")));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(29, 49, 72, 25);
		contentPane.add(lblFrom);

		JLabel lblTo = new JLabel("TO");
		lblTo.setIcon(new ImageIcon(AccountList.class.getResource("/icons/icons8-date-to.png")));
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(295, 49, 54, 25);
		contentPane.add(lblTo);

		JDateChooser dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(97, 49, 130, 25);
		contentPane.add(dateChooserFrom);

		JDateChooser dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(354, 49, 130, 25);
		contentPane.add(dateChooserTo);

		JButton btnList = new JButton("LIST");
		btnList.setIcon(new ImageIcon(AccountList.class.getResource("/icons/icons8-add-list.png")));
		btnList.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnList.setBounds(246, 85, 103, 23);
		contentPane.add(btnList);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setIcon(new ImageIcon(AccountList.class.getResource("/icons/icons8-exit.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(381, 85, 103, 23);
		contentPane.add(btnCancel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 119, 474, 2);
		contentPane.add(separator);

		String[] columnName = { "Opened Date", "Account no.", "Name", "Status" };
		table = new JTable();
		table.setBounds(88, 277, 339, -108);
		DefaultTableModel tbl = new DefaultTableModel(columnName, 0);
		table.setModel(tbl);
		tbl.addRow(new Object[] {});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 129, 474, 169);
		contentPane.add(scrollPane);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 102));
		separator_1.setBounds(12, 303, 469, 2);
		contentPane.add(separator_1);

		JLabel label = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(12, 316, 472, 14);
		contentPane.add(label);
	}
}
