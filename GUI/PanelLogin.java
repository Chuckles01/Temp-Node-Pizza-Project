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
		setMinimumSize(new Dimension(1920, 1080));
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
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(601)
					.addComponent(lblMealersChoice)
					.addContainerGap(647, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(769, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passWordField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
								.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))))
					.addGap(775))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(320)
					.addComponent(lblMealersChoice)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(420, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

}
