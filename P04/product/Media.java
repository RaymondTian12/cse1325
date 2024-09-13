package product;

import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.MalformedURLException;

public class Media
{
	private String title;
	private String url;
	
	public Media(String title, String url)
	{
		this.title = title;
		
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
	
	@Override
	public String toString()
	{
		return title + " (" + url + ")";
	}
}
