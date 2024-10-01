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
		Scanner in = new Scanner(System.in);
		
		// Note: Student object - name is a string, id is int, email is string, and unlimited is boolean
		System.out.print("Enter Student Name: ");
		String studentName = in.nextLine();
		
		System.out.print("Enter Student ID: ");
		int studentID = in.nextInt();
		in.nextLine(); // Consume the newline
		
		System.out.print("Enter Student Email: ");
		String studentEmail = in.nextLine();
		
		System.out.print("Enter 1 for Alacarte or 2 for Unlimited: ");
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
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Media Title: ");
		String mediaTitle = in.nextLine();
		
		System.out.print("Enter Media URL: ");
		String mediaURL = in.nextLine();
		
		System.out.print("Enter Media Points Required: ");
		int mediaPoints = in.nextInt();
		in.nextLine(); // Consume the newline
		
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
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Student Index: ");
    		int studentIndex = in.nextInt();
    
   		System.out.print("Enter Media Index: ");
   		int mediaIndex = in.nextInt();
    
		System.out.println(moes.playMedia(studentIndex, mediaIndex));

	}
	
	private void listAvailablePoints()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Student Index: ");
    		int studentIndex = in.nextInt();
    		
    		System.out.println("Available Points: " + moes.getPoints(studentIndex));

	}
	
	private void buyPoints()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Student Index: ");
    		int studentIndex = in.nextInt();
    		
    		System.out.println("Current Points: " + moes.getPoints(studentIndex) + "\n");
    		System.out.print("How many additional points would you like to buy? ");
    		int boughtPoints = in.nextInt();
    		
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
		Scanner scanner = new Scanner(System.in);
		
		while (running) 
		{ 
       			System.out.println(menu); 
        		System.out.print("Select an option: ");
        
       			int choice = scanner.nextInt(); // Get user choice
        		scanner.nextLine(); // Consume newline
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
