package test;
import product.Media;

// New imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;


public class TestMedia
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		int points = 10; // Added with update to class Media
		
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", points); // Hardcode test data : Title, URL : Added points 
		String expected = "The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) (Points: " + points + ")";
		
		if (!(media.toString()).equals(expected))
		{
			System.err.println("FAIL: " + "Expected String - \"" + expected  + " | Actual String -  " + media.toString());
			failureCount++;
		}
		
		String[] validURLs = {"https://youtube.com", "file://media/lib/garp.mp4"};
		String[] invalidURLs = {"hello.world", "htt://badurl.com", "flub://badurl.com"};
		
		// Tests valid URLs
		// Note: Switch to invalidURLs to further test!
		for (String url : validURLs) 
		{
			try
			{
				new Media("Default Title for URL", url, points);
			}
			catch(RuntimeException e)
			{
				System.err.println("FAIL: Unexpected exception for " + url);
				System.err.println(e);
			}
		}
		
		// Tests invalid URLs
		// Note: Switch to validURLs to further test!
		for (String url : invalidURLs)
		{
			try
			{
				new Media("Default Title for URL", url, points);
				System.out.println("FAIL: Missing exception for " + url);
			}
			catch(RuntimeException e)
			{
			}
		}
		
		// Tests File IO features
		Media originalMedia = new Media("Home Alone", "http://homealone.com", 100);
        
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("media.txt"))) // Save to a file
		{
		    originalMedia.save(bw);
		} 
		catch (IOException e) 
		{
		    System.err.println("Error writing to file: " + e.getMessage());
		    failureCount++;
		}
		
		Media loadedMedia = null; // Initialize to null for now
		try (BufferedReader reader = new BufferedReader(new FileReader("media.txt"))) 
		{
		    loadedMedia = new Media(reader);
		} catch (IOException e) 
		{
		    System.err.println("Error reading from file: " + e.getMessage());
		    failureCount++;
		}

		// Check if originalMedia and loadedMedia are equal
		if (loadedMedia != null) 
		{ 
		    boolean areEqual = originalMedia.equals(loadedMedia);
		    if (!areEqual)
		    {
		    	System.err.println("Original and loaded media are not equal: " + areEqual);
		    	failureCount++;
		    }
		}
			
		if (failureCount > 0)
		{
			System.err.println("FAIL: Error code " + failureCount);
			System.exit(failureCount);
		}
		else
		{
			System.exit(0);
		}
		
	}
}
