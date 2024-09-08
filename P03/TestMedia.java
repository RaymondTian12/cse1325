public class TestMedia
{
	public static void main(String[] args)
	{
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0"); // Hardcode test data : Title, URL
		
		if (!(media.toString()).equals("The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)")
		{
			System.err.println("FAIL: " + "Expected String - \"The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)\" "  + "Actual String - \ " + media.toString();
			System.exit(-1);
		}
	}
}
