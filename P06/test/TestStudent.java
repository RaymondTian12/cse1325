package test;

import customer.Account;
import customer.Unlimited;
import customer.Alacarte;
import customer.Student;
import product.Media;
import moes.Moes;

public class TestStudent
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		int points = 10; // Added points with changes to class Media
		boolean accountStatus = true;
		
		// Test verifying student's toString() method
		Student student = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu", accountStatus); 
		
		if (!(student.toString()).equals("Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)"))
		{
			System.err.println("FAIL: Expected \"Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)\" not \"" + student.toString() + "\"");
			failureCount++;
		}
		
		// Test verifying non-UTA email address
		String invalidEmail = "rxt9181@invalid.edu"; 
		try
		{
			Student invalidStudent = new Student("Raymond Tian", 1002199181, invalidEmail, accountStatus); 
			// If the following 2 lines are executed, then that means the exception was not thrown
			System.err.println("FAIL: Expected Illegal Argument Exception for Non-UTA email adddress " + invalidEmail); 
			failureCount++;
		}
		catch(IllegalArgumentException e)
		{
			// Catch and Ignore the correct exception
			if(!(e.getMessage()).equals("Non-UTA email address: " + invalidEmail)) 
			{
				System.err.println("FAIL: Incorrect exception message for invalid email address");
				System.err.println("Expected: Non-UTA email address: " + invalidEmail + " | Actual - " + e.getMessage());
				failureCount++;
			}
		}
		catch(Exception e)
		{
			System.err.println("FAIL: Unexpected exception type - " + e.getClass().getName());
			failureCount++;
		}
		
		// Test verifying requesting media
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", points);
		
		if (!(student.requestMedia(media)).equals("Playing " + media.toString()))
		{
			System.err.println("FAIL: Expected \"" + media.toString() + "\" not \"" + student.requestMedia(media) + "\"");
			failureCount++;
		}
		
		// Additional Tests for P04
		
		// Verify that the requestMedia method returns the same result as the Account's play method for an Unlimited account
		// When testing, can change unlimitedAccountPlayResult with a string different than what's expected
		// Expected String should be the following for this example: 
		// Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) (Points: 10)
		boolean unlimitedAccountStatus = true; // Set to true for unlimited
		
		Unlimited unlimitedAccount = new Unlimited();
		String unlimitedAccountPlayResult = unlimitedAccount.play(media);
		
		Student unlimitedStudent = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu", unlimitedAccountStatus);
		String unlimitedStudentPlayResult = unlimitedStudent.requestMedia(media);
		
		if (!unlimitedAccountPlayResult.equals(unlimitedStudentPlayResult))
		{
			System.err.println("FAIL: requestMedia does not match play for an unlimited account");
			System.err.println("Expected: " + unlimitedAccountPlayResult);
			System.err.println("Actual: " + unlimitedStudentPlayResult); 
			failureCount++;
		}
		
		// Verify the same but for an Alacarte account with sufficient points
		// When testing, can change alacarteNoPointsStudentPlayResult with a string different than what's expected
		// Expected String should be the following for this example: 
		// Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) (Points: 10)

		boolean alacarteAccountStatus = false; // Set to false for alacarte
		
		Alacarte accountNoPoints = new Alacarte();
		int alacarteNoPoints = 15; // Pick anything more than points at the top for "Little Shop of Horrors"
		accountNoPoints.buyPoints(alacarteNoPoints);
		String alacarteNoPointsPlayResult = accountNoPoints.play(media);
		
		Student alacarteNoPointsStudent = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu", alacarteAccountStatus);
		Moes moes = new Moes();
		moes.addStudent(alacarteNoPointsStudent);
		moes.addMedia(media);
		int studentIndex1 = 0;
		int mediaIndex = 0;
		moes.buyPoints(studentIndex1, alacarteNoPoints);
		String alacarteNoPointsStudentPlayResult = moes.playMedia(studentIndex1, mediaIndex);
		
		
		if (!alacarteNoPointsPlayResult.equals(alacarteNoPointsStudentPlayResult))
		{
			System.err.println("FAIL: requestMedia does not match play for an alacarte account with sufficient points");
			System.err.println("Expected: " + alacarteNoPointsPlayResult);
			System.err.println("Actual: " + alacarteNoPointsStudentPlayResult);
			failureCount++;
		}
		
		// Verify the same but for an Alacarte account with insufficient points
		// When testing, can change alacarteWithPointsPlayResult with a string different than what's expected
		// Expected String should be the following for this example: 
		// Buy more points: Requires 10 points, you have 5
		Alacarte accountWithPoints = new Alacarte();
		int alacarteWithPoints = 5; // Pick anything less than points at the top for "Little Shop of Horrors"
		accountWithPoints.buyPoints(alacarteWithPoints);
		String alacarteWithPointsPlayResult = accountWithPoints.play(media);
		
		Student alacarteWithPointsStudent = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu", alacarteAccountStatus);
		moes.addStudent(alacarteWithPointsStudent);
		int studentIndex2 = 1; // Keep the media index the same as it's the same media
		moes.buyPoints(studentIndex2, alacarteWithPoints);
		String alacarteWithPointsStudentPlayResult = moes.playMedia(studentIndex2, mediaIndex);
		
		if (!alacarteWithPointsPlayResult.equals(alacarteWithPointsStudentPlayResult))
		{
			System.err.println("FAIL: requestMedia does not match play for an alacarte account with insufficient points");
			System.err.println("Expected: " + alacarteWithPointsPlayResult);
			System.err.println("Actual: " + alacarteWithPointsStudentPlayResult);
			failureCount++;
		}
		
		// Exit program with failureCount or 0 depending on which data is used
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
