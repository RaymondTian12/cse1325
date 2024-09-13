/**
 * Represents a media system with a title, URL, and the number of points per media
 * Includes methods to view the number of points and the details of the media
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since	1.0
 */

package product;

import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.MalformedURLException;

public class Media
{
	private String title;
	private String url;
	private int points;
	
	
	
	public Media(String title, String url, int points)
	{
		this.title = title;
		this.points = points;
		
		try
		{
			URI uri = new URI(url); // Note: Compiler warnings - URISyntaxException and MalformedURLException must be caught
			if (!uri.isAbsolute())
			{
				throw new RuntimeException(url + " is invalid");
			}
            
			uri.toURL();
			this.url = url;
		}
		catch(MalformedURLException e)
		{	
			throw new RuntimeException(url + " is invalid");
		}	
		catch(URISyntaxException e)
		{	
			throw new RuntimeException(url + " is invalid");
		}
	}
	
	public int getPoints()
	{
		return points;
	}
	
	@Override
	public String toString()
	{
		return title + " (" + url + ") (Points: " + points + ")" ;
	}
}
