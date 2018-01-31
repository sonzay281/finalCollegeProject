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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public class Update extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account_no;

	/**
	 * Launch the application.
	 */
	/***
	 * 
	 * 
	 * Calling from User Dashboard
	 */

	/**
	 * Create the frame.
	 */
	public Update(int accountNo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setResizable(false);
		setTitle("Update Account Type");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Update Account Type",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
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
		button_1.setIcon(new ImageIcon(Update.class.getResource("/icons/icons8-exit.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(339, 262, 145, 37);
		contentPane.add(button_1);

		account_no = new JTextField();
		account_no.setEditable(false);
		account_no.setColumns(10);
		account_no.setBounds(179, 166, 305, 35);
		account_no.setText(String.valueOf(accountNo));
		contentPane.add(account_no);

		JLabel label_1 = new JLabel("ACCOUNT NUMBER:");
		label_1.setIcon(new ImageIcon(Update.class.getResource("/icons/icons8-pincode-keyboard-20.png")));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 166, 130, 35);
		contentPane.add(label_1);

		JLabel lblAmountType = new JLabel("ACCOUNT TYPE");
		lblAmountType.setIcon(new ImageIcon(Update.class.getResource("/icons/icons8-briefcase.png")));
		lblAmountType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmountType.setBounds(10, 207, 130, 35);
		contentPane.add(lblAmountType);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CURRENT", "SAVING" }));
		comboBox.setBounds(179, 207, 305, 35);
		contentPane.add(comboBox);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(9, 25, 475, 130);
		contentPane.add(panel);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\NMB1.jpg"));
		label_2.setBounds(0, 0, 475, 130);
		panel.add(label_2);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(comboBox.getSelectedItem());
					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					u.setAccount_no(accountNo);
					u.setAccount_type((String) comboBox.getSelectedItem());
					int updated = (int) userDAO.updateType(u);
					if (updated != 0) {
						JOptionPane.showMessageDialog(null,
								"Account no:" + accountNo + "has been updated successfully.");
					} else {
						JOptionPane.showMessageDialog(null,
								"This service is not available at the moment.Please try agian after few hours.");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(Update.class.getResource("/icons/icons8-support.png")));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(179, 263, 145, 36);
		contentPane.add(btnUpdate);

	}
}
