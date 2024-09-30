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
		
		System.out.println("Enter Student Name: ");
		String studentName = in.nextLine();
		
		System.out.println("Enter Student ID: ");
		String studentID = in.nextLine();
		
		System.out.println("Enter Student Email: ");
		String studentEmail = in.nextLine();
		
		System.out.println("Enter 1 for Alacarte or 2 for Unlimited: ");
		int studentAccount = in.nextInt();
		
		if (studentAccount == 1)
		{
			Alacarte account = new Alacarte();
		}
		else if (studentAccount == 2)
		{
			Unlimited account = new Unlimited();
		}
		else
		{
			System.err.println("Not a valid account type!");
			System.exit(-1);
		}
		
		Student 
		
	}
	
	private void listStudents()
	{
	
	}
	
	
	
	public static void main(String[] args)
	{
	
	}
}
