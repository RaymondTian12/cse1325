package mdi;

import java.util.Scanner;
import moes.Moes;

public class Main
{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;
	
	private void addStudent()
	{
		Scanner in = new Scanner(System.in);
		
		// Note: Student object - name is a string, id is int, email is string, and unlimited is boolean
		System.out.println("Enter Student Name: ");
		String studentName = in.nextLine();
		
		System.out.println("Enter Student ID: ");
		int studentID = in.nextInt();
		in.nextLine(); // Consume the newline
		
		System.out.println("Enter Student Email: ");
		String studentEmail = in.nextLine();
		
		System.out.println("Enter 1 for Alacarte or 2 for Unlimited: ");
		int studentAccount = in.nextInt();
		in.nextLine(); // Consume the newline
		
		boolean unlimitedAccount = false;
		if (studentAccount == 1)
		{
			unlimitedAccount = false;
		}
		else if (studentAccount == 2)
		{
			unlimitedAccount = true;
		}
		else
		{
			System.err.println("Not a valid account type!");
			System.exit(-1);
		}
		
		try
		{
			Student student = new Student(studentName, studentID, studentEmail, unlimitedAccount);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		
		moes.addStudent(student);
	}
	
	private void listStudents()
	{
		System.out.println(moes.getStudentList());
	}
	
	private void addMedia()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Media Title: ");
		String mediaTitle = in.nextLine();
		
		System.out.println("Enter Media URL: ");
		String mediaURL = in.nextLine();
		
		System.out.println("Enter Media Points Required: ");
		int mediaPoints = in.nextInt();
		in.nextLine(); // Consume the newline
		
		try 
		{
			Media media = new Media(mediaTitle, mediaUrl, mediaPoints);
		} 
		catch (IllegalArgumentException e) 
		{
			System.err.println("Failed to add media: " + e.getMessage());
		}
		
		moes.addMedia(media);
	}
	
	private void listMedia()
	{
		
	}
	
	public static void main(String[] args)
	{
	
	}
}
