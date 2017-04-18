import java.io.*;
import java.net.*;
import org.apache.commons.io.*;
import org.json.simple.*;
/**
 * JSON.java - APR-14-2016 - ITEC 220: Project 4 -
 * This class contains the methods for obtaining and manipulating JSON data from a server.
 * @author Tre Haga
 * @version 1.0
 */
public class JSON
{
	/**
	 * The JSON class instance variables.
	 */
	private View view;
	
	/**
	 * The JSON class constructor.
	 * Takes in an instance of the View class.
	 * @param newView
	 */
	public JSON(View newView)
	{
		view = newView;
	}
	/**
	 * The queryRonSwansonQuote method calls a server over the Internet and retrieves JSON data.
	 * Extracts the JSON data and converts it into a string.
	 * Queries the API: (http://ron-swanson-quotes.herokuapp.com/v2/quotes/).
	 * Returns a single Ron Swanson (Nick Offerman) quote.
	 * @return result
	 */
	public String queryRonSwansonQuote()
	{
		URL queryURL = null;
		String result = "";
		
		try
		{
			queryURL = new URL("http://ron-swanson-quotes.herokuapp.com/v2/quotes/");
			result = IOUtils.toString(queryURL, "UTF-8");
			result = result.substring(1, result.length() - 1);
		}
		catch (MalformedURLException exception)
		{
			this.view.getRonSwansonLabel().setText("Invalid URL look-up. No legal protocol could be found.");
		}
		catch (ClassCastException exception)
		{
			this.view.getRonSwansonLabel().setText("Invalid class casting.");
		}
		catch (IOException exception)
		{
			this.view.getRonSwansonLabel().setText("Could not read or write the JSON data.");
		}
		catch (StringIndexOutOfBoundsException exception)
		{
			this.view.getRonSwansonLabel().setText("Failed to correctly format the result.");
		}
		
		return result;
	}
	/**
	 * The queryChuckNorrisJoke method calls a server over the Internet and retrieves JSON data.
	 * Extracts the JSON data and converts it into a string.
	 * Queries the API: (http://api.icndb.com/jokes/random).
	 * Returns a single Chuck Norris joke.
	 * @return result
	 */
	public String queryChuckNorrisJoke()
	{
		URL queryURL = null;
		String result = "";
		Object object = null;
		JSONObject jsonObject = null;
		JSONObject jokeValue = null;
		
		try
		{
			queryURL = new URL("http://api.icndb.com/jokes/random");
			result = IOUtils.toString(queryURL, "UTF-8");
			object = JSONValue.parse(result);
			jsonObject = (JSONObject) object;
			jokeValue = (JSONObject)(jsonObject.get("value"));
			result = jokeValue.get("joke").toString().replaceAll("&quot;", "\"");
		}
		catch (MalformedURLException exception)
		{
			this.view.getRonSwansonLabel().setText("Invalid URL look-up. No legal protocol could be found.");
		}
		catch (ClassCastException exception)
		{
			this.view.getRonSwansonLabel().setText("Invalid class casting.");
		}
		catch (IOException exception)
		{
			this.view.getRonSwansonLabel().setText("Could not read or write the JSON data.");
		}
		
		return result;
	}
}