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
public class Transfer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNo;
	private JTextField txtTemp;
	private JTextField txtAmount;

	public Transfer(int accountNo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("J:\\Resources\\LogoNMB.png"));
		setTitle("Transfer Balance");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new TitledBorder(null, "Balance Transfer", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 14), Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Transfer.class.getResource("/icons/icons8-cancel.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(372, 268, 110, 36);
		contentPane.add(btnCancel);

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

		txtAccountNo = new JTextField();
		txtAccountNo.setText(""+accountNo);
		txtAccountNo.setEditable(false);
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(177, 133, 305, 35);
		contentPane.add(txtAccountNo);

		JLabel lblFrom = new JLabel("FROM:");
		lblFrom.setIcon(new ImageIcon(Transfer.class.getResource("/icons/icons8-change-user.png")));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(10, 132, 127, 35);
		contentPane.add(lblFrom);

		JLabel lblReceiversAc = new JLabel("RECEIVER'S AC NO.:");
		lblReceiversAc.setIcon(new ImageIcon(Transfer.class.getResource("/icons/icons8-clone.png")));
		lblReceiversAc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReceiversAc.setBounds(7, 179, 130, 35);
		contentPane.add(lblReceiversAc);

		txtTemp = new JTextField();
		txtTemp.setColumns(10);
		txtTemp.setBounds(177, 179, 305, 35);
		contentPane.add(txtTemp);

		JLabel lblAmount = new JLabel("AMOUNT:");
		lblAmount.setIcon(new ImageIcon(Transfer.class.getResource("/icons/icons8-paper-money.png")));
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount.setBounds(7, 222, 130, 35);
		contentPane.add(lblAmount);

		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(177, 222, 305, 35);
		contentPane.add(txtAmount);

		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 475, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("J:\\Resources\\Final Resc\\transfer.jpg"));
		label_1.setBounds(0, 0, 475, 100);
		panel.add(label_1);

		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					User u = new User();
					UserDAO userDAO = new UserDAOImpl();
					u.setAccount_no(accountNo);
					u.setTemp_ac(Integer.parseInt(txtTemp.getText()));
					u.setDate(new Date());
					System.out.println(u.getDate());
					System.out.println(u.getAccount_no());
					System.out.println(u.getTemp_ac());
					double temp = u.setAmount(Double.parseDouble(txtAmount.getText()));
					u.setStatus("DEBITED");
					int saved = userDAO.balanceTransfer(u);

					if (saved > 0) {
						JOptionPane.showMessageDialog(null, "Rs. " + temp + " transfered successfully.");

					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong.Please try again");
					}
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
		btnTransfer.setIcon(new ImageIcon(Transfer.class.getResource("/icons/icons8-data-transfer.png")));
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTransfer.setBounds(243, 268, 120, 36);
		contentPane.add(btnTransfer);

	}

}
