package mdi;

import java.util.ArrayList;

public class Menu
{
	private ArrayList<MenuItems> items = new ArrayList<>();
	
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
		items.get(index).run();
	}
}
