package mdi;

import java.util.Scanner;
import moes.Moes;
import customer.Student;
import product.Media;

// New imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;

public class Main
{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;
	private String banner;
	private final String extension = ".txt";
	private final String magicCookie = "MoesMagicCookie";
	private final String fileVersion = "1.0";
	private String filename;
	
	private boolean dirty = false; // Initially false - set this to true in the methods that add or modify data
	
	public void newMoes()
	{
		if (dirty)
		{
			int choice = Menu.getInt("You have an unsaved change. What would you like to do?\n" +
						"1) Save the changed data to current file\n" +
						"2) Save to a new file\n" +
						"3) Discard the changed data\n" +
						"4) Abort this command\n" +
						"Selection (enter a number): ");
			switch(choice)
			{
				case 1:
					save();
					dirty = false;
					break;
				case 2:
					saveAs();
					dirty = false;
					break;
				case 3:
					dirty = false;
					break;
				case 4:
					System.out.println("Aborting command");
					return;
				default:
					System.out.println("Invalid option. Please try again");
				   	return;
			}
		}
		
		moes = new Moes(); // Discards the moes field's object in favor of a new one
		dirty = false;
	}
	
	public void save()
	{
		createBackup(filename);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
		{
			bw.write(magicCookie + '\n');
			bw.write(fileVersion + '\n');
			moes.save(bw);
			dirty = false;
		}
		catch (IOException e)
		{
			System.err.println("Error saving to file: " + e.getMessage());
			return;
		}
	}
	
	public void saveAs()
	{
		System.out.println("Current filename: " + filename);
		String newFileName = Menu.getString("Enter a new filename: ");
		
		if (newFileName.isEmpty()) // If user doesn't enter anything, return
		{
			return;
		}
		
		if (!newFileName.endsWith(extension)) // Add file extension if the user doesn't add it 
		{
			newFileName += extension;
		}
		
		filename = newFileName;
		save(); // Sets dirty to false again
	}
	
	private void createBackup(String filePath) 
	{
    		File file = new File(filePath);
    		if (file.exists()) 
    		{ 
        	
        		File backupFile = new File(filePath + "~"); // Create a backup file with a tilde (~) appended

	       		if (backupFile.exists()) 
	       		{
		    		backupFile.delete(); // Remove the old backup if needed 
	       		 }

	       	 	boolean success = file.renameTo(backupFile);
			if (success) 
			{
		    		System.out.println("Auto-Backup created: " + backupFile.getName());
		    		System.out.println("To restore this backup, rename '" + backupFile.getName() +
		    				   "' to '" + file.getName() + "' (after deleting or renaming the current file).");
			} 
        		else 
        		{
            			System.err.println("Failed to create backup.");
        		}
   	 	}
	}
	
