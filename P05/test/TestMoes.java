package test;

import moes.Moes;
import product.Media;
import customer.Student;
import customer.Alacarte;
import customer.Unlimited;

public class TestMoes
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		int points1 = 10;
		int points2 = 15;
		
		Moes moes = new Moes();
		
		// Verify that adding 2 different Media objects via addMedia results in the correct media list from method getMediaList.
		// When testing, modify the expected1 string
		Media media1 = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", points1);
		Media media2 = new Media("The Terror of Tiny Town", "https://en.wikipedia.org/wiki/File:The_Terror_of_Tiny_Town.webm", points2);
		moes.addMedia(media1);
		moes.addMedia(media2);
		
		String expected1 = "0) The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) (Points: " + points1 + ")\n1) The Terror of Tiny Town (https://en.wikipedia.org/wiki/File:The_Terror_of_Tiny_Town.webm) (Points: " + points2 + ")\n";
		String actual1 = moes.getMediaList();
		
		if (!actual1.equals(expected1))
		{
			System.err.println("FAIL: Media list does not match expected list.");
			System.err.println("Expected: " + expected1);
			System.err.println("Actual: " + actual1);
			failureCount++;
		}
		
		// Verify that adding 2 different Student objects via addStudent, one with an Unlimited account and one with an Alacarte account, 
		// results in the correct media list from method getMediaList (getStudentList?)
		// When testing, modify the expected2 string
		Student unlimitedStudent = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu", true);
		Student alacarteStudent = new Student("Tian Raymond", 1819912001, "9181rxt@mavs.uta.edu", false);
		moes.addStudent(unlimitedStudent);
		moes.addStudent(alacarteStudent);
		
		String expected2 = "0) Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)\n1) Tian Raymond (1819912001, 9181rxt@mavs.uta.edu, Account #2)\n";
		String actual2 = moes.getStudentList();
		
		if (!actual2.equals(expected2))
		{
			System.err.println("FAIL: Student list does not match expected list.");
			System.err.println("Expected: " + expected2);
			System.err.println("Actual: " + actual2);
			failureCount++;
		}
		
		// Verify that buying points with the buyPoints method for the student with the Alacarte account results in the message the student followed 
		// by " now has " followed by the expected number of new points followed by " points"
		// When testing, modify the expected3 string
		int buyingPoints = 20;
		String expected3 = "Student now has " + buyingPoints + " points";
		String actual3 = moes.buyPoints(1, buyingPoints); // Test on student 2 (alacarte)
		
		if (!actual3.equals(expected3))
		{
			System.err.println("FAIL: Buying points message does not match for alacarte student.");
			System.err.println("Expected: " + expected3);
			System.err.println("Actual: " + actual3);
			failureCount++;
		}
		
		// Verify that buying points with the buyPoints method for the student with the Unlimited account wresults in the message the student 
		// followed by " has unlimited account and needs no points!"
		// When testing, modify the expected4 string
		String expected4 = "Student has an unlimited account and needs no additional points";
		String actual4 = moes.buyPoints(0, buyingPoints); // Test on student 1 (unlimited) - okay to reuse buyingPoints
		
		if (!actual4.equals(expected4))
		{
			System.err.println("FAIL: Buying points message does not match for unlimited student.");
			System.err.println("Expected: " + expected4);
			System.err.println("Actual: " + actual4);
			failureCount++;
		}
		
		// Verify that getPoints method for the student with the Alacarte account results in the correct number of points returned
		// When testing, modify the expectedAlacartePoints int
		int expectedAlacartePoints = buyingPoints; // buyingPoints was used previously
		int actualAlacartePoints = moes.getPoints(1); // Alacarte student is index 1
		
		if (expectedAlacartePoints != actualAlacartePoints)
		{
			System.err.println("FAIL: getPoints() does not provide correct number of points for alacarte account.");
			System.err.println("Expected: " + expectedAlacartePoints + " points");
			System.err.println("Actual: " + actualAlacartePoints + " points");
			failureCount++;
		}
		
		// Verify that buying points with the buyPoints method for the student with the Unlimited account results in Integer.MAX_VALUE
		// When testing, modify the expectedUnlimitedPoints int 
		int expectedUnlimitedPoints = Integer.MAX_VALUE;
		int actualUnlimitedPoints = moes.getPoints(0); // Unlimited student is index 0
		
		if (expectedUnlimitedPoints != actualUnlimitedPoints)
		{
			System.err.println("FAIL: getPoints() does not provide correct number of points for unlimited account.");
			System.err.println("Expected: " + expectedUnlimitedPoints + " points");
			System.err.println("Actual: " + actualUnlimitedPoints + " points");
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
