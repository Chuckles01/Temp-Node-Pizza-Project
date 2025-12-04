package org.example;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class PanelResults extends JPanel {

	private static final long serialVersionUID = 1L;
    private WindowManager frame;
    private List<SearchResult> results;
    private String[] recipeNames;
    private JList<String> txtrResults;
    private JScrollPane resultsPane;
    private JTextArea txtrRecipeArea;

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
		this.results = null;
        frame.setPanel("search");
		return;
	}

    /**
     * A method that receives the search results and populates the list of meal names
     * @param results The list of results
     */
    public void populateResults(List<SearchResult> results) {
        this.results = results;
        recipeNames = new String[results.size()];
        int i = 0;
        for (SearchResult result : results) {
            String name = result.getName();
            recipeNames[i] = name;
            i++;
        }
        populateList();
        return;
    }

    /**
     * A method that creates the list of recipe names and places the list into the scroll pane
     */
    private void populateList(){
        txtrResults = new JList<>(recipeNames);
        txtrResults.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtrResults.setVisible(true);
        resultsPane.getViewport().setView(txtrResults);
        System.out.println("List populates");
        return;
    }

	/**
	 * Create the panel.
	 */
	public PanelResults(WindowManager frame) {
		this.frame = frame;
		resultsPane = new JScrollPane();
        resultsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        resultsPane.setBackground(Color.WHITE);

        System.out.println("List added to scroll pane");
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 32));

		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 32));
		
		txtrRecipeArea = new JTextArea();
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
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(80, 179, Short.MAX_VALUE) // Gap from screen left edge to Results label
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(lblResults, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(91))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(resultsPane, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(txtrRecipeArea, GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(lblRecipe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(66)
							.addComponent(btnFavorite, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addGap(200, 633, Short.MAX_VALUE) // gap between Favorite button and New Search button
							.addComponent(btnNewSearch, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
							.addGap(77)))
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResults, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblRecipe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnFavorite, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE))
							.addGap(6)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtrRecipeArea, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
						.addComponent(resultsPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE))
					.addGap(58))
		);
		setLayout(groupLayout);

	}
	
}