	private void open()
	{
		if (dirty)
		{
			int choice = Menu.getInt("You have an unsaved change. What would you like to do?\n" +
						"1) Save the changed data to current file\n" +
						"2) Save to a new file\n" +
						"3) Discard the changed data\n" +
						"4) Abort this command\n");
			switch(choice)
			{
				case 1:
					save();
					dirty = false;
					break;
				case 2:
					saveAs();
					dirty = false;
					break;
				case 3:
					dirty = false;
					break;
				case 4:
					System.out.println("Aborting command");
					return;
				default:
					System.out.println("Invalid option. Please try again");
				   	return;
			}
		}
		
		System.out.println("Curent filename: " + filename);
		String newFileName = Menu.getString("Enter a new file name: ");
		
		if (newFileName.isEmpty())
		{
			return;
		}
		
		if (!newFileName.endsWith(extension))
		{
			newFileName += extension;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(newFileName)))
		{
			String testMagicCookie = br.readLine();
			String testFileVersion = br.readLine();
			
			if (!(testMagicCookie.equals(magicCookie) || !(testFileVersion.equals(fileVersion))))
			{
				throw new IOException("Invalid file was opened");
			}
			
			try
			{
				Moes moes2 = new Moes(br); 
				this.moes = moes2;
				this.filename = newFileName;
			}
			catch (Exception e)
			{
				System.err.println("Failed to resconstruct new Moes object: " + e.getMessage());	
			}
			
		}
		catch (IOException e)
		{
			System.err.println("Error opening file: " + e.getMessage());
			return;
		}
	}
	
	private void addStudent()
	{
		try
		{
			// Note: Student object - name is a string, id is int, email is string, and unlimited is boolean
			String studentName = Menu.getString("Enter Student Name: ");
			if (studentName.isEmpty()) 
			{ 
				return;
	    		}
			Integer studentID = Menu.getInt("Enter Student ID: ");
			if (studentID == null) 
			{ 
				return;
	    		}
			String studentEmail = Menu.getString("Enter Student Email: ");
			if (studentEmail.isEmpty()) 
			{ 
				return;
	    		}
			Integer studentAccount = Menu.getInt("Enter 1 for Alacarte or 2 for Unlimited: ");
			if (studentAccount == null) 
			{ 
				return;
	    		}
			
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
				dirty = true;
			}
			catch (IllegalArgumentException e)
			{
				System.err.println(e.getMessage());
			}
			
			moes.addStudent(student);
		}
		catch (Exception e)
		{
			System.err.println("Unable to add student: " + e.getMessage());
		}
	}
	
	private void listStudents()
	{
		try
		{
			System.out.println(moes.getStudentList());
		}
		catch (Exception e)
		{
			System.err.println("Unable to list students: " + e.getMessage());
		}
	}
	
	private void addMedia()
	{
		String mediaTitle = Menu.getString("Enter Media Title: ");
		if (mediaTitle.isEmpty())
		{
			return;
		}
		String mediaURL = Menu.getString("Enter Media URL: ");
		if (mediaURL.isEmpty())
		{
			return;
		}
		Integer mediaPoints = Menu.getInt("Enter Media Points Required: ");
		if (mediaPoints == null)
		{
			return;
		}
		
		Media media = null;
		
		try 
		{
			media = new Media(mediaTitle, mediaURL, mediaPoints);
			dirty = true;
		} 
		catch (Exception e) 
		{
			System.err.println("Failed to add media: " + e.getMessage());
		}
		
		moes.addMedia(media);
	}
	
	private void listMedia()
	{
		try
		{
			System.out.println(moes.getMediaList());
		}
		catch (Exception e)
		{
			System.err.println("Unable to list media: " + e.getMessage());
		}
	}
	
	private void playMedia()
	{
		try
		{
	    		int studentIndex = Menu.getInt("Enter Student Index: ");
	   		int mediaIndex = Menu.getInt("Enter Media Index: ");
	    
			System.out.println(moes.playMedia(studentIndex, mediaIndex));
		}
		catch (Exception e)
		{
			System.err.println("Unable to play media: " + e.getMessage());
		}
	}
	
	private void listAvailablePoints()
	{
		try
		{
			int studentIndex = Menu.getInt("Enter Student Index: ");
	    		
	    		System.out.println("Available Points: " + moes.getPoints(studentIndex));
	    	}
	    	catch (Exception e)
	    	{
	    		System.err.println("Unable to list available points: " + e.getMessage());
	    	}
	}
	
	private void buyPoints()
	{
		try
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
	    			String result = moes.buyPoints(studentIndex, boughtPoints);
	    			System.out.println(result);
	    			dirty = true;
	    		}
	    	}
	    	catch (Exception e)
	    	{
	    		System.err.println("Unable to buy points: " + e.getMessage());
	    	}

	}
	
	private void mdi()
	{
		while (running) 
		{ 
			try
			{
	       			System.out.println("\n" + menu); 

	       			int choice = Menu.getInt("Select an option: "); // Get user choice
	       			menu.run(choice); // Execute the selected menu item
	       		}
	       		catch (Exception e)
	       		{
	       			System.err.println("Invalid Option: " + e.getMessage());
	       		}
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
		this.filename = "defaultmoes" + extension;
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
		this.dirty = false;
		
		displayBanner();
		
		menu.addMenuItem(new MenuItem("Add Student",		() -> addStudent()));
		menu.addMenuItem(new MenuItem("List Students", 		() -> listStudents()));
		menu.addMenuItem(new MenuItem("Add Media", 		() -> addMedia()));
		menu.addMenuItem(new MenuItem("Play Media", 		() -> playMedia()));
		menu.addMenuItem(new MenuItem("List Media", 		() -> listMedia()));
		menu.addMenuItem(new MenuItem("List Available Points", 	() -> listAvailablePoints()));
		menu.addMenuItem(new MenuItem("Buy Points", 		() -> buyPoints()));
		menu.addMenuItem(new MenuItem("Save to file", 		() -> save())); // Add Save
		menu.addMenuItem(new MenuItem("Save as new file", 	() -> saveAs())); // Add Save As
		menu.addMenuItem(new MenuItem("Open file", 		() -> open())); // Add Open
		menu.addMenuItem(new MenuItem("New MOES file", 		() -> newMoes())); // Add New MOES
		menu.addMenuItem(new MenuItem("Exit", 			() -> endApp()));
	}
	
	public static void main(String[] args)
	{
		Main mainApp = new Main(); 
       		mainApp.mdi();
	}
}
