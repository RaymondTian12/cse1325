package test;
import product.Media;

public class TestMedia
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		int points = 10; // Added with update to class Media
		
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", points); // Hardcode test data : Title, URL : Added points 
		String expected = "The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)";
		
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
