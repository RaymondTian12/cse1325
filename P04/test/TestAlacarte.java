package test;

import customer.Alacarte;
import product.Media;

public class TestAlacarte
{
	public static void main(String[] args)
	{
		Media testMedia = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 4);
		int pointsBought = 5;
		int failureCount = 0;
		
		// Verify that buying points inceases the points remaining by the number of points bought
		Alacarte account1 = new Alacarte();
		int initialPoints = account1.getPointsRemaining();
		account1.buyPoints(pointsBought);
		
		if (initialPoints > account1.getPointsRemaining()) // if initial is higher than current, then points were not bought
		{
			System.err.println("FAIL: Buying points did not increase the point balance");
			System.err.println("Initial: " + initialPoints + " | Current: " + account1.getPointsRemaining());
			failureCount++;
		}
		
		// Verify that play returns "Playing " and the media if sufficient points are available 
		String expected1 = "Playing " + testMedia.toString();
		if (!expected.equals(account1.play(testMedia)))
		{
			System.err.println("FAIL: Incorrect play message displayed");
			System.err.println("Expected: " + expected);
			System.err.println("Actual: " + account1.play(testMedia));
			failureCount++;
		}
		
		// Verify that the play method reduces the points remaining by the number of points assigned if there are sufficient points
		
		
		int expectedPointsRemaining = initialPoints - testMedia.getPoints();
		if (account1.getPointsRemaining() != expectedPointsRemaining))
		{
			System.err.println("FAIL: Purchasing media incorrect deducts from points balance");
			System.err.println("Expected: " + expectedPointsRemaining);
			System.err.println("Actual: " + account1.getPointsRemaining());
			failureCount++;
		}
		
		// Verify that the play method returns the correct message if there are insufficient points
		String expected2 = "";
		
		// Exit program with failureCount or 0 depending on which data is used
		if (failureCount > 0)
		{
			System.err.println("FAIL Code: " + failureCount);
			System.exit(failureCount);
		}
		else
		{
			System.exit(0);
		}
		
	}
}
