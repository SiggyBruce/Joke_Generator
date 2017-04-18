import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * View.java - APR-14-2016 - ITEC 220: Project 4 -
 * This class contains methods that make up what the user visually sees.
 * Inherits methods from the JPanel class.
 * @author Tre Haga
 * @version 1.0
 */
public class View extends JPanel
{
	/**
	 * The View class instance variables.
	 */
	private final int WIDTH, HEIGHT;
	private JFrame frame;
	private JButton ronSwansonButton, chuckNorrisButton;
	private JLabel ronSwansonLabel, chuckNorrisLabel;
	private JSON json;
	private BufferedImage ronSwansonImage, chuckNorrisImage;
	/**
	 * The View class constructor.
	 * Creates a JFrame, two JButtons, two JLabels, two BufferedImages, and a new instance of the JSON class.
	 */
	public View()
	{
		WIDTH = 1555;
		HEIGHT = 685;
		frame = new JFrame("Project 4");
		ronSwansonButton = new JButton("Generate Quote");
		chuckNorrisButton = new JButton("Generate Joke");
		ronSwansonLabel = new JLabel("Ron Swanson Quotes from NBC's Parks and Recreation - Nick Offerman as Ron Swanson.", SwingConstants.CENTER);
		chuckNorrisLabel = new JLabel("Chuck Norris Jokes - Chuck Norris as Chuck Norris.", SwingConstants.CENTER);
		json = new JSON(this);
		
		try
		{
			ronSwansonImage = ImageIO.read(new File("images/ron_swanson.jpg"));
		}
		catch (IOException exception)
		{
			this.ronSwansonLabel.setText("Failed to load the image for Ron Swanson (Nick Offerman).");
		}
		
		try
		{
			chuckNorrisImage = ImageIO.read(new File("images/chuck_norris.jpg"));
		}
		catch (IOException exception)
		{
			this.chuckNorrisLabel.setText("Failed to load the image for Chuck Norris.");
		}
		
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.ORANGE);
		
		this.frame.setVisible(true);
		this.frame.setContentPane(this);
		this.frame.pack();
		this.frame.setSize(WIDTH, HEIGHT);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.frame.setResizable(false);
	    
	    	Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
	    
        	this.ronSwansonLabel.setVisible(true);
        	this.ronSwansonLabel.setSize(1530, 50);
        	this.ronSwansonLabel.setLocation(10, 270);
        	this.ronSwansonLabel.setFocusable(false);
        	this.ronSwansonLabel.setBorder(border);
        	this.ronSwansonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        	this.ronSwansonLabel.setOpaque(true);
        	this.ronSwansonLabel.setBackground(Color.YELLOW);
        	this.add(ronSwansonLabel);
        
	    	this.ronSwansonButton.setVisible(true);
	    	this.ronSwansonButton.setSize(200, 50);
        	this.ronSwansonButton.setLocation(900, 115);
        	this.ronSwansonButton.setFocusable(false);
        	this.ronSwansonButton.setBorder(border);
        	this.ronSwansonButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        	this.ronSwansonButton.setOpaque(true);
        	this.ronSwansonButton.setBackground(Color.YELLOW);
        	this.add(ronSwansonButton);
        
        	this.chuckNorrisLabel.setVisible(true);
        	this.chuckNorrisLabel.setSize(1530, 50);
        	this.chuckNorrisLabel.setLocation(10, 590);
        	this.chuckNorrisLabel.setFocusable(false);
        	this.chuckNorrisLabel.setBorder(border);
        	this.chuckNorrisLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        	this.chuckNorrisLabel.setOpaque(true);
        	this.chuckNorrisLabel.setBackground(Color.YELLOW);
        	this.add(chuckNorrisLabel);
        
	    	this.chuckNorrisButton.setVisible(true);
	    	this.chuckNorrisButton.setSize(200, 50);
        	this.chuckNorrisButton.setLocation(900, 430);
        	this.chuckNorrisButton.setFocusable(false);
        	this.chuckNorrisButton.setBorder(border);
        	this.chuckNorrisButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        	this.chuckNorrisButton.setOpaque(true);
        	this.chuckNorrisButton.setBackground(Color.YELLOW);
        	this.add(chuckNorrisButton);
	}
	/**
	 * The paintComponent method takes graphics and visually displays graphics.
	 * Displays the two BufferedImages.
	 */
	public void paintComponent(Graphics graphics)
	{
		graphics.setColor(Color.ORANGE);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		graphics.drawImage(ronSwansonImage, 640, 10, null);
		graphics.setColor(Color.BLACK);
		graphics.drawRect(640, 10, 250, 250);
		graphics.drawRect(641, 11, 248, 248);
		graphics.drawRect(642, 12, 246, 246);
		graphics.drawImage(chuckNorrisImage, 640, 330, null);
		graphics.setColor(Color.BLACK);
		graphics.drawRect(640, 330, 250, 250);
		graphics.drawRect(641, 331, 248, 248);
		graphics.drawRect(642, 332, 246, 246);
	}
	/**
	 * The getRonSwansonButton method returns the ronSwansonButton.
	 * @return ronSwansonButton
	 */
	public JButton getRonSwansonButton()
	{
		return this.ronSwansonButton;
	}
	/**
	 * The getChuckNorrisButton method returns the chuckNorrisButton.
	 * @return chuckNorrisButton
	 */
	public JButton getChuckNorrisButton()
	{
		return this.chuckNorrisButton;
	}
	/**
	 * The getRonSwansonLabel method returns the ronSwansonLabel.
	 * @return ronSwansonLabel
	 */
	public JLabel getRonSwansonLabel()
	{
		return this.ronSwansonLabel;
	}
	/**
	 * The getChuckNorrisLabel method returns the chuckNorrisLabel.
	 * @return chuckNorrisLabel
	 */
	public JLabel getChuckNorrisLabel()
	{
		return this.chuckNorrisLabel;
	}
	/**
	 * The setRonSwansonQuote method sets the text for the ronSwansonLabel.
	 * Calls the queryRonSwansonQuote method from the JSON class and displays it as a string.
	 */
	public void setRonSwansonQuote()
	{
		String result = this.json.queryRonSwansonQuote();
		this.ronSwansonLabel.setText(result);
	}
	/**
	 * The setChuckNorrisJoke method sets the text for the chuckNorrisLabel.
	 * Calls the queryChuckNorrisJoke method from the JSON class and displays it as a string.
	 */
	public void setChuckNorrisJoke()
	{
		String result = this.json.queryChuckNorrisJoke();
		this.chuckNorrisLabel.setText(result);
	}
}