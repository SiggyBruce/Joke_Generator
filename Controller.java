import java.awt.event.*;
/**
 * Controller.java - APR-14-2016 - ITEC 220: Project 4 -
 * This class contains methods that control the flow of the program.
 * Implements the ActionListener interface.
 * @author Tre Haga
 * @version 1.0
 */
public class Controller implements ActionListener
{
	/**
	 * The Controller class instance variables.
	 */
	private View view;
	/**
	 * The Controller class constructor.
	 * Creates a new instance of the View class.
	 * Assigns the buttons from the View class to a new ActionListener.
	 */
	public Controller()
	{
		view = new View();
		
		this.view.getRonSwansonButton().addActionListener(this);
		this.view.getChuckNorrisButton().addActionListener(this);
	}
	/**
	 * The actionPerformed method takes an event and checks to see if a specific event has occurred.
	 */
	public void actionPerformed(ActionEvent event)
	{
		Object eventSource = event.getSource();
		
		if (eventSource == this.view.getRonSwansonButton())
		{
			view.setRonSwansonQuote();
		}
		else if (eventSource == this.view.getChuckNorrisButton())
		{
			view.setChuckNorrisJoke();
		}
	}
}