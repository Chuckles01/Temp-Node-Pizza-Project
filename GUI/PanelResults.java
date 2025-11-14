import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelResults extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * A method that adds the currently viewed recipe as a favorite for the currently logged in user
	 */
	private void favorite() {
		return;
	}
	
	/**
	 * A method that returns to the search panel to start a new search
	 */
	private void newSearch() {
		Testing.changePanel("search");
		return;
	}
	/**
	 * Create the panel.
	 */
	public PanelResults() {
		
		JTextArea txtrResults = new JTextArea();
		txtrResults.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtrResults.setText("results");
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 32));
		
		JScrollBar scrollBar = new JScrollBar();
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 32));
		
		JTextArea textArea = new JTextArea();
		
		JTextArea txtrRecipeArea = new JTextArea();
		txtrRecipeArea.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtrRecipeArea.setText("Recipe Area");
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				favorite();
			}
		});
		btnFavorite.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 32));
		
		JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newSearch();
			}
		});
		btnNewSearch.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 32));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(252)
							.addComponent(lblResults))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(txtrResults, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(145)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtrRecipeArea, GroupLayout.PREFERRED_SIZE, 1341, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(lblRecipe)
							.addGap(66)
							.addComponent(btnFavorite, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(633)
							.addComponent(btnNewSearch, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResults, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblRecipe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnNewSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnFavorite, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtrRecipeArea, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
						.addComponent(scrollBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
						.addComponent(txtrResults, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		setLayout(groupLayout);

	}
	
}
