package com.ismt.simulatedbankmachine.ui.bank.options;

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
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public class CloseAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNo;

	/**
	 * Launch the application.
	 */
	/***
	 * Calling from User Dashboard
	 */

	/**
	 * Create the frame.
	 */
	public CloseAccount() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setTitle("Close Account");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "Account Closing Form", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 102));
		separator.setBounds(15, 303, 469, 2);
		contentPane.add(separator);

		JLabel label = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(15, 316, 472, 14);
		contentPane.add(label);

		JButton button_1 = new JButton("CANCEL");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(CloseAccount.class.getResource("/icons/icons8-exit.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(342, 253, 145, 37);
		contentPane.add(button_1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "TEMPORARY", "PERMANENT" }));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(182, 207, 305, 35);
		contentPane.add(comboBox);

		JLabel lblClosingType = new JLabel("CLOSING TYPE:");
		lblClosingType.setIcon(new ImageIcon(CloseAccount.class.getResource("/icons/icons8-uninstalling-updates.png")));
		lblClosingType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClosingType.setBounds(13, 207, 130, 35);
		contentPane.add(lblClosingType);

		JLabel label_2 = new JLabel("ACCOUNT NUMBER:");
		label_2.setIcon(new ImageIcon(CloseAccount.class.getResource("/icons/icons8-pincode-keyboard-20.png")));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(13, 166, 130, 35);
		contentPane.add(label_2);

		txtAccountNo = new JTextField();
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(182, 166, 305, 35);
		contentPane.add(txtAccountNo);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\NMB1.jpg"));
		label_3.setBounds(10, 21, 475, 120);
		contentPane.add(label_3);

		JButton btnCloseAccount = new JButton("CLOSE ACCOUNT");
		btnCloseAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					int acNo = Integer.parseInt(txtAccountNo.getText());
					u.setAccount_no(acNo);
					u.setStatus("Deactive");
					int updated = userDAO.closeAccount(u);
					if (updated > 0) {
						JOptionPane.showMessageDialog(null, "Account no:" + acNo + "has been closed successfully.");
					} else {
						JOptionPane.showMessageDialog(null,
								"This service is not available at the moment.Please try agian after few hours.");
					}
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnCloseAccount.setIcon(new ImageIcon(CloseAccount.class.getResource("/icons/icons8-cancel.png")));
		btnCloseAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCloseAccount.setBounds(182, 254, 145, 36);
		contentPane.add(btnCloseAccount);

	}

}
