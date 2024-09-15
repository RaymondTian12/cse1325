/**
 * Represents a student's information including the name, ID, email, and account type
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since	1.0
 */

package customer;

import product.Media;

public class Student
{
	private String name;
	private int id;
	private String email;
	private Account account;
	
	/**
	 * Constructs a Student with a name, ID, email, and an unlimited status used to indicate the type
	 * 
	 * @param name		the name of the student
	 * @param id		the student's ID number
	 * @param email		the student's email address
	 * @param unlimited 	indicates if the student has an unlimited or alacarte account
	 * @since		1.0
	 */
	public Student(String name, int id, String email, boolean unlimited)
	{
		if (!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu"))
		{
			throw new IllegalArgumentException("Non-UTA email address: " + email);
		}
		
		this.name = name;
		this.id = id;
		this.email = email;
		
		if (unlimited)
		{
			this.account = new Unlimited();
		}
		else
		{
			this.account = new Alacarte();
		}
	}	
	
	/**
	 * Requests to play the media based on the student's account type
	 * 
	 * @param media		the media that will be played
	 * @return 		a string displaying a play media message depending on the account
	 * @since 		1.0
	 */
	public String requestMedia(Media media)
	{
		return account.play(media);
	}
	
	/**
	 * Returns the student's account type
	 *
	 * @return	the student's account type
	 * @since	1.0
	 */
	public Account getAccount()
	{
		return account;
	}
	
	/**
	 * Returns the string representation of the student's name, ID, email, and account number
	 *
	 * @return	a string with the student's name, ID, email, and account number
	 * @since	1.0
	 */
	@Override
	public String toString()
	{
		return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
	}
}
