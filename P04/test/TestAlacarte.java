package test;

import customer.Alacarte;
import product.Media;

public class TestAlacarte
{
	public static void main(String[] args)
	{
		int testMediaPoints = 4; // Adjust to check what happens if account has enough or not enough points
		int pointsBought = 5; // Also use as the initial points balance 
		Alacarte account1 = new Alacarte();
		account1.buyPoints(pointsBought);
		Media testMedia = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", testMediaPoints);
		int failureCount = 0; // Used to count the number of failures and exit the program
		
		// Verify that buying points inceases the points remaining by the number of points bought
		// When testing with bad data, change account1.getPointsRemaining() in if condition and within if block to an invalid number
		if (pointsBought > account1.getPointsRemaining()) // if initial is higher than current, then points were not bought
		{
			System.err.println("FAIL: Buying points did not increase the point balance");
			System.err.println("Initial: " + pointsBought + " | Current: " + account1.getPointsRemaining());
			failureCount++;
		}
		
		// Verify that play returns "Playing " and the media if sufficient points are available
		// When testing, change expected1 String which should result in an error
		String expected1 = "Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) (Points: " + testMediaPoints + ")"; 
		String actual1 = account1.play(testMedia);
		if (!expected1.equals(actual1))
		{
			System.err.println("FAIL: Incorrect play message displayed");
			System.err.println("Expected: " + expected1);
			System.err.println("Actual: " + actual1);
			failureCount++;
		}
		
		// Verify that the play method reduces the points remaining by the number of points assigned if there are sufficient points
		// When testing, change the expectedPointsRemaining int to a value other than the expected value 
		int expectedPointsRemaining = pointsBought - testMediaPoints;
		int actualPointsRemaining = account1.getPointsRemaining();
		if (actualPointsRemaining > expectedPointsRemaining) // If deducted incorrectly, the points remaining in account is higher than the expected value
		{
			System.err.println("FAIL: Purchasing media incorrectly deducts from points balance");
			System.err.println("Expected: " + expectedPointsRemaining);
			System.err.println("Actual: " + actualPointsRemaining);
			failureCount++;
		}
		
		// Verify that the play method returns the correct message if there are insufficient points
		// When testing, change expected2 String which should result in an error
		String expected2 = "Buy more points: Requires " + testMedia.getPoints() + " points, you have " + account1.getPointsRemaining();
		if (!account1.play(testMedia).equals(expected2)) 
		{
			System.err.println("FAIL: Incorrect play message displayed if there are insufficient points");
			System.err.println("Expected: " + expected2);
			System.err.println("Actual: " + account1.play(testMedia));
			failureCount++;
		}
		
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
