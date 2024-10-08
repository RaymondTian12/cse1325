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

// New imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Media
{
	private String title;
	private String url;
	private int points;
	
	/**
	 * Creates a media using a title, URL, and points
	 *
	 * @param title 		the title of the media
	 * @param url			the URL of the media
	 * @param points		the number of points required for each media
	 * @since 			1.0
	 */
	
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
	
	public void save(BufferedWriter bw) throws IOException
	{
		bw.write("" + title + '\n');
		bw.write("" + url + '\n');
		bw.write("" + points + '\n');
	}
	
	public Media(BufferedReader br) throws IOException
	{
		this.title = br.readLine();
		this.url = br.readLine();
		this.points = Integer.parseInt(br.readLine());
	}
	
	/**
	 * Returns the number of points required for each media 
	 *
	 * @return	the number of points required for each media
	 * @since	1.0
	 */
	
	public int getPoints()
	{
		return points;
	}
	
	/**
	 * Returns the string representation of each media with the title, URL, and points
	 *
	 * @return	a string representing each media
	 * @since 	1.0
	 *
	 */
	
	@Override
	public String toString()
	{
		return title + " (" + url + ") (Points: " + points + ")" ;
	}
	@Override
	public boolean equals(Object o) 
	{
	    if (this == o)  
	    {
	    	return true; 
	    }
	    if (o == null || getClass() != o.getClass()) 
	    {
	    	return false; 
	    }

	    Media media = (Media)o; 
	    return points == media.points && // Compare points
		   title.equals(media.title) && // Compare title
		   url.equals(media.url); // Compare url
}
}
