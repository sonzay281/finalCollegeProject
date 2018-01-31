/**
 * 
 */
package com.ismt.simulatedbankmachine.ui.bank.options;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.ismt.simulatedbankmachine.backend.dao.UserDAO;
import com.ismt.simulatedbankmachine.backend.daoImpl.UserDAOImpl;
import com.ismt.simulatedbankmachine.backend.entity.User;
import com.toedter.calendar.JDateChooser;

/**
 * @author ZERO BYTE
 *
 */
public class NewAccount extends JFrame {
	private static final String imageUploadPath = "J:/Programming/Java/FASimulatedBankMachine/uploads/";
	private static final long serialVersionUID = 1L;
	File file;
	private JPanel contentPane;
	private JTextField txtBranch;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField name;
	private JTextField txtMinBalance;
	User u = new User();
	UserDAO userDao = new UserDAOImpl();
	BufferedImage bi;
	RenderedImage im;
	String gender;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public NewAccount() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setTitle("Account Opening Form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "Account Opening Form", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 14), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(379, 11, 105, 125);
		contentPane.add(panel);

		JLabel picLbl = new JLabel("Choose Photo");
		picLbl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser picChooser = new JFileChooser();
				if (picChooser.showOpenDialog(picLbl) == JFileChooser.APPROVE_OPTION) {
					file = picChooser.getSelectedFile();
					ImageIcon icon = new ImageIcon(picChooser.getSelectedFile().getPath());
					Image img = icon.getImage().getScaledInstance(105, 125, Image.SCALE_SMOOTH);
					picLbl.setIcon(new ImageIcon(img));
				}

			}
		});
		picLbl.setHorizontalAlignment(SwingConstants.CENTER);
		picLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		picLbl.setBounds(0, 0, 105, 125);
		panel.add(picLbl);

		JLabel lblBranchName = new JLabel("BRANCH NAME");
		lblBranchName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBranchName.setBounds(10, 69, 90, 25);
		contentPane.add(lblBranchName);

		txtBranch = new JTextField();
		txtBranch.setBounds(111, 69, 260, 25);
		contentPane.add(txtBranch);
		txtBranch.setColumns(10);

		JLabel lblDate = new JLabel("DATE:");
		lblDate.setIcon(new ImageIcon(NewAccount.class.getResource("/icons/icons8-date-from.png")));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 30, 90, 25);
		contentPane.add(lblDate);

		JLabel lblDateOfBirth = new JLabel("DOB");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfBirth.setBounds(10, 223, 90, 25);
		contentPane.add(lblDateOfBirth);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(111, 259, 373, 25);
		contentPane.add(txtPhone);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhone.setBounds(10, 259, 90, 25);
		contentPane.add(lblPhone);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(111, 295, 373, 25);
		contentPane.add(txtAddress);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(10, 295, 90, 25);
		contentPane.add(lblAddress);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(111, 331, 373, 25);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 331, 90, 25);
		contentPane.add(lblEmail);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(111, 187, 373, 25);
		contentPane.add(name);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 187, 90, 25);
		contentPane.add(lblName);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 147, 474, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 102));
		separator_1.setBounds(10, 440, 474, 2);
		contentPane.add(separator_1);

		JLabel label_4 = new JLabel("COPYRIGHTS 2018  || SANJAYA SAPKOTA  || ISMT COLLEGE");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 0, 51));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(10, 446, 474, 14);
		contentPane.add(label_4);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 174, 474, 2);
		contentPane.add(separator_2);

		JLabel lblApplicantsDetails = new JLabel("APPLICANT'S DETAILS");
		lblApplicantsDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApplicantsDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicantsDetails.setBounds(10, 147, 474, 29);
		contentPane.add(lblApplicantsDetails);

		JLabel lblAccountType = new JLabel("ACCOUNT TYPE");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccountType.setBounds(8, 111, 90, 25);
		contentPane.add(lblAccountType);

		JLabel lblMinBal = new JLabel("MIN. BALANCE");
		lblMinBal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMinBal.setBounds(10, 367, 90, 25);
		contentPane.add(lblMinBal);

		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CURRENT", "SAVING" }));
		comboBox.setBounds(111, 105, 258, 25);
		contentPane.add(comboBox);
		txtMinBalance = new JTextField();
		txtMinBalance.setText("2000");
		txtMinBalance.setColumns(10);
		txtMinBalance.setBounds(111, 367, 373, 25);
		contentPane.add(txtMinBalance);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(271, 223, 62, 25);
		contentPane.add(lblGender);

		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setBackground(new Color(0, 153, 153));
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(339, 223, 62, 25);
		contentPane.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setBackground(new Color(0, 153, 153));
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnFemale.setBounds(412, 223, 72, 25);
		contentPane.add(rdbtnFemale);

		ButtonGroup rdbtngrp = new ButtonGroup();
		rdbtngrp.add(rdbtnMale);
		rdbtngrp.add(rdbtnFemale);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(NewAccount.class.getResource("/icons/icons8-exit.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(373, 403, 111, 34);
		contentPane.add(btnCancel);

		JDateChooser dateChooserDOB = new JDateChooser();
		dateChooserDOB.setBounds(111, 223, 150, 25);
		contentPane.add(dateChooserDOB);

		JDateChooser openingDate = new JDateChooser();
		openingDate.setBounds(111, 30, 258, 25);
		contentPane.add(openingDate);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (comboBox.getSelectedItem().equals("CURRENT")) {
						lblMinBal.setVisible(true);
						txtMinBalance.setVisible(true);
					} else {
						lblMinBal.setVisible(false);
						txtMinBalance.setVisible(false);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// bi = ImageIO.read(file);
					im = ImageIO.read(file);
					String imgUrl = imageUploadPath + file.getName();
					ImageIO.write(im, "JPG", new File(imgUrl));
					// ImageIO.write(bi, "JPG", new File(imgUrl));
					u.setImage_url(imgUrl);
					u.setOpened_date(openingDate.getDate());
					u.setBranch_name(txtBranch.getText());
					u.setAccount_type((String) comboBox.getSelectedItem());
					u.setC_name(name.getText());
					u.setDob(dateChooserDOB.getDate());
					if (rdbtnMale.isSelected()) {
						gender = "M";
						u.setGender(gender);
					} else {
						gender = "F";
						u.setGender("F");
					}
					u.setPhone(txtPhone.getText());
					u.setEmail(txtEmail.getText());
					u.setAddress(txtAddress.getText());
					if (comboBox.getSelectedItem().equals("CURRENT")) {
						u.setAmount(Double.parseDouble(txtMinBalance.getText()));
					} else {
						u.setAmount(0);
					}
					u.setDate(new Date());
					u.setStatus("CREDITED");

					String passwd = JOptionPane.showInputDialog("Please enter the password for login:");
					String uname = u.getEmail();
					u.setUser_name(uname);
					u.setPassword(passwd);
					u.setUser_type("CUSTOMER");
					int saved = userDao.createAccount(u);
					if (saved != 0) {
						System.out.println("Account created successfully.\n Here is your info: \n" + "username is: "
								+ uname + " || Password: " + passwd);
						JOptionPane.showMessageDialog(null, "Account Created Successfully.");
						JOptionPane.showMessageDialog(null, "Your User Name is:" + uname + "|| Password:" + passwd);
						dispose();
					}
					dispose();
				} catch (IOException | ClassNotFoundException | SQLException ice) {
					System.out.println(ice.getMessage());
					ice.printStackTrace();
				}
			}
		});
		btnCreate.setIcon(new ImageIcon(NewAccount.class.getResource("/icons/icons8-plus.png")));
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(241, 403, 111, 34);
		contentPane.add(btnCreate);

	}
}
