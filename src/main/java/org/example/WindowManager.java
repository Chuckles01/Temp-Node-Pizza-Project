package org.example;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout card = new CardLayout();
	private JPanel mainPanel = new JPanel(card);
	private JPanel login = new PanelLogin(this);
	private JPanel search = new PanelSearch(this);
	private JPanel results = new PanelResults(this);
    private User currentUser;

    /**
	 * Create the frame.
	 */
	public WindowManager() {
    	getContentPane().setPreferredSize(new Dimension(1920, 1080));
    	getContentPane().setMinimumSize(new Dimension(1280, 720));
    	getContentPane().setMaximumSize(new Dimension(2650, 1440));
    	setMaximumSize(new Dimension(2650, 1440));
    	setMinimumSize(new Dimension(1280, 720));
    	setPreferredSize(new Dimension(1920, 1080));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setTitle("Mealer's Choice");
		// this line sets the image for the task bar
		// the image directory path will be changed when the image gets pushed to git
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/someone/Documents/compSci/380_soft_eng/Playground/Temp_Node_Pizza.png"));
		// comment this out for testing since the icon will be in a different place
		createMainPanel();
		mainPanel.setMaximumSize(new Dimension(2650, 1440));
		mainPanel.setMinimumSize(new Dimension(1280, 720));
		mainPanel.setPreferredSize(new Dimension(1920, 1080));
		getContentPane().add(mainPanel);
	}
	
	/**
	 * A method that initializes the panels to the frame layout, then sets the login panel as the start
	 */
	private void createMainPanel() {
		login.setMaximumSize(new Dimension(2650, 1440));
		login.setMinimumSize(new Dimension(1280, 720));
		mainPanel.add(login, "login");
		search.setMaximumSize(new Dimension(2650, 1440));
		search.setMinimumSize(new Dimension(1280, 720));
		search.setPreferredSize(new Dimension(1920, 1080));
		mainPanel.add(search, "search");
		results.setPreferredSize(new Dimension(1920, 1080));
		results.setMinimumSize(new Dimension(1280, 720));
		results.setMaximumSize(new Dimension(2650, 1440));
		mainPanel.add(results, "results");
		
		card.show(mainPanel, "login");
		return;
	}
	
	/**
	 * A method that changes which panel card is currently showing on the frame.
	 * @param to The string signalling which card to flip to
	 */
	public void setPanel(String to) {
		card.show(mainPanel, to);
		pack();
		return;
	}

    public void favoriting(int recipe_id){
        currentUser.addFavorite(recipe_id);
    }

    public void login(User user){
        currentUser = user;
        ((PanelSearch)search).login(user.getUsername());
    }

    public void logout(){
        currentUser = null;
    }

    public String getUserName(){
        return currentUser.getUsername();
    }

    public void searched(List<SearchResult> r){
        if(results.getClass() == PanelResults.class) {
            ((PanelResults)results).populateResults(r);
        }
    }

}
