package org.example;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSearch extends JPanel {

	private static final long serialVersionUID = 1L;
    private WindowManager frame;
    private JComboBox<Search.Flavor> flavorTown;
    private JComboBox<Search.Texture> textureCombo;
    private JComboBox<Search.Type> typeCombo;
    private JComboBox<Search.Time> timeCombo;
    private JComboBox<Search.Allergen> allergenCombo;
    private JLabel lblUsernameGoesHere;

    /**
	 * A method that logs the user out
	 * Currently only changes panel
	 */
	private void logout() {
		frame.logout();
        frame.setPanel("login");
		return;
	}
	
	/**
	 * A method that searches the database
	 * Currently only changes panel
	 */
	private void search() {
        Search s = new Search((Search.Flavor) flavorTown.getSelectedItem(),
                (Search.Texture) textureCombo.getSelectedItem(),
                (Search.Type) typeCombo.getSelectedItem(),
                (Search.Time) timeCombo.getSelectedItem(),
                (Search.Allergen) allergenCombo.getSelectedItem());
        frame.searched(s.runSearch());
        frame.setPanel("results");
		return;
	}
	
	/**TO DO
	 * A method that changes to the results panel with the User's list of favorite meals
	 * Currently only changes panel
	 */
	private void favorites() {
        User tempUser = new User();
		frame.searched(tempUser.getFavorites(lblUsernameGoesHere.getText()));
        frame.setPanel("results");
	}
	
	/**TO DO
	 * A method that gets the logged in User's username and displays it
	 * @return The username of the currently logged in user
	 */
	public void login(String username){
        lblUsernameGoesHere.setText(username);
    }
	
	/**
	 * Create the panel.
	 */
	public PanelSearch(WindowManager frame) {
        this.frame = frame;
		setMinimumSize(new Dimension(1280, 720));
		setPreferredSize(new Dimension(1920, 1080));
		setMaximumSize(new Dimension(2560, 1440));

		 // The combo box for flavors
        flavorTown = new JComboBox<Search.Flavor>(Search.Flavor.values());
		flavorTown.setMinimumSize(new Dimension(300, 27));
        flavorTown.setFont(new Font("Liberation Serif", Font.ITALIC, 20));
		
		 // The combo box for textures
        textureCombo = new JComboBox<Search.Texture>(Search.Texture.values());
        textureCombo.setFont(new Font("Liberation Serif", Font.ITALIC, 20));

		 // The combo box for types
        typeCombo = new JComboBox<Search.Type>(Search.Type.values());
        typeCombo.setFont(new Font("Liberation Serif", Font.ITALIC, 20));
		
		// The combo box for times
        timeCombo = new JComboBox<Search.Time>(Search.Time.values());
        timeCombo.setFont(new Font("Liberation Serif", Font.ITALIC, 20));

        // The combo box for allergens
        allergenCombo = new JComboBox<Search.Allergen>(Search.Allergen.values());
        allergenCombo.setFont(new Font("Liberation Serif", Font.ITALIC, 20));
		
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
		
		lblUsernameGoesHere = new JLabel();
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(500, 1286, Short.MAX_VALUE) // Gap from Screen left edge to favorites/logged in as left edge
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200, 355, Short.MAX_VALUE) // Gap from loggedInAs left edge to Favorites button left edge
							.addComponent(btnFavorites, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLoggedInAs, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblUsernameGoesHere, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addGap(78)
							.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
					.addGap(78))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200, 583, Short.MAX_VALUE) // Gap from screen left edge to Quantifier labels left edge
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCommonAllergens, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19) // Gap from longest label left edge to Time label left edge
							.addComponent(lblTimeUntilReady, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166) // Gap from longest label left edge to Type label left edge
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(132) // Gap from longest label left edge to Texture label left edge
							.addComponent(lblTexture, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144) // Gap from longest label left edge to Flavor label left edge
							.addComponent(lblFlavor, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
					.addGap(31) // Gap from labels right edge to Combo box left edge
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearch, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(allergenCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
						.addComponent(timeCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
						.addComponent(typeCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
						.addComponent(textureCombo, Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
						.addComponent(flavorTown, Alignment.TRAILING, 0, 233, Short.MAX_VALUE))
					.addGap(250, 836, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25, 72, Short.MAX_VALUE) // Gap from Screen top edge to Favorites button top edge
					.addComponent(btnFavorites, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(45, 133, Short.MAX_VALUE) // Gap from Favorites button bottom edge to Combo Boxes top edge
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(flavorTown, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblFlavor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(15, 45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textureCombo, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblTexture, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)))
					.addGap(15, 47, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(typeCombo, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)))
					.addGap(15, 45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(timeCombo, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblTimeUntilReady, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)))
					.addGap(15, 51, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(allergenCombo, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblCommonAllergens, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)))
					.addGap(55)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(75, 196, Short.MAX_VALUE) // Gap from Search Button bottom edge to LoggedInAs top edge
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblUsernameGoesHere, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblLoggedInAs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(59))
		);
		setLayout(groupLayout);

	}

}
