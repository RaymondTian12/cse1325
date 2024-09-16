package test;

import customer.Alacarte;
import product.Media;

public class TestAlacarte
{
	public static void main(String[] args)
	{
		Media testMedia = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 15);
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
		
		// 
		
		
	}
}
