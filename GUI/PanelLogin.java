import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField userNameField;
	private JTextField passWordField;

	/**
	 * A method that searches the user database to match the given user name and password, changes to the search panel if successful.
	 * Currently only changes panel
	 */
	private void login() {
		Testing.changePanel("search");
	}
	
	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setMinimumSize(new Dimension(720, 400));
		setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		JLabel lblMealersChoice = new JLabel("Mealer's Choice");
		lblMealersChoice.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 99));
		
		userNameField = new JTextField(); // text field for the username
		userNameField.setColumns(20);
		
		passWordField = new JTextField(); // text field for the password
		passWordField.setColumns(20);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		
		// Button to login
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 24));
		
		// This big hunk of text is for the layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(300, 560, Short.MAX_VALUE) // Gap from Components left edge to screen left edge
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(202)
									.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(9)
											.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passWordField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))))
							.addGap(256))
						.addComponent(lblMealersChoice, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
					.addGap(300, 560, Short.MAX_VALUE)) // Gap from Components right edge to screen right edge
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200, 320, Short.MAX_VALUE) // Gap from Screen top edge to Components top edge
					.addComponent(lblMealersChoice, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
					.addGap(42)
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addGap(200, 385, Short.MAX_VALUE)) // Gap from Components bottom edge to Screen bottom edge
		);
		setLayout(groupLayout);
		
	}

}
