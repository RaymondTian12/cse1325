public class TestMedia
{
	public static void main(String[] args)
	{
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0"); // Hardcode test data : Title, URL
		
		if (!(media.toString()).equals("The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)"))
		{
			System.err.println("FAIL: " + "Expected String - \"The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)\" "  + "Actual String -  " + media.toString());
			System.exit(-1);
		}
		
		String[] validURLs = {"https://youtube.com", "file://media/lib/garp.mp4"};
		String[] invalidURLs = {"hello.world", "htt://badurl.com", "flub://badurl.com"};
		
		for (String url : validURLs)
		{
			try
			{
				new Media("Default Title for validURL", url);
				System.out.println("PASS: " + url + " is valid");
			}
			catch(RuntimeException e)
			{
				System.err.println("FAIL: Unexpected exception for " + url);
				System.err.println(e);
			}
		}
		
		for (String url : invalidURLs)
		{
			try
			{
				new Media("Default Title for invalidURL", url);
				System.out.print("FAIL: Missing exception for " + url);
			}
			catch(RuntimeException e)
			{
				System.err.println("Invalid URL " + url + " successfully detected");
				System.err.println(e);
			}
		}
		
	}
}
