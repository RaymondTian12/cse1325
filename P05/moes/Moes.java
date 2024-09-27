/**
 * Provides an online entertainment system for users to manage their points and purchase media
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since 	1.0
 */

package moes;

import java.util.ArrayList;
import product.Media;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

public class Moes
{
	private ArrayList<Media> library = new ArrayList<>();
	private ArrayList<Student> customers = new ArrayList<>();
	
	/**
	 * Adds a new media object to the library
	 * 
	 * @param media		the new media object to be added
	 * @since 		1.0
	 */
	public void addMedia(Media media)
	{
		library.add(media);
	}
	
	/**
	 * Provides a formatted menu of the media options
	 * 
	 * @return	a string with the media opitons in a formatted output
	 * @since 	1.0
	 */
	public String getMediaList()
	{
		StringBuilder mediaList = new StringBuilder();
		int index = 0;
		for (Media media : library)
		{
			mediaList.append(index).append(") ").append(media.toString()).append("\n");
			index++;
		} 
		
		return mediaList.toString();
	}
	
	/**
	 * Adds a new student to the customer list
	 *
	 * @param student	the new student object to be added
	 * @since 		1.0
	 */
	public void addStudent(Student student)
	{
		customers.add(student);
	}
	
	/**
	 * Provides a formatted menu of the students 
	 *
	 * @return	a string with the students in a formatted output
	 * @since 	1.0
	 */
	public String getStudentList()
	{
		StringBuilder studentList  = new StringBuilder();
		int index = 0;
		for (Student student : customers)
		{
			studentList.append(index).append(") ").append(student.toString()).append("\n");
			index++;
		}
		
		return studentList.toString();
	}
	/**
	 * Provides the number of points the student has 
	 *
	 * @param studentIndex		the index of the student in the list
	 * @return			the number of points this specific student has
	 * @since			1.0
	 */
	public int getPoints(int studentIndex)
	{
		Student student = customers.get(studentIndex); // ArrayList: get used to return element
		Account account = student.getAccount();
		
		if (account instanceof Alacarte)
		{
			return ((Alacarte) account).getPointsRemaining(); 
		}
		else if (account instanceof Unlimited)
		{
			return Integer.MAX_VALUE;
		}
		else
		{
			throw new UnsupportedOperationException("Unknown subclass of Account");
		}
	}
	
	/**
	 * 
	 * @param studentIndex		the index of the student in the list
	 * @param points		the number of points the student has 
	 * @return 			a string with a message indicating the number of points the student has 
	 * @since 			1.0
	 */
	public String buyPoints(int studentIndex, int points)
	{
		Student student = customers.get(studentIndex); 
		Account account = student.getAccount();
		
		if (account instanceof Alacarte)
		{
			((Alacarte) account).buyPoints(points);
			return "Student now has " + ((Alacarte) account).getPointsRemaining() + " points";
		}
		else if (account instanceof Unlimited)
		{
			return "Student has an unlimited account and needs no additional points";
		}
		else
		{
			throw new UnsupportedOperationException("Unknown subclass of Account");
		}
	}
	
	/**
	 * Plays the selected media for a student 
	 *
	 * @param studentIndex		the index of the student in the list
	 * @param mediaindex		the index of the media in the list
	 * @return			a stringindicating the media being played with the updated point count or if the points are insufficient
	 * @since			1.0
	 */
	public String playMedia(int studentIndex, int mediaIndex)
	{
		Student student = customers.get(studentIndex);
		Media media = library.get(mediaIndex);
		
		return student.requestMedia(media);
	}
	
}
