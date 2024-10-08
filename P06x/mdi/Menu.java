package mdi;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
	private ArrayList<MenuItem> items = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);
	
	public void addMenuItem(MenuItem item)
	{
		items.add(item);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int index=0 ; index<items.size() ; ++index)
		{
			sb.append(" " + index + "] " + items.get(index) + "\n"); 
		}
		
		return sb.toString();
	}
	
	public void run(int itemNumber)
	{
		items.get(itemNumber).run();
	}
	
	public static Integer getInt(String prompt, String cancelInput, String defaultInput) 
	{
		Integer i = null;
		while(true) 
		{
			try 
			{
				String s = getString(prompt, cancelInput, defaultInput);
				if(s != null && !s.isEmpty()) i = Integer.parseInt(s);
				{
					break;
				}
			} 
			catch(Exception e) 
			{
				System.err.println("Invalid input!");
			}
		}
		return i;
	}
	
	public static Integer getInt(String prompt, String cancelInput) 
	{
		return getInt(prompt, cancelInput, null);
	}
	
	public static Integer getInt(String prompt) 
	{
		return getInt(prompt, null, null);
	}
	
	public static String getString(String prompt, String cancelInput, String defaultInput) 
	{
		String s = null;
		while(true) 
		{
			try 
			{
				System.out.print(prompt);
				s = in.nextLine().trim();
				if(s.isEmpty() && defaultInput != null) s = defaultInput;
				{
					break;
				}
			} 
			catch(Exception e) 
			{
				System.err.println("Invalid input!");
			}
		}
		
		if(cancelInput != null && s.equals(cancelInput)) 
		{
			s = null;
		}
		
		return s;
	}
	
	public static String getString(String prompt, String cancelInput) 
	{
		return getString(prompt, cancelInput, null);
	}
	
	public static String getString(String prompt) 
	{
		return getString(prompt, null, null);
	}

}
