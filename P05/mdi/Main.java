package mdi;

import java.util.Scanner;
import moes.Moes;
import customer.Student;
import product.Media;

public class Main
{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;
	private String banner;
	
	private void addStudent()
	{
		
		// Note: Student object - name is a string, id is int, email is string, and unlimited is boolean
		String studentName = Menu.getString("Enter Student Name: ");
		int studentID = Menu.getInt("Enter Student ID: ");
		String studentEmail = Menu.getString("Enter Student Email: ");
		int studentAccount = Menu.getInt("Enter 1 for Alacarte or 2 for Unlimited: ");
		
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
		}
		
		Student student = null;
		
		try
		{
			student = new Student(studentName, studentID, studentEmail, unlimitedAccount);
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
		String mediaTitle = Menu.getString("Enter Media Title: ");
		String mediaURL = Menu.getString("Enter Media URL: ");
		int mediaPoints = Menu.getInt("Enter Media Points Required: ");
		
		Media media = null;
		
		try 
		{
			media = new Media(mediaTitle, mediaURL, mediaPoints);
		} 
		catch (IllegalArgumentException e) 
		{
			System.err.println("Failed to add media: " + e.getMessage());
		}
		
		moes.addMedia(media);
	}
	
	private void listMedia()
	{
		System.out.println(moes.getMediaList());
	}
	
	private void playMedia()
	{
    		int studentIndex = Menu.getInt("Enter Student Index: ");
   		int mediaIndex = Menu.getInt("Enter Media Index: ");
    
		System.out.println(moes.playMedia(studentIndex, mediaIndex));

	}
	
	private void listAvailablePoints()
	{
		int studentIndex = Menu.getInt("Enter Student Index: ");
    		
    		System.out.println("Available Points: " + moes.getPoints(studentIndex));

	}
	
	private void buyPoints()
	{
		int studentIndex = Menu.getInt("Enter Student Index: ");
    		
    		System.out.println("Current Points: " + moes.getPoints(studentIndex) + "\n");
    		int boughtPoints = Menu.getInt("How many additional points would you like to buy? ");
    		
    		if (boughtPoints < 0)
    		{
    			System.err.println("You can not purchase negative points!");
    		}
    		else
    		{
    			moes.buyPoints(studentIndex, boughtPoints);
    		}

	}
	
	private void mdi()
	{
		while (running) 
		{ 
       			System.out.println(menu); 

       			int choice = Menu.getInt("Select an option: "); // Get user choice
       			menu.run(choice); // Execute the selected menu item
       		}
	}
	
	private void endApp()
	{
		running = false;
	}
	
	public void displayBanner() 
	{
        	System.out.println(banner);
        }
	
	public Main()
	{
		this.moes = new Moes();
		this.output = "";
		this.menu = new Menu();
		this.running = true;
		this.banner = 	"        _.-._\n" +
				"     .-'     '-.\n" +
				"   .'           '.\n" +
				"  /               \\\n" +
				" |   0       0    |		Version: 1.0 (2024)\n" +
				" |                |		Author: Raymond Tian\n" +
				"  \\              /\n" +
				"   '.  \\---/     .'		We got every media you need!\n" +
				"     '-._____.-'\n" +
				"         | |\n" +
				"         | |\n" +
				"         | |\n" +
				"         | |\n" +
				"         | |\n" +
				"Welcome to the Mavs Online Entertainment System (MOES)!\n\n";
		
		displayBanner();
		
		menu.addMenuItem(new MenuItem("Add Student",		() -> addStudent()));
		menu.addMenuItem(new MenuItem("List Students", 		() -> listStudents()));
		menu.addMenuItem(new MenuItem("Add Media", 		() -> addMedia()));
		menu.addMenuItem(new MenuItem("Play Media", 		() -> playMedia()));
		menu.addMenuItem(new MenuItem("List Media", 		() -> listMedia()));
		menu.addMenuItem(new MenuItem("List Available Points", 	() -> listAvailablePoints()));
		menu.addMenuItem(new MenuItem("Buy Points", 		() -> buyPoints()));
		menu.addMenuItem(new MenuItem("Exit", 			() -> endApp()));
	}
	
	public static void main(String[] args)
	{
		Main mainApp = new Main(); 
       		mainApp.mdi();
	}
}
