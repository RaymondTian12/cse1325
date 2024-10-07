/**
 * Represents an account management system
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since	1.0
 */

package customer;

import product.Media;

// New imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Account
{
	private int accountNumber; 
	private static int nextAccountNumber = 1; // Static and starts with 1
	
	/**
	 * Constructs a new account with a unique associated account number
	 * 
	 * @since	1.0
	 */
	public Account()
	{
		this.accountNumber = nextAccountNumber++;
	}
	
	public Account(BufferedReader br) throws IOException
	{
		this.accountNumber = Integer.parseInt(br.readLine());
		nextAccountNumber = Integer.parseInt(br.readLine());
	}
	 
	public void save(BufferedWriter bw) throws IOException
	{
		bw.write("" + accountNumber + '\n');
		bw.write("" + nextAccountNumber + '\n');
	}
	
	/**
	 * Returns an account's associated account number
	 * 
	 * @return	the account's associated account number
	 * @since	1.0
	 */
	 
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 * An abstract method for playing media. This will be implemented depending on the subclass account type
	 * 
	 * @param media		the media to be played
	 * @return		a string with a message indicating that the media will be played or not
	 * @since		1.0
	 */
	public abstract String play(Media media);
}
