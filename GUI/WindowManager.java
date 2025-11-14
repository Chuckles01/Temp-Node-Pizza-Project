import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout card = new CardLayout();
	private JPanel mainPanel = new JPanel(card);
	private JPanel login = new PanelLogin();
	private JPanel search = new PanelSearch();
	private JPanel results = new PanelResults();

    /**
	 * Create the frame.
	 */
	public WindowManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setTitle("Mealer's Choice");
		// this line sets the image for the task bar
		// the image directory path will be changed when the image gets pushed to git
		// comment this out for testing since the icon will be in a different place
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/someone/Documents/compSci/380_soft_eng/Playground/Temp_Node_Pizza.png"));
		createMainPanel();
		add(mainPanel);
	}
	
	/**
	 * A method that initializes the panels to the frame layout, then sets the login panel as the start
	 */
	private void createMainPanel() {
		mainPanel.add(login, "login");
		mainPanel.add(search, "search");
		mainPanel.add(results, "results");
		
		card.show(mainPanel, "login");
		return;
	}
	
	/**
	 * A method that changes which panel card is currently showing on the frame.
	 * @param to
	 */
	public void setPanel(String to) {
		card.show(mainPanel, to);
		return;
	}

}
