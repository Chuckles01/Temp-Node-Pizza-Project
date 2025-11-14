import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelSearch extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * A method that logs the user out
	 * Currently only changes panel
	 */
	private void logout() {
		Testing.changePanel("login");
		return;
	}
	
	/**
	 * A method that searches the database
	 * Currently only changes panel
	 */
	private void search() {
		Testing.changePanel("results");
		return;
	}
	
	/**
	 * A method that changes to the results panel with the User's list of favorite meals
	 * Currently only changes panel
	 */
	private void favorites() {
		Testing.changePanel("results");
	}
	
	/**
	 * A method that gets the logged in User's username and displays it
	 * @return The username of the currently logged in user
	 */
	private String getUserName() {
		return "Username goes here";
	}
	
	/**
	 * Create the panel.
	 */
	public PanelSearch() {
		setMaximumSize(new Dimension(1920, 1080));
		
		JComboBox<String> flavorTown = new JComboBox<String>(); // The combo box for flavors
		
		JComboBox<String> textureCombo = new JComboBox<String>(); // The combo box for textures
		
		JComboBox<String> typeCombo = new JComboBox<String>(); // The combo box for types
		
		JComboBox<String> timeCombo = new JComboBox<String>(); // The combo box for times
		
		JComboBox<JCheckBox> allergenCombo = new JComboBox<JCheckBox>(); // The combo box for allergens. I think making it a combo box of JCheckBoxes for multiple allergens would work.
		
		// Search button
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 40));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		
		JLabel lblFlavor = new JLabel("Flavor :");
		lblFlavor.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 28));
		
		JLabel lblTexture = new JLabel("Texture :");
		lblTexture.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 28));
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 28));
		
		JLabel lblTimeUntilReady = new JLabel("Time Until Ready :");
		lblTimeUntilReady.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 28));
		
		JLabel lblCommonAllergens = new JLabel("Common Allergens :");
		lblCommonAllergens.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 28));
		
		JLabel lblLoggedInAs = new JLabel("Logged in as:");
		lblLoggedInAs.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 24));
		
		JLabel lblUsernameGoesHere = new JLabel(getUserName());
		lblUsernameGoesHere.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		// Logout button
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		btnLogout.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 24));
		
		// Favorites button
		JButton btnFavorites = new JButton("Favorites");
		btnFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				favorites();
			}
		});
		btnFavorites.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 42));
		
		// Big block of text for the layout.
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblCommonAllergens))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblTimeUntilReady))
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblType))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(715)
												.addComponent(lblTexture, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblFlavor))))))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(allergenCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
								.addComponent(timeCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
								.addComponent(typeCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
								.addComponent(textureCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
								.addComponent(flavorTown, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(836, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(1281, Short.MAX_VALUE)
					.addComponent(lblLoggedInAs)
					.addGap(18)
					.addComponent(lblUsernameGoesHere)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnFavorites)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
					.addGap(78))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(btnFavorites, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(127)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(flavorTown, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFlavor))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textureCombo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTexture, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(typeCombo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(timeCombo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTimeUntilReady, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(allergenCombo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCommonAllergens, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLoggedInAs)
						.addComponent(lblUsernameGoesHere))
					.addGap(36))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {flavorTown, textureCombo, typeCombo, timeCombo, allergenCombo});
		setLayout(groupLayout);

	}

}
